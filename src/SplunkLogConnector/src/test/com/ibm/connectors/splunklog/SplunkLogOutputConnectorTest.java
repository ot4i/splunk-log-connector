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

import static org.junit.Assert.fail;

import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ibm.connectors.ConnectorException;
import com.ibm.connectors.OutputInteraction;

public class SplunkLogOutputConnectorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateOutputInteraction() {
//		fail("Not yet implemented");
		OutputInteraction oi = null;
		try {
			oi = new SplunkLogOutputConnector().createOutputInteraction();
		} catch (ConnectorException e) {
			e.printStackTrace();
		}
		if (oi == null) {
			fail("unable to get outputinteraction");
		} else {
			Properties props = new Properties();
			props.setProperty("host", "192.168.56.1");
			props.setProperty("resource", "/services/receivers/simple");
			props.setProperty("usehttps", "yes");
			props.setProperty("splunk_UT", "yes!");
			props.setProperty("splunk_TestParam2", "lkadskjadkjsfjkldsjf");
//			
			
			props.setProperty("user", "admin");
			props.setProperty("pass", "tester");
			
			byte[] payload = "".getBytes();
			
			
			try {
				Properties result = null;
				result = oi.send(props, payload);
				if (result.getProperty("status") == null) {
					fail("No status returned");
				} else {
					System.out.println(result.getProperty("status"));
				}
			} catch (ConnectorException e) {
				e.printStackTrace();
			}
		}
	}

}
