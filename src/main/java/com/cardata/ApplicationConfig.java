package com.cardata;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ApplicationConfig {

	@Component
	@ApplicationPath("/cardata")
	static class JerseyConfig extends ResourceConfig{
		public JerseyConfig() {
			this.packages("com.cardata.rest");
		}
	}
}
