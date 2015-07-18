# SplunkLog Connector


## Introduction
The SplunkLog connector gives IIB flow developers the opportunity to send log events directly from a message flow rather than though an intermediary layer such as a file or syslog. The connector uses the Splunk REST API to insert the events directly into a Splunk instance.

 
"[...] 

**Splunk** is an American multinational corporation based in San Francisco, California, that produces software for searching, monitoring, and analyzing machine-generated big data, via a web-style interface. 

Splunk (the product) captures, indexes and correlates real-time data in a searchable repository from which it can generate graphs, reports, alerts, dashboards and visualizations.

[...]"  from Wikipedia.

## Installation
There are no releases yet. Feel free to have a look and build the code yourself though.

### Build configuration

1. Import the eclipse projects under src into your workspace.
2. Add the dependencies (listed below)
  1. to the classpath of the SplunkLogConnector project
  2. to the connectors project in the runtime ({iib_workpath}/connectors/SplunkLog)
3. Start Simulation of the SplunkLogNodes project

### Dependencies

The connector uses the following of libraries:
- commons-codec-1.9.jar
- commons-httpclient-contrib.jar
- commons-logging-1.2.jar
- httpclient-4.5.jar
- httpclient-cache-4.5.jar
- httpcore-4.4.1.jar

### Testing

Unless you already have got a Splunk instance to test with, there is a docker image which can be used:
- ` https://registry.hub.docker.com/u/dmaxwell/splunk/ `

## Dev status 

Here is an overview of how far the implementation of the differnt use cases has come so far.

| Use case | Status |
| -------- | ----- |
| Support switching payload logging on/off | Done |
| Logging to Splunk Cloud | Not unit tested |
|Send a log event with basic authentication | Done|
|Send a log event with an authentication token | Not yet |
|Send a log event though an HTTPS connection | Done|
|Send a log event though an HTTP connection without SSL | Not tested|
|Support keyAlias for mutual authentication | Not yet|
|Make the HTTP connection reusable | To some extend|
|Send a log event with fields configured in the connector node | Done|
|Send a log event with additional dynamic fields | Done|
|Send a log event in Stream mode | Not yet|
|Use integration server truststore | Done|
|Exception handling | Basic|

 