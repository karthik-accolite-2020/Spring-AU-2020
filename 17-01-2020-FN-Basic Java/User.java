import java.util.HashMap;

public class User {
	private String username, name, gender;
	private String password;
	private int age;
	HashMap<Integer, Product> cart;
	public User(String name,String username , String password, String gender, int age) {
		this.name = name;	
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.age = age;
		cart=new HashMap<Integer, Product>();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
