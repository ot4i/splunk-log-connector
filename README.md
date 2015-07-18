# SplunkLog Connector for IIB


## Introduction
The SplunkLog connector gives IIB flow developers the opportunity to send log events directly from a message flow rather than though an intermediary layer such as a file or syslog. The connector uses the Splunk REST API to insert the events directly into a Splunk instance.

 
"[...] 

**Splunk** is an American multinational corporation based in San Francisco, California, that produces software for searching, monitoring, and analyzing machine-generated big data, via a web-style interface. 

Splunk (the product) captures, indexes and correlates real-time data in a searchable repository from which it can generate graphs, reports, alerts, dashboards and visualizations.

[...]"  from Wikipedia.

## Installation


### Build configuration

...

### Dependencies

...

## Use cases 

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

 