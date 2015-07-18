package com.ibm.connectors.splunklog;

import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Properties;

import org.apache.http.client.utils.URIBuilder;

import com.ibm.connectors.ConnectorException;

public class SplunkConnectionData {

	// URI
	// Determines whether SSL, Stream or HTTPRest should be used
	// Should only worry about technical aspects
	// Should provide access to allow adding of additional fields to the URI
	// 
	
	private URI splunkURI;
	private URIBuilder myUriBuilder;
	private String host;
	private String port;
	private String user;
	private String pass;
	private String scheme;
	private Boolean ignoreSplunkErrors;
	
	public SplunkConnectionData(Properties props)throws ConnectorException{
		this.populateURI(props);
	}
	
	private void populateURI(Properties props)throws ConnectorException{
		this.setHost(props.getProperty("host",""));
		if(this.getHost().equalsIgnoreCase("")){throw new ConnectorException("No host name configured for Splunk target.");};
		this.setPort(props.getProperty("port","8089"));
		this.setScheme(props.getProperty("usehttps","false").equalsIgnoreCase("true") ? "https" : "http");
		String resource = props.getProperty("resource");
		this.setUser(props.getProperty("user"));
		this.setPass(props.getProperty("pass"));
		this.setIgnoreSplunkErrors(props.getProperty("ignoreSplunkErrors","").equalsIgnoreCase("true"));
		
		this.myUriBuilder = new URIBuilder();
		this.myUriBuilder.setHost(host);
		this.myUriBuilder.setPort(Integer.parseInt(port));
		this.myUriBuilder.setScheme(scheme);
		this.myUriBuilder.setPath(resource);
		this.myUriBuilder.addParameter("source", props.getProperty("source", "noSource"));
		if(!props.getProperty("index","").isEmpty()){
			this.myUriBuilder.addParameter("index", props.getProperty("index"));
		}
		this.myUriBuilder.addParameter("sourcetype", props.getProperty("sourcetype", "not specified"));
		this.myUriBuilder.addParameter("host", getLocalhost());
		
	}

	public URI getSplunkURI() throws ConnectorException{
		try {
			this.setSplunkURI(this.myUriBuilder.build());
		} catch (URISyntaxException e) {
			e.fillInStackTrace();
			throw new ConnectorException(e.toString());
		}
		return this.splunkURI;
	}
	
	public void addURIparameter(String name, String value){
		this.myUriBuilder.addParameter(name, value);
	}

	private void setSplunkURI(URI splunkURI) {
		this.splunkURI = splunkURI;
	}
	
	private String getLocalhost(){
		String hostname = "";
		try {
			hostname = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			return hostname;
		}
		return hostname;
	}

	public String getHost() {
		return host;
	}

	private void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	private void setPort(String port) {
		this.port = port;
	}

	public String getScheme() {
		return scheme;
	}

	private void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getUser() {
		return user;
	}

	private void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	private void setPass(String pass) {
		this.pass = pass;
	}

	public Boolean getIgnoreSplunkErrors() {
		return ignoreSplunkErrors;
	}

	public void setIgnoreSplunkErrors(Boolean ignoreSplunkErrors) {
		this.ignoreSplunkErrors = ignoreSplunkErrors;
	}
	

}
