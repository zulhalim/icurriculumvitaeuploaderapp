package com.zulkifli.restful.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
 
public class RESTFulClientGetUsingJavaHTTPClientLibrary {
 
	public static void main(String[] args) {
 
	  try {
 
		URL url = new URL("http://sr-recruit.herokuapp.com/");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		System.out.println(conn.getResponseCode());
		
		
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP Response Error Code: "
					+ conn.getResponseCode());
		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
 
		String output;
		System.out.println("Successfully Executed RESTFul GET Using Java HTTP Client Library .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
 
		conn.disconnect();
 
	  } catch (MalformedURLException e) {
 
		e.printStackTrace();
 
	  } catch (IOException e) {
 
		e.printStackTrace();
 
	  }
 
	}
 
}
