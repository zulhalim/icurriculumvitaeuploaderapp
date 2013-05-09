package com.ijoshluisaac.restful.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONPost {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		 // JSON content to post
	     java.lang.String contentToPost = "{\"name\": \"Ravindra Gullapalli\"}";
	     // Create a URLConnection
	     //java.net.URLConnection connection = new java.net.URL("http://sr-recruit.herokuapp.com/").openConnection();
	     
	     
			URL url = new URL("http://www.profitera.com/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	     
	     connection.setUseCaches(false);
	     connection.setDoInput(true);
	     connection.setDoOutput(true);
	     connection.setRequestMethod("POST");
	     connection.setRequestProperty("Content-Length", "" + contentToPost.length());
	     // To post JSON content, set the content type to application/json OR application/jsonrequest [Reference]
	     connection.setRequestProperty("Content-Type", "application/json");
	     connection.setRequestProperty("Cache-Control", "no-cache");
	     
	     System.out.println(connection.getResponseCode());
	     // Post your content
	     java.io.OutputStream stream = connection.getOutputStream();
	     stream.write(contentToPost.getBytes());
	     stream.close();
	     // Read the response
	     java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(connection.getInputStream()));
	     java.lang.StringBuffer sb = new java.lang.StringBuffer();
	     java.lang.String str = br.readLine();
	     while(str != null){
	           sb.append(str);
	           str = br.readLine();
	     }
	     br.close();
	     java.lang.String responseString = sb.toString();

	}

}
