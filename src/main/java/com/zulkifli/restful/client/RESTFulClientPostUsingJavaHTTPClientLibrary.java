package com.zulkifli.restful.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RESTFulClientPostUsingJavaHTTPClientLibrary {
	
	// JSON content to post
	private static final String JSON_OBJECT = "{\"name\":\"Zulkifli Halim\",\"email\":\"zul.halim87@gmail.com\",\"about\":\"Fokus and passionate doing my job, can be a good teamwork member and able to work independently\"}";
    
	//Web services URLs
	private static final String URL_SR = "http://sr-recruit.herokuapp.com/resumes";
    private static final String URL_HK = "http://icurriculumvitaeuploaderapp.herokuapp.com/restservicespath/json/resume/post/";

	public static void main(String[] args) {

		try {
			URL url = new URL(URL_SR); //change URL_SR to URL_HK to test the other webservice
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
