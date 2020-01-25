package com.assignment.EmployeeAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectClass {
	private long ExecutionTime;
	public long getExecutionTime() {
		return ExecutionTime;
	}
	@Before(value = "execution(* com.assignment.EmployeeAspect.EmployeeService.getAllEmployeeDetails(..))")
	public void beforeFun(JoinPoint jp) {
		System.out.println("starting function call");
		ExecutionTime=System.nanoTime();
	}
	@After(value = "execution(* com.assignment.EmployeeAspect.EmployeeService.getAllEmployeeDetails(..))")
	public void afterFun(JoinPoint jp) {
		System.out.println("ending function call");
		ExecutionTime=System.nanoTime()-ExecutionTime;				
	}
}
