package com.example.rest_assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

class Employee{
	private int id;
	private String name;
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ID="+id+"\tName="+name;
	}
}

@Path("/apis")
public class MainClass {
	private static HashMap<Integer,Employee> emps=new HashMap<Integer,Employee>();

	@GET
	@Produces("application/json")
	public static String getAllEmployee()
	{
		if(emps.size()==0) {
			return "No data found";
		}
		String res="";
		for(Map.Entry<Integer,Employee> e:emps.entrySet()) {
			res+=e.getValue().toString()+"\n";
		}
		return res;
	}
	
	@POST
	@Path("/employee/details/{id}")
	@Produces("application/json")
	public static String getEmpDetails(@PathParam("id") int id) {
		return emps.get(id).getName();
	}
	
	@PUT
	@Path("/employee/create")
	@RequestMapping("/employee/create")
	@Produces("application/json")
	public static boolean addEmployee(@RequestParam HashMap<String, Object> map) {
		try {
			int id=Integer.parseInt(map.get("id").toString());
			String name=(String) map.get("name");
			if(!emps.containsKey(id)) {
				Employee e=new Employee(id, name);
				emps.put(id,e);
				return true;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
	}
	@DELETE	  
	@Path("/employee/remove/{id}")	  
	@Produces("application/json") 
	public boolean delEmployee(@PathParam("id") int id) {	 
		if(emps.containsKey(id)) {
			emps.remove(id);
			return true;
		}
		return false;
	}
}
