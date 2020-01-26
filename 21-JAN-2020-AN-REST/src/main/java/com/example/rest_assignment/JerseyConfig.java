package com.example.rest_assignment;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig() {
		register(MainClass.class);
	//	register(MainClass.EmployeeFacory.class);
		register(Employee.class);
	}
}
