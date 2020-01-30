 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 <div style="position: absolute;top: 80px; left: 300;"> 
<h1 style="text-align:center">Students List</h1>  
<table border="2" width="70%" height="10%" >  
<tr><th>USN</th><th>Name</th><th>Department</th><th>Semester</th><th>Delete</th></tr>  
   <c:forEach var="stud" items="${list}">   
   <tr>  
   <td>${stud.usn}</td>  
   <td>${stud.name}</td>
   <td>${stud.department}</td>  
   <td>${stud.semester}</td>    
   <td><a href="deletestud/${stud.usn}">Delete</a></td>  
   </tr>  
   </c:forEach> 
   </table>  
   <br/>  
   <div style="font:bold;font-size:20px;position: absolute;top: 220px; left: 80;">
   <a href="student">Add New Student</a> </div>
   </div>