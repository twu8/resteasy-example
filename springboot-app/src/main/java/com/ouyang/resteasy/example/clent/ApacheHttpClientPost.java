package com.ouyang.resteasy.example.clent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ouyang.resteasy.example.EchoMessage;

public class ApacheHttpClientPost {

	public static void main(String[] args) {

		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postRequest = new HttpPost("http://localhost:8080/sample-app/echo/post");
			postRequest.addHeader("accept", "application/json");

			//StringEntity input = new StringEntity("{\"qty\":100,\"name\":\"iPad 4\"}");
			StringEntity input = new StringEntity("wang pei");

			//input.setContentType("application/json");
			input.setContentType("text/plain");

			postRequest.setEntity(input);

			HttpResponse response = httpClient.execute(postRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			//printJsonString (response);

			System.out.println("convert json to object:\n\t" + getFromJson (response));

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {
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
