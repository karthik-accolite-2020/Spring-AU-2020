package com.assignment.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resources;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.assignment.EmployeeAspect.AspectClass;
import com.assignment.EmployeeAspect.EmployeeService;
import com.assignment.config.AppConfig;
import com.assignment.model.Dummy;
import com.assignment.model.Employee;
import com.assignment.model.HashMapProvider;
import com.assignment.model.Point;

@ComponentScan(basePackages = "com.assignment.*")
public class MainClass {

	public static void main(String[] args) {
		ApplicationContext con=new ClassPathXmlApplicationContext("appContent.xml");
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Point p = context.getBean(Point.class);
		p.show();

		
		HashMapProvider map=(HashMapProvider) ctx.getBean("hmp");
		System.out.println("Map of Integer,Employee is created");
		for(Map.Entry<Integer,Employee> ent:map.getMap().entrySet()) {
			System.out.println(ent.getKey()+"->"+ent.getValue().getName());
		}
		System.out.println("Execution time:");
		EmployeeService es=con.getBean(EmployeeService.class);
		 
		ArrayList<Employee>list=es.getAllEmployeeDetails(); //System.out.println(es.getExecutionTime());
		AspectClass as=con.getBean(AspectClass.class);
		System.out.println("Execution time for getting employee list="+as.getExecutionTime()+"nano seconds");
		 
	}
}
