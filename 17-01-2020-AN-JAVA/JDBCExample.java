import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
class Employee{
	private int id,deptId;
	private String fn,ln;
	
	public Employee(int id, String fn, String ln,int deptId) {		
		this.id = id;
		this.deptId = deptId;
		this.fn = fn;
		this.ln = ln;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}	
}

class Department{
	private int deptId;
	private String deptName;
	
	public Department(int deptId, String deptName) {
		this.deptId = deptId;
		this.deptName = deptName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}

public class JDBCExample {
	static void createEmployeeTable(Connection con) {
		try {
			Statement stmt=con.createStatement();
			stmt.executeUpdate("Create table if not exists empdata.employee (eid integer primary key,"
					+ " firstname varchar(20), lastname varchar(20), dId integer, foreign key(dId) references"
					+ " empdata.department(deptId));");
			System.out.println("created");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void createDeptTable(Connection con) {
		try {
			Statement stmt=con.createStatement();
			stmt.executeUpdate("create table if not exists empdata.department(deptId integer primary key, deptName varchar(20));");
			System.out.println("created");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void addEmpData(Connection con) {
		ArrayList<Employee> list=new ArrayList<Employee>();
		list.add(new Employee(1,"Karthik","Hebbar",102));
		list.add(new Employee(2,"Adhira","Naidu",101));
		list.add(new Employee(3,"Mishka","Sharma",104));
		list.add(new Employee(4,"Bhuvan","Shetty",108));
		list.add(new Employee(5,"Taara","Nair",103));
		list.add(new Employee(6,"Jay","Poojary",104));
		list.add(new Employee(7,"Pranav","Gowda",106));
		list.add(new Employee(8,"Nirav","Modi",108));
		list.add(new Employee(9,"Mahesh","Nair",102));
		list.add(new Employee(10,"Chandrika","Hebbar",101));
		list.add(new Employee(11,"Nagaraj","Bhat",102));
		list.add(new Employee(12,"Latha","Kannantha",108));
		list.add(new Employee(13,"Nagarathna","Madhyastha",102));
		list.add(new Employee(14,"Swathi","Rao",106));
		list.add(new Employee(15,"Gayathri","Karanth",104));
		list.add(new Employee(16,"Poornima","Varna",108));
		list.add(new Employee(17,"Asha","Rao",102));
		list.add(new Employee(18,"Chaitra","Jahagirdar",101));
		list.add(new Employee(19,"Achutha","Hebbar",102));
		list.add(new Employee(20,"Anish","Karanth",108));
		list.forEach((i)->{
			try {
				Statement stmt=con.createStatement();
				stmt.executeUpdate("insert into empdata.employee(eid,firstname,lastname,dId) values("
						+ i.getId()+",'"+i.getFn()+"','"+i.getLn()+"',"+i.getDeptId()
						+ ")");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}
	static void addDeptData(Connection con) {
		ArrayList<Department> list=new ArrayList<Department>();
		list.add(new Department(101,"ISE"));
		list.add(new Department(102,"CSE"));
		list.add(new Department(103,"ECE"));
		list.add(new Department(104,"EEE"));
		list.add(new Department(105,"MECH"));
		list.add(new Department(106,"MBA"));
		list.add(new Department(107,"MSC"));
		list.add(new Department(108,"MTECH"));
		list.add(new Department(109,"BIO"));
		list.forEach((i)->{
			try {
				Statement stmt=con.createStatement();
				String sql="insert into empdata.department(deptId, deptName) values("
						+ i.getDeptId()+",'"+i.getDeptName()
						+ "');";
				System.out.println(sql);
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdata","root","root");
			java.sql.CallableStatement stmt=con.prepareCall("{ call perform_join() }");
			ResultSet rs=stmt.executeQuery();
			System.out.println("Eid\tFirstName\tLastName\tdId\tDeptId\tDeptName");
			
			while(rs.next()) {
				System.out.println(rs.getString("eid")
						+",\""+rs.getString("firstname")
						+"\",\""+rs.getString("lastname")
						+"\","+rs.getString("dId")
						+",\""+rs.getString("deptId")
						+"\",\""+rs.getString("deptName")
						+"\"");
			}
			con.close();
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			
		}
	}
}
