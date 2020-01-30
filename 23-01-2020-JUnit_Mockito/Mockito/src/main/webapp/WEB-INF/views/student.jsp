<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  <div style="position: absolute;top: 80px; left: 300;">
        <h1 style="text-align:center">Add Student</h1>  
       <form:form method="post" action="save">    
        <table >  
        <tr>    
          <td>USN : </td>   
          <td><form:input path="usn"  /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>Department : </td>   
          <td><form:input path="department"  /></td>  
         </tr>
         <tr>    
          <td>Semester : </td>   
          <td><form:input path= "semester"  /></td>  
         </tr>
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>  
       <div style="font:bold;font-size:20px;position: absolute;top: 220px; left: 80;">
       <a href="viewstud">View Students List</a> </div>
  </div>