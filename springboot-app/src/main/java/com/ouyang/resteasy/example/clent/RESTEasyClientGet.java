package com.ouyang.resteasy.example.clent;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.ouyang.resteasy.example.EchoMessage;

public class RESTEasyClientGet {

	public static void main(String[] args) {

		//Client client = ClientBuilder.newClient();
		Client client = ClientBuilder.newBuilder().build();

		WebTarget target = client.target("http://localhost:8080/sample-app/echo/get?s=Ryan");
		Response response = target.request().get();

		EchoMessage em = response.readEntity(EchoMessage.class);
		System.out.println("response:\n\t" + em);
		response.close();
	}

}
