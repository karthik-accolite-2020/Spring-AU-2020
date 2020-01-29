package com.accolite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accolite.dao.StudentDao;
import com.accolite.student.Student;



@Controller
public class StudentController {

	@Autowired    
    StudentDao dao;
	 @RequestMapping("/student")    
	    public String showform(Model m){    
	        m.addAttribute("command", new Student());  
	        return "student";   
	    }      
	    @RequestMapping(value="/save",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("s") Student s){    
	        dao.save(s);    
	        return "redirect:/student";   
	    }    
	    @RequestMapping(value="/viewstud",method = RequestMethod.GET)    
	    public String viewstud(Model m){    
	        List<Student> list=dao.getstudents();
	        m.addAttribute("list",list);
	        
	        return "viewstud";    
	    }      
	    @RequestMapping(value="/deletestud/{usn}",method = RequestMethod.GET)    
	    public String delete(@PathVariable String usn){    
	        dao.delete(usn);    
	        return "redirect:/viewstud";    
	    }
	
	
	
}
