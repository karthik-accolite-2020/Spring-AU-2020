package com.accolite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.student.Student;


public class StudentDao {
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Student s){    
	    String sql="INSERT INTO Student(usn,name,department,semester) values('"+s.getUsn()+"','"+s.getName()+"','"+s.getDepartment()+"',"+s.getSemester()+")";    
	    return template.update(sql);    
	}       
	public int delete(String usn){    
	    String sql="DELETE FROM Student where usn='"+usn+"'";    
	    return template.update(sql);    
	}       
	public List<Student> getstudents(){    

	    String sql = "SELECT * FROM Student";
	    List<Student> studlist = template.query(sql, new RowMapper<Student>() {
	 
	        public Student mapRow(ResultSet rs, int row) throws SQLException {
	        	Student s1 = new Student();
	        	s1.setUsn(rs.getString("usn"));
	            s1.setName(rs.getString("name"));
	            s1.setDepartment(rs.getString("department"));
	            s1.setSemester(rs.getInt("semester"));
	            return s1;
	        }
	 
	    });
	 
	    return studlist;
	}    

}
