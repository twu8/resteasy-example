package com.ouyang.resteasy.example;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/sample-app/")
public class JaxrsApplication extends Application {
}
