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
