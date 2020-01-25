package com.assignment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import com.assignment.model.Employee;
import com.assignment.model.Point;

@Configuration
@ComponentScan(basePackages = "com.*")
@PropertySource("classpath:prop.properties")
public class AppConfig {

	public AppConfig() {
		super();
	}
	
	@Bean
	public Point getPoint() {
		System.out.println("Injecting Point object using property file");
		Point point=new Point();
		return point;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer prop() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
