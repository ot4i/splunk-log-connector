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

import java.util.Properties;

import com.ibm.connectors.AbstractOutputConnector;
import com.ibm.connectors.AbstractOutputInteraction;
import com.ibm.connectors.ConnectorCallback;
import com.ibm.connectors.ConnectorException;
import com.ibm.connectors.OutputConnector;
import com.ibm.connectors.OutputInteraction;

public class SplunkLogOutputConnector extends AbstractOutputConnector
		implements OutputConnector {

	@Override
	public OutputInteraction createOutputInteraction()
			throws ConnectorException {

		return new SplunkLogOutputInteraction();
	}

}

class SplunkLogOutputInteraction extends AbstractOutputInteraction{

	@Override
	public long asyncSend(Properties properties, Object message, ConnectorCallback callback)
			throws ConnectorException {
		//ignore the asyncSend for now, it is not supported yet
		return 0;
	}

	@Override
	public Properties send(Properties properties, Object message)
			throws ConnectorException {
		// process properties and create connection data
		SplunkConnectionData connData = new SplunkConnectionData(properties);
		SplunkLogMessageData ldata = new SplunkLogMessageData(message, properties);
		
		properties = new SplunkHttpConnection().sendLogEvent(connData, ldata.getLogMessage(), properties);
				
		return properties;
	}
	
}
