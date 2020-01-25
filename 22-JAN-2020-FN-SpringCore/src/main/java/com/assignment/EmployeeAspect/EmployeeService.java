package com.assignment.EmployeeAspect;

import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.assignment.model.Employee;
@Component
public class EmployeeService {
	
	public ArrayList<Employee> getAllEmployeeDetails(){
		ArrayList<Employee> list=new ArrayList<Employee>();
		list.add(new Employee(1,"Karthik"));
		list.add(new Employee(2,"Pranav"));
		list.add(new Employee(3,"Rahul"));
		list.add(new Employee(4,"Virat"));
		list.add(new Employee(5,"Sanjay"));
		return list;
	}
	
}
