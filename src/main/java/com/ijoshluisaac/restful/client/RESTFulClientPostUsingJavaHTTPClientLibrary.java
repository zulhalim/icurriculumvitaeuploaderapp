package com.ijoshluisaac.restful.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RESTFulClientPostUsingJavaHTTPClientLibrary {
	
	// JSON content to post
	private static final String JSON_OBJECT = "{\"name\":\"Joshua U. Nwankwo\",\"email\":\"joshluisaac@gmail.com\",\"about\":\"Motivated,Loves new challenging stuffs and goal orinted\"}";
    
	//Web services URLs
	private static final String URL_SR = "http://sr-recruit.herokuapp.com/resumes";
    private static final String URL_HK = "http://localhost:8080/RESTfulresume/restservicespath/json/resume/post";

	public static void main(String[] args) {

		try {
			URL url = new URL(URL_SR);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			
			OutputStream os = conn.getOutputStream();
			os.write(JSON_OBJECT.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Successfully Executed RESTFul POST .... \n");
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