package com.ibm.connectors.splunklog;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.connectors.splunklog.SplunkLogMessageData;

public class LogMessageDataTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogMessageData() {
		byte[] message = "".getBytes();
		Properties properties = new Properties();
		properties.put("test", "testing");
		properties.put("splunk_test", "testing2");
		
		SplunkLogMessageData ldata = new SplunkLogMessageData(message, properties);
		assertEquals("Expected parameter list size of 1.", 1, ldata.getParams().size());
		
		assertEquals("Expected property name test.", "test", ldata.getParams().get(0).getName());
	}
	
	@Test
	public void testGetLogMessage_EmptyPayload() {
		byte[] message = "".getBytes();
		Properties properties = new Properties();
		SplunkLogMessageData ldata = new SplunkLogMessageData(message, properties);
		assertEquals("Expected msg saying the payload is empty.","Payload: Empty!", new String(ldata.getLogMessage()));
	}
	
	@Test
	public void testGetLogMessage_WithPayload() {
		byte[] message = "X".getBytes();
		Properties properties = new Properties();
		SplunkLogMessageData ldata = new SplunkLogMessageData(message, properties);
		assertEquals("Expected msg with payload.","Payload: X", new String(ldata.getLogMessage()));
	}
	
	@Test
	public void testGetLogMessage_withProps() {
		byte[] message = "".getBytes();
		Properties properties = new Properties();
		properties.put("splunk_UT", "true");
		properties.put("splunk_UT2", "false");
		
		SplunkLogMessageData ldata = new SplunkLogMessageData(message, properties);
		assertEquals("Expected msg with 2 props and empty payload.","UT2=false,UT=true, Payload: Empty!", new String(ldata.getLogMessage()));
	}
	
	

}
