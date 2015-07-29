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
	protected final static String PROPERTY_USER = "user";
	protected final static String PROPERTY_PASS = "pass";
	protected final static String PROPERTY_USEHTTPS = "usehttps";
	protected final static String PROPERTY_SPLUNK_LOGLEVEL = "splunk_loglevel";
	protected final static String PROPERTY_SPLUNK_EVENT = "splunk_Event";
	protected final static String PROPERTY_EVENT_SOURCE_COMPONENT = "event_source_component";
	protected final static String PROPERTY_EVENT_SOURCE_HOST = "event_source_host";
	protected final static String PROPERTY_INCLUDEPAYLOAD = "includePayload";
	protected final static String PROPERTY_USESOURCETYPE = "useSourceType";
	protected final static String PROPERTY_SOURCETYPE = "sourcetype";
	protected final static String PROPERTY_INDEX = "index";
	protected final static String PROPERTY_RESOURCE = "resource";
	protected final static String PROPERTY_IGNORESPLUNKERRORS = "ignoreSplunkErrors";


	/**
	 * <I>ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL</I>
	 * <pre>
	 * ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.DEBUG = DEBUG
	 * ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.INFO = INFO
	 * ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.WARN = WARN
	 * ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.ERROR = ERROR
	 * ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.FATAL = FATAL
	 * </pre>
	 */
	public static class ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL {
		private String value;

		public static final ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL DEBUG = new ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL("DEBUG");
		public static final ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL INFO = new ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL("INFO");
		public static final ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL WARN = new ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL("WARN");
		public static final ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL ERROR = new ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL("ERROR");
		public static final ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL FATAL = new ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL("FATAL");

		protected ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL getEnumFromString(String enumValue) {
			ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL enumConst = ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.DEBUG;
			if (ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.INFO.value.equals(enumValue)) enumConst = ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.INFO;
			if (ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.WARN.value.equals(enumValue)) enumConst = ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.WARN;
			if (ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.ERROR.value.equals(enumValue)) enumConst = ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.ERROR;
			if (ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.FATAL.value.equals(enumValue)) enumConst = ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.FATAL;
			return enumConst;
		}

		public static String[] values = new String[]{ "DEBUG", "INFO", "WARN", "ERROR", "FATAL" };

	}
	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_CONNECTORNAME,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "SplunkLog","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_HOST,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.STRING, "","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_PORT,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.STRING, "","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_USER,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_PASS,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_USEHTTPS,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.BOOLEAN, "true","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_SPLUNK_LOGLEVEL,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.ENUMERATION, "INFO", ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.class,"","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_SPLUNK_EVENT,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_EVENT_SOURCE_COMPONENT,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_EVENT_SOURCE_HOST,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_INCLUDEPAYLOAD,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.BOOLEAN, "true","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_USESOURCETYPE,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.BOOLEAN, "false","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_SOURCETYPE,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_INDEX,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_RESOURCE,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.STRING, "/services/receivers/simple","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes"),
			new NodeProperty(SplunkLogOutputNodeUDN.PROPERTY_IGNORESPLUNKERRORS,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.BOOLEAN, "false","","",	"com/ibm/connectors/splunklog/ComIbmOutput",	"SplunkLogNodes")
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
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>User</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>User</I>"
	 */
	public SplunkLogOutputNodeUDN setUser(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_USER, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>User</I>" property
	 * 
	 * @return String; the value of the property "<I>User</I>"
	 */
	public String getUser() {
		return (String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_USER);
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>Password</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Password</I>"
	 */
	public SplunkLogOutputNodeUDN setPass(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_PASS, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>Password</I>" property
	 * 
	 * @return String; the value of the property "<I>Password</I>"
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
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>Log level</I>" property
	 * 
	 * @param value ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL ; the value to set the property "<I>Log level</I>"
	 */
	public SplunkLogOutputNodeUDN setSplunk_loglevel(ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_SPLUNK_LOGLEVEL, value.toString());
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>Log level</I>" property
	 * 
	 * @return ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL; the value of the property "<I>Log level</I>"
	 */
	public ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL getSplunk_loglevel() {
		ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL value = ENUM_SPLUNKLOGOUTPUT_SPLUNK_LOGLEVEL.getEnumFromString((String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_SPLUNK_LOGLEVEL));
		return value;
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
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>EventSource(Component)</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>EventSource(Component)</I>"
	 */
	public SplunkLogOutputNodeUDN setEvent_source_component(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_EVENT_SOURCE_COMPONENT, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>EventSource(Component)</I>" property
	 * 
	 * @return String; the value of the property "<I>EventSource(Component)</I>"
	 */
	public String getEvent_source_component() {
		return (String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_EVENT_SOURCE_COMPONENT);
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>EventSource(Host)</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>EventSource(Host)</I>"
	 */
	public SplunkLogOutputNodeUDN setEvent_source_host(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_EVENT_SOURCE_HOST, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>EventSource(Host)</I>" property
	 * 
	 * @return String; the value of the property "<I>EventSource(Host)</I>"
	 */
	public String getEvent_source_host() {
		return (String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_EVENT_SOURCE_HOST);
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
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>Use source type</I>" property
	 * 
	 * @param value boolean ; the value to set the property "<I>Use source type</I>"
	 */
	public SplunkLogOutputNodeUDN setUseSourceType(boolean value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_USESOURCETYPE, String.valueOf(value));
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>Use source type</I>" property
	 * 
	 * @return boolean; the value of the property "<I>Use source type</I>"
	 */
	public boolean getUseSourceType(){
	if (getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_USESOURCETYPE).equals("true")){
		return true;
	} else {
		return false;
		}
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>Source type</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Source type</I>"
	 */
	public SplunkLogOutputNodeUDN setSourcetype(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_SOURCETYPE, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>Source type</I>" property
	 * 
	 * @return String; the value of the property "<I>Source type</I>"
	 */
	public String getSourcetype() {
		return (String)getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_SOURCETYPE);
	}

	/**
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>Index</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Index</I>"
	 */
	public SplunkLogOutputNodeUDN setIndex(String value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_INDEX, value);
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>Index</I>" property
	 * 
	 * @return String; the value of the property "<I>Index</I>"
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
	 * Set the <I>SplunkLogOutputNodeUDN</I> "<I>ignoreSplunkErrors</I>" property
	 * 
	 * @param value boolean ; the value to set the property "<I>ignoreSplunkErrors</I>"
	 */
	public SplunkLogOutputNodeUDN setIgnoreSplunkErrors(boolean value) {
		setProperty(SplunkLogOutputNodeUDN.PROPERTY_IGNORESPLUNKERRORS, String.valueOf(value));
		return this;
	}

	/**
	 * Get the <I>SplunkLogOutputNodeUDN</I> "<I>ignoreSplunkErrors</I>" property
	 * 
	 * @return boolean; the value of the property "<I>ignoreSplunkErrors</I>"
	 */
	public boolean getIgnoreSplunkErrors(){
	if (getPropertyValue(SplunkLogOutputNodeUDN.PROPERTY_IGNORESPLUNKERRORS).equals("true")){
		return true;
	} else {
		return false;
		}
	}

	public String getNodeName() {
		String retVal = super.getNodeName();
		if ((retVal==null) || retVal.equals(""))
			retVal = "SplunkLogOutput";
		return retVal;
	};
}
