package com.ijoshluisaac.restful.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
 
public class ApacheHttpClientPost {
	
	private static final String JSON_OBJECT = "{\"name\":\"Joshua Uzochukwu Nwankwo\",\"email\":\"joshluisaac@gmail.com\",\"about\":\"Motivated and goal orinted\",\"file\":\"NA\"}";

 
	public static void main(String[] args) {
 
	  try {
 
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost(
			"http://sr-recruit.herokuapp.com/");
 
		StringEntity input = new StringEntity(ApacheHttpClientPost.JSON_OBJECT);
		input.setContentType("application/json");
		postRequest.setEntity(input);
 
		HttpResponse response = httpClient.execute(postRequest);
 
		if (response.getStatusLine().getStatusCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatusLine().getStatusCode());
		}
 
		BufferedReader br = new BufferedReader(
                        new InputStreamReader((response.getEntity().getContent())));
 
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
 
		httpClient.getConnectionManager().shutdown();
 
	  } catch (MalformedURLException e) {
 
		e.printStackTrace();
 
	  } catch (IOException e) {
 
		e.printStackTrace();
 
	  }
 
	}
 
}
