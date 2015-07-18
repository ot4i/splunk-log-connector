package com.ibm.connectors.splunklog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


public class SplunkLogMessageData {
	// extract custom fields
	
	private List<Parameter> params = new ArrayList<Parameter>();
	private byte[] logMessage;
	private boolean includePayload = true;

	public SplunkLogMessageData (Object message, Properties props){
		this.processProperties(props);
		this.processInputMessage(message);
	}
	
	private void processProperties(Properties props) {

		this.params.add(new Parameter("timestamp", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(new java.util.Date())));
		//this.params.add(new Parameter("index", props.getProperty("index","not specified")));
		for (Object k : props.keySet())
		{
		    String key = k.toString();
	    	if(key.equalsIgnoreCase("includePayload")){
	    		this.includePayload = props.getProperty(key).equalsIgnoreCase("true");
	    	}
		    if (key.startsWith("splunk_")) {
		    	this.params.add(new Parameter(key.substring("splunk_".length()), props.getProperty(key)));
		    }
		}

	}
	
	private void processInputMessage(Object msgObject){
		
		byte[] prefix = (this.getParams().size()>0) ? (this.getFormattedParamList() + ", Payload: ").getBytes() : "Payload: ".getBytes();
		byte[] msg = null;
		if (this.includePayload){
			if (msgObject instanceof byte[]) {
				msg = (byte[])msgObject;
				if (msg.length<1) {
					msg="Empty!".getBytes();
				}

			} else{
				try {
					throw new Exception("Message should have been of type byte[]");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			msg = "Not logged.".getBytes();
		}
		this.logMessage = new byte[prefix.length + msg.length];
		System.arraycopy(prefix, 0, this.logMessage, 0, prefix.length);
		System.arraycopy(msg, 0, this.logMessage, prefix.length, msg.length);		
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