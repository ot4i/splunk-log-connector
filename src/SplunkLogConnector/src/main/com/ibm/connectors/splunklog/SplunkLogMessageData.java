/*

Copyright 2015 IBM Corporation
Author: Carsten Börnert

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

*/

package com.ibm.connectors.splunklog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.ibm.connectors.ConnectorException;


public class SplunkLogMessageData {
	// extract custom fields
	
	private List<Parameter> params = new ArrayList<Parameter>();
	private byte[] logMessage;
	private boolean includePayload = true;
	private boolean useSourceType = false;

	public SplunkLogMessageData (Object message, Properties props) throws ConnectorException{
		this.processProperties(props);
		this.processInputMessage(message);
	}
	
	private void processProperties(Properties props) {
		if (!props.containsKey("splunk_timestamp")) {
			this.params.add(new Parameter("timestamp", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(new java.util.Date())));
		} else {
			this.params.add(new Parameter("timestamp", props.getProperty("splunk_timestamp")));
		}
		
		//this.params.add(new Parameter("index", props.getProperty("index","not specified")));
		for (Object k : props.keySet())
		{
		    String key = k.toString();
	    	if(key.equalsIgnoreCase("includePayload")){
	    		this.includePayload = props.getProperty(key).equalsIgnoreCase("true");
	    	}
	    	if(key.equalsIgnoreCase("useSourceType")){
	    		this.useSourceType = props.getProperty(key).equalsIgnoreCase("true");
	    	}
		    if (key.startsWith("splunk_") && !key.equalsIgnoreCase("splunk_timestamp")) {
		    	this.params.add(new Parameter(key.substring("splunk_".length()), props.getProperty(key)));
		    }
		}

	}
	
	private void processInputMessage(Object msgObject) throws ConnectorException {
		byte[] msg = null;
		
		if (this.useSourceType) {
			if (msgObject instanceof byte[]) {
				msg = (byte[])msgObject;
				this.logMessage = msg;
			} else {throw new ConnectorException("Message should have been of type byte[]");}
				
			
		} else {

		
			byte[] prefix = (this.getParams().size()>0) ? (this.getFormattedParamList() + ", Payload: ").getBytes() : "Payload: ".getBytes();
			
			if (this.includePayload){
				if (msgObject instanceof byte[]) {
					msg = (byte[])msgObject;
					if (msg.length<1) {
						msg="Empty!".getBytes();
					}
				} else {throw new ConnectorException("Message should have been of type byte[]");}
			} else {
				msg = "Not logged.".getBytes();
			}
			
			this.logMessage = new byte[prefix.length + msg.length];
			System.arraycopy(prefix, 0, this.logMessage, 0, prefix.length);
			System.arraycopy(msg, 0, this.logMessage, prefix.length, msg.length);
		}
		
	}
	
	
	public List<Parameter> getParams() {
		return params;
	}
	
	private String getFormattedParamList(){
		StringBuilder sb = new StringBuilder("");
		for (Iterator<Parameter> param = this.params.iterator(); param.hasNext();) {
			Parameter p = (Parameter) param.next();
			sb.append(p.getName());
			sb.append("=");
			sb.append(p.getValue());
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	public byte[] getLogMessage() {
		return this.logMessage;
	}
	

}	