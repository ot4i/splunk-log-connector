package com.ibm.connectors.splunklog;

import com.ibm.broker.config.appdev.InputTerminal;
import com.ibm.broker.config.appdev.Node;
import com.ibm.broker.config.appdev.NodeProperty;
import com.ibm.broker.config.appdev.OutputTerminal;

/*** 
 * <p>  <I>SplunkLogOutputNodeUDN</I> instance</p>
 * <p></p>
 */
public class SplunkLogOutputNodeUDN extends Node {

	private static final long serialVersionUID = 1L;

	// Node constants
	protected final static String NODE_TYPE_NAME = "com/ibm/connectors/splunklog/OutputNode";
	protected final static String NODE_GRAPHIC_16 = "platform:/plugin/SplunkLogNodes/icons/full/obj16/com/ibm/connectors/splunklog/ComIbmOutput.gif";
	protected final static String NODE_GRAPHIC_32 = "platform:/plugin/SplunkLogNodes/icons/full/obj30/com/ibm/connectors/splunklog/ComIbmOutput.gif";

	protected final static String PROPERTY_CONNECTORNAME = "connectorName";
	protected final static String PROPERTY_HOST = "host";
	protected final static String PROPERTY_PORT = "port";
	protected final static String PROPERTY_SPLUNK_EVENT = "splunk_Event";
	protected final static String PROPERTY_USER = "user";
	protected final static String PROPERTY_PASS = "pass";
	protected final static String PROPERTY_USEHTTPS = "usehttps";
	protected final static String PROPERTY_INCLUDEPAYLOAD = "includePayload";
	protected final static String PROPERTY_INDEX = "index";
	protected final static String PROPERTY_RESOURCE = "resource";
	protected final static String PROPERTY_SPLUNK_LOGLEVEL = "splunk_loglevel";

	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_CONNECTORNAME,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "SplunkLog","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_HOST,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.STRING, "","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_PORT,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.STRING, "","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_SPLUNK_EVENT,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_USER,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_PASS,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_USEHTTPS,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.BOOLEAN, "true","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_INCLUDEPAYLOAD,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.BOOLEAN, "true","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_INDEX,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_RESOURCE,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.STRING, "/services/receivers/simple","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_SPLUNK_LOGLEVEL,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "INFO","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes")
		};
	}

	public SplunkLogOutputNodeUDN() {
	}

	public final InputTerminal INPUT_TERMINAL_IN = new InputTerminal(this,"InTerminal.in");
	@Override
	public InputTerminal[] getInputTerminals() {
		return new InputTerminal[] {
			INPUT_TERMINAL_IN
	};
	}

	public final OutputTerminal OUTPUT_TERMINAL_OUT = new OutputTerminal(this,"OutTerminal.out");
	@Override
	public OutputTerminal[] getOutputTerminals() {
		return new OutputTerminal[] {
			OUTPUT_TERMINAL_OUT
		};
	}

	@Override
	public String getTypeName() {
		return NODE_TYPE_NAME;
	}

	protected String getGraphic16() {
		return NODE_GRAPHIC_16;
	}

	protected String getGraphic32() {
		return NODE_GRAPHIC_32;
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>connectorName</I>"
	 */
	public SplunkLogOutputNodeUDN setConnectorName(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_CONNECTORNAME, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @return String; the value of the property "<I>connectorName</I>"
	 */
	public String getConnectorName() {
		return (String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_CONNECTORNAME);
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>host</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>host</I>"
	 */
	public SplunkLogOutputNodeUDN setHost(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_HOST, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>host</I>" property
	 * 
	 * @return String; the value of the property "<I>host</I>"
	 */
	public String getHost() {
		return (String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_HOST);
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>port</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>port</I>"
	 */
	public SplunkLogOutputNodeUDN setPort(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_PORT, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>port</I>" property
	 * 
	 * @return String; the value of the property "<I>port</I>"
	 */
	public String getPort() {
		return (String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_PORT);
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>splunk_Event</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>splunk_Event</I>"
	 */
	public SplunkLogOutputNodeUDN setSplunk_Event(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_SPLUNK_EVENT, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>splunk_Event</I>" property
	 * 
	 * @return String; the value of the property "<I>splunk_Event</I>"
	 */
	public String getSplunk_Event() {
		return (String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_SPLUNK_EVENT);
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>user</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>user</I>"
	 */
	public SplunkLogOutputNodeUDN setUser(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_USER, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>user</I>" property
	 * 
	 * @return String; the value of the property "<I>user</I>"
	 */
	public String getUser() {
		return (String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_USER);
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>pass</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>pass</I>"
	 */
	public SplunkLogOutputNodeUDN setPass(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_PASS, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>pass</I>" property
	 * 
	 * @return String; the value of the property "<I>pass</I>"
	 */
	public String getPass() {
		return (String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_PASS);
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>usehttps</I>" property
	 * 
	 * @param value boolean ; the value to set the property "<I>usehttps</I>"
	 */
	public SplunkLogOutputNodeUDN setUsehttps(boolean value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_USEHTTPS, String.valueOf(value));
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>usehttps</I>" property
	 * 
	 * @return boolean; the value of the property "<I>usehttps</I>"
	 */
	public boolean getUsehttps(){
	if (getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_USEHTTPS).equals("true")){
		return true;
	} else {
		return false;
		}
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>includePayload</I>" property
	 * 
	 * @param value boolean ; the value to set the property "<I>includePayload</I>"
	 */
	public SplunkLogOutputNodeUDN setIncludePayload(boolean value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_INCLUDEPAYLOAD, String.valueOf(value));
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>includePayload</I>" property
	 * 
	 * @return boolean; the value of the property "<I>includePayload</I>"
	 */
	public boolean getIncludePayload(){
	if (getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_INCLUDEPAYLOAD).equals("true")){
		return true;
	} else {
		return false;
		}
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>index</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>index</I>"
	 */
	public SplunkLogOutputNodeUDN setIndex(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_INDEX, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>index</I>" property
	 * 
	 * @return String; the value of the property "<I>index</I>"
	 */
	public String getIndex() {
		return (String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_INDEX);
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>resource</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>resource</I>"
	 */
	public SplunkLogOutputNodeUDN setResource(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_RESOURCE, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>resource</I>" property
	 * 
	 * @return String; the value of the property "<I>resource</I>"
	 */
	public String getResource() {
		return (String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_RESOURCE);
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>Log level</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Log level</I>"
	 */
	public SplunkLogOutputNodeUDN setSplunk_loglevel(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_SPLUNK_LOGLEVEL, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>Log level</I>" property
	 * 
	 * @return String; the value of the property "<I>Log level</I>"
	 */
	public String getSplunk_loglevel() {
		return (String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_SPLUNK_LOGLEVEL);
	}

	public String getNodeName() {
		String retVal = super.getNodeName();
		if ((retVal==null) || retVal.equals(""))
			retVal = "SplunkLogOutput";
		return retVal;
	};
}
