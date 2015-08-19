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

import java.io.IOException;
import java.util.Properties;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;

import com.ibm.connectors.ConnectorException;

public class SplunkHttpConnection
{
  private HttpClientConnectionManager cm;
  
  public SplunkHttpConnection()
  {
    createHttpClient();
  }
  
  public void createHttpClient()
  {
    PlainConnectionSocketFactory sf = PlainConnectionSocketFactory.getSocketFactory();
    SSLContext sslContext = SSLContexts.createSystemDefault();
    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
      sslContext, 
      NoopHostnameVerifier.INSTANCE);
    
    Registry<ConnectionSocketFactory> r = RegistryBuilder.<ConnectionSocketFactory>create()
            .register("http", sf)
            .register("https", sslsf)
            .build();
    
    this.cm = new PoolingHttpClientConnectionManager(r);
  }
  
  public Properties sendLogEvent(SplunkConnectionData connData, byte[] thePayload, Properties properties)
    throws ConnectorException
  {
    HttpClient myhClient = HttpClients.custom().setConnectionManager(this.cm).build();
    
    HttpClientContext myhContext = HttpClientContext.create();
    
    CredentialsProvider credsProvider = new BasicCredentialsProvider();
    credsProvider.setCredentials(
      new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT), 
      new UsernamePasswordCredentials(connData.getUser(), connData.getPass()));
    AuthCache authCache = new BasicAuthCache();
    authCache.put(new HttpHost(connData.getHost(), Integer.parseInt(connData.getPort()), connData.getScheme()), new BasicScheme());
    
    myhContext.setCredentialsProvider(credsProvider);
    myhContext.setAuthCache(authCache);
    
    HttpPost myhPost = new HttpPost(connData.getSplunkURI());
    
    ByteArrayEntity payload = new ByteArrayEntity(thePayload);
    try
    {
      myhPost.setEntity(payload);
      HttpResponse response = myhClient.execute(myhPost, myhContext);
      Integer statusCode = response.getStatusLine().getStatusCode();
      if (statusCode != 200 && !connData.getIgnoreSplunkErrors()) {
		throw new ConnectorException("Error posting log event to Splunk: " + response.getStatusLine().toString());
	}      
      System.out.println(response.getStatusLine().toString());
      properties.setProperty("status", String.valueOf(statusCode));
      Integer leasedConns = Integer.valueOf(((PoolingHttpClientConnectionManager)this.cm).getTotalStats().getLeased());
      properties.setProperty("conns_leased", leasedConns.toString());
      Integer availConns = Integer.valueOf(((PoolingHttpClientConnectionManager)this.cm).getTotalStats().getAvailable());
      properties.setProperty("conns_available", availConns.toString());
    }
    catch (IOException e)
    {
      e.fillInStackTrace();
      throw new ConnectorException(e.toString());
    }
    return properties;
  }
}
