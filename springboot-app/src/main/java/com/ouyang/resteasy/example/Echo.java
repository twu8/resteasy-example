package com.ouyang.resteasy.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;


/**
 * Echo REST endpoint class
 *
 */
@Path("/echo")
@Component
public class Echo {


	/**
	 * 
	 * http://localhost:8080/sample-app/echo/get?s=John
	 * @param echoText
	 * @return
	 */
	@Path("/get")
	@GET
	//@Produces({MediaType.APPLICATION_JSON})
	@Produces("application/json")
	public EchoMessage echoGet (@DefaultValue("hello world") @QueryParam("s") String echoText) {
		return new EchoMessage(echoText);
	}

	/**
	 * 
	 * http://localhost:8080/sample-app/echo/post
	 * @param echoText
	 * @return
	 */
	@Path("/post")
	@POST
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
	public EchoMessage echoPost (@NotEmpty String echoText) {

		return new EchoMessage(echoText);
	}
	
	
	/**
	 * 
	 * http://localhost:8080/sample-app/echo/post2
	 * @param echoText
	 * @return
	 */
	@Path("/post2")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public EchoMessage echoPost2 (@NotEmpty Event event) {
		return new EchoMessage("Hello " + event);
	}

}
