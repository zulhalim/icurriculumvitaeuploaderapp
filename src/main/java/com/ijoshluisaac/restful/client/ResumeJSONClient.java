package com.ijoshluisaac.restful.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ResumeJSONClient {

	
	/**
	 * @param args
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	
	// JSON content to post
	private static final String JSON_OBJECT = "{\"name\":\"Joshua U. Nwankwo\",\"email\":\"joshluisaac@gmail.com\",\"about\":\"Motivated,Loves new challenging stuffs and goal orinted\"}";
    
	//Web services URLs
	private static final String URL_SR = "http://sr-recruit.herokuapp.com/resumes";
    private static final String URL_HK = "http://icurriculumvitaeuploaderapp.herokuapp.com/restservicespath/json/resume/post/";
	
	public static void main(String[] args) throws MalformedURLException,
			IOException {

		// Create a URLConnection

		URL url = new URL(
				URL_SR); //change URL_SR to URL_HK to test the other webservice
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("Cache-Control", "no-cache");

		// Post JSON content
		OutputStream stream = connection.getOutputStream();
		stream.write(JSON_OBJECT.getBytes());
		stream.flush();

		// Read the response from the server
		BufferedReader br = new java.io.BufferedReader(
				new java.io.InputStreamReader(connection.getInputStream()));

		String output;
		System.out.println("Successfully Executed RESTFul POST .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

	}

}
