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

import com.ibm.connectors.AbstractConnectorFactory;
import com.ibm.connectors.ConnectorException;
import com.ibm.connectors.InputConnector;
import com.ibm.connectors.OutputConnector;
import com.ibm.connectors.RequestConnector;

public class SplunkLogConnectorFactory extends AbstractConnectorFactory {

	@Override
	public InputConnector createInputConnector(String arg0)
			throws ConnectorException {
		return null;
	}

	@Override
	public OutputConnector createOutputConnector(String arg0)
			throws ConnectorException {
 
		return new SplunkLogOutputConnector();
		
	}

	@Override
	public RequestConnector createRequestConnector(String arg0)
			throws ConnectorException {
		return null;
		
	}

	@Override
	public String getInfo() {
		return "SplunkLog";
	}

}
