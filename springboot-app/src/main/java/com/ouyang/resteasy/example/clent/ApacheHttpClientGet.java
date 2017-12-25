package com.ouyang.resteasy.example.clent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ouyang.resteasy.example.EchoMessage;

public class ApacheHttpClientGet {

	public static void main(String[] args) {
		try {

			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet getRequest = new HttpGet("http://localhost:8080/sample-app/echo/get?s=John");
			getRequest.addHeader("accept", "application/json");
			HttpResponse response = httpClient.execute(getRequest);

			/*
			//deprecated
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(
					"http://localhost:8080/sample-app/echo/get?s=John");
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);
			 */

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			//printJsonString (response);

			System.out.println("convert json to object:\n\t" + getFromJson (response));

			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static void printJsonString (HttpResponse response) throws UnsupportedOperationException, IOException{

		BufferedReader br = new BufferedReader(
				new InputStreamReader((response.getEntity().getContent())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

	}

	private static EchoMessage  getFromJson (HttpResponse response) throws JsonParseException, JsonMappingException, UnsupportedOperationException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		EchoMessage echoMessage = objectMapper.readValue(response.getEntity().getContent(), EchoMessage.class);
		return echoMessage;

	}

}
