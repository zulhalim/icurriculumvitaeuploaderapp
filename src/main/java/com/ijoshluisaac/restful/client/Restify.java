package com.ijoshluisaac.restful.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class Restify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HttpClient httpClient = new DefaultHttpClient();

	    try {
	        HttpPost request = new HttpPost("http://sr-recruit.herokuapp.com/resume");
	        StringEntity params =new StringEntity("message={\"message\":\"Joshua Uzochukwu Nwankwo\"} ");
	        
	        
	        request.addHeader("Content-Type", "application/json");
	        
	        //application/json
	        //application/x-www-form-urlencoded
	        request.setEntity(params);
	        HttpResponse response = httpClient.execute(request);

	        System.out.println(response.getStatusLine().getStatusCode());
	        // handle response here...
	    }catch (Exception ex) {
	        // handle exception here
	    } finally {
	        httpClient.getConnectionManager().shutdown();
	    }

	}

}
