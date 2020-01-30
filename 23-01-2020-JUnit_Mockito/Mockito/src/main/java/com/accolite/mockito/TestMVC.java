package com.accolite.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.accolite.dao.StudentDao;
import com.accolite.student.Student;

@RunWith(MockitoJUnitRunner.class)
public class TestMVC {
	
	@Mock
	StudentDao sd;
	
	@Test
	public void MockData() {
		List<Student> list=new ArrayList<Student>();
		list.add(new Student("1BM16IS044", "Karthik", "ISE", 8));
		list.add(new Student("1BM16CS066", "Rahul", "CSE", 4));
		list.add(new Student("1BM16EE075", "Pratap", "EEE", 6));
		
		when(sd.getstudents()).thenReturn(list);
		
		sd.getstudents().forEach((s)->{
			System.out.println(s.getName()+"\t"+s.getUsn()+"\n"+s.getDepartment()+"\t"+s.getSemester());
		});
	}
}
