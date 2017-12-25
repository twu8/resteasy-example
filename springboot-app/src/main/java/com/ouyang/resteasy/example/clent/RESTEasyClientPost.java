package com.ouyang.resteasy.example.clent;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ouyang.resteasy.example.EchoMessage;
import com.ouyang.resteasy.example.Event;

public class RESTEasyClientPost {

	private static void post() {

		//Client client = ClientBuilder.newClient();
		Client client = ClientBuilder.newBuilder().build();

		WebTarget target = client.target("http://localhost:8080/sample-app/echo/post");
		final Builder request = target.request();
		final Response response = request.post(Entity.entity("Scott", MediaType.TEXT_PLAIN_TYPE ));

		EchoMessage em = response.readEntity(EchoMessage.class);
		System.out.println("response from post:\n\t" + em);
		response.close();
	}

	private static void post2() {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target("http://localhost:8080/sample-app/echo/post2");
		final Builder request = target.request();

		Event event = new Event("Bora");		
		final Response response = request.post(Entity.entity(event, MediaType.APPLICATION_JSON_TYPE));

		EchoMessage em = response.readEntity(EchoMessage.class);
		System.out.println("response from post2:\n\t" + em);
		response.close();
	}

	public static void main(String[] args) {
		post();
		post2();
	}

}

