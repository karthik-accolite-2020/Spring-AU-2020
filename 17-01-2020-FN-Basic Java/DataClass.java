import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataClass {
	public static HashMap<String,User> UserData;
	public static HashMap<Integer,Product> ProductData;
	public static int OrderIds=1001;
	public static void AddData() {
		UserData = new HashMap<String,User>();
		UserData.put("k",new User("Karthik","k", "q", "Male" , 22));
		UserData.put("arunhere",new User("Arun","arunhere", "1234", "Male" , 26));
		UserData.put("iamrashmi",new User("Rashmi","iamrashmi", "awsrashmi", "Female" , 19));
		UserData.put("rahul333",new User("Rahul","rahul333", "king222", "Male" , 35));
		
		ProductData = new HashMap<Integer,Product> ();
		ProductData.put(101,new Product(101, "Redmi Note 4", 10000.00, 25));
		ProductData.put(102,new Product(102, "Boat wireless headphones", 560.00, 25));
		ProductData.put(103,new Product(103, "Bajaj edge 120mm ceiling fan", 1185.00, 25));
		ProductData.put(104,new Product(104, "Ustra black 200 cordless trimmer", 1299.00, 25));
		ProductData.put(105,new Product(105, "Power bank", 799, 25));
		ProductData.put(106,new Product(106, "HP 14 Core i3 7th gen", 29490.00, 25));
	}
	public static boolean ValidateUser(String un, String pwd) {
		if(UserData.containsKey(un)&&UserData.get(un).getPassword().equals(pwd))
			return true;
		return false;
	}
	public static boolean AddProductToCart(String un,int pid) {
		if(ProductData.containsKey(pid)&&UserData.containsKey(un)) {
			Product p=ProductData.get(pid);
			User u=UserData.get(un);
			u.cart.put(p.getProduct_id(), p);
			return true;
		}
		return false;
	}
	public static boolean RemoveProductFromCart(String un,int pid) {
		if(UserData.containsKey(un)&&ProductData.containsKey(pid)) {
			User u=UserData.get(un);
			if(u.cart.containsKey(pid)) {
				u.cart.remove(pid);
				return true;
			}
			return false;
		}
		return false;
	}
	public static int getOrderId() {
		return OrderIds++;
	}
	public static void BuyAndUpdateProduct(String un) {
		User u=UserData.get(un);
		for(Map.Entry<Integer, Product> ent:u.cart.entrySet()) {
			ent.getValue().setQuantity(ent.getValue().getQuantity()-1);
		}
	}
	public static boolean EmptyTheCart(String un) {
		if(UserData.containsKey(un)) {
			User u=UserData.get(un);
			HashMap<Integer, Product> cart=u.cart;
			cart.clear();
			return true;
		}
		return false;
	}
}
