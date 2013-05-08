package com.ijoshluisaac.restful.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
 
public class RESTFulClientPost {
 
private static final String JSON_OBJECT = "{\"name\":\"Joshua Uzochukwu Nwankwo\",\"email\":\"joshluisaac@gmail.com\",\"about\":\"Motivated and goal orinted\",\"file\":\"NA\"}";

	
	public RESTFulClientPost(){
		
	}
	
	public static void main(String[] args) {
 
	  try {
 
		URL url = new URL("http://sr-recruit.herokuapp.com/");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
 
		
		OutputStream os = conn.getOutputStream();
		os.write(RESTFulClientPost.JSON_OBJECT.getBytes());
		os.flush();
 
		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
 
		String output;
		System.out.println("Successfully Posted Data Via JSON ..... \n");
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

