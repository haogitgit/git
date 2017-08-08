package com.taotao.httpclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {
	
	@Test
	public void doGet() throws Exception
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://www.baidu.com");
		CloseableHttpResponse response = httpClient.execute(get);
		int state = response.getStatusLine().getStatusCode();
		System.out.println(state);
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity,"utf-8"));
		response.close();
		httpClient.close();
		
	}
	
	@Test
	public void doGetParam() throws Exception
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		URIBuilder uriBuilder = new URIBuilder("http://www.sogou.com/web");
		uriBuilder.setParameter("query", "山东");
		HttpGet get = new HttpGet(uriBuilder.build());
		CloseableHttpResponse response = httpClient.execute(get);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity));
		response.close();
		httpClient.close();
	}
	
	@Test
	public void doPost() throws Exception
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.html");
		CloseableHttpResponse response = httpClient.execute(post);
		System.out.println(EntityUtils.toString(response.getEntity()));
		response.close();
		httpClient.close();
		
	}
	
	@Test
	public void doPostParam() throws Exception
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.html");
		List<NameValuePair> list = new ArrayList<>();
		list.add(new BasicNameValuePair("username", "zhangsan"));
		list.add(new BasicNameValuePair("password", "lisi"));
		StringEntity entity = new UrlEncodedFormEntity(list);
		post.setEntity(entity);
		CloseableHttpResponse response = httpClient.execute(post);
		System.out.println(EntityUtils.toString(response.getEntity()));
		response.close();
		httpClient.close();
	}

}
