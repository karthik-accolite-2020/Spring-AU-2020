import java.awt.color.ProfileDataException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MainClass {
	private static User user;
	private static Set<Entry<Integer, Product>> set;
	private static void ShowProducts() {
		for(Map.Entry<Integer, Product> ent:DataClass.ProductData.entrySet()) {
			Product p=ent.getValue();
			System.out.println("Product ID:"+p.getProduct_id()
								+"\tProduct Name:"+p.getProduct_name()
								+"\nProduct Price:"+p.getProduct_price()
								+"\tQuantity Available:"+p.getQuantity());
		}
	}
	private static double ViewCart(String un) {
		double total=0;
		for(Map.Entry<Integer, Product> ent : DataClass.UserData.get(un).cart.entrySet()) {
			Product p=ent.getValue();
			if(p.getQuantity()>0) {
				System.out.println("Product ID:"+p.getProduct_id()
				+"\tProduct Name:"+p.getProduct_name()
				+"\nProduct Price:"+p.getProduct_price()
				+"\tQuantity Available:"+p.getQuantity());
				total+=p.getProduct_price();
			}
		}
		return total;
	}
	public static void main(String[] args) {
		DataClass.AddData();
		String un,pwd;
		Scanner sc=new Scanner(System.in);
		System.out.println("-------------------------------------------Welcome to shopping center-------------------------------------------");
		
		System.out.println("Login to account");
		System.out.println("Enter username");
		un=sc.next();
		System.out.println("Enter password");
		pwd=sc.next();
		if(DataClass.ValidateUser(un, pwd)) {
			System.out.println("Login success");
			boolean loop=true;
			while(loop) {
				
				int pid=0;
				System.out.println("1:Add a product to cart\n2:Remove product from cart\n3:View cart\n4:Place order\n5:Cancel order"
						+ "\nPress any other number to exit.");
				int option=sc.nextInt();
				switch(option) {
				case 1:
					ShowProducts();
					System.out.println("Type Product ID and hit enter to add it to the cart");
					pid=sc.nextInt();
					if(DataClass.AddProductToCart(un, pid)) {
						System.out.println("Product added to cart:)");
					}
					else {
						System.out.println("Something went wrong while adding product to the cart:(");
					}
					break;
				case 2:
					ViewCart(un);
					System.out.println("Type Product ID and hit enter to remove it from the cart");
					pid=sc.nextInt();
					if(DataClass.RemoveProductFromCart(un, pid)) {
						System.out.println("Product removed from the cart.");
					}
					else {
						System.out.println("Something went wrong while removing product from the cart:(");
					}
					break;
				case 3:
					ViewCart(un);
					break;
				case 4:	

					double total=ViewCart(un);
					System.out.println("Calculating total amount....");
					System.out.println(total);					
					Order o=new Order(DataClass.getOrderId(), un, DataClass.UserData.get(un).cart);
					o.PlaceOrder();
					break;
				case 5:
					DataClass.EmptyTheCart(un);
					break;
				default:
					loop=false;
					un=null;
					pwd=null;
					System.out.println("Logged out");
					break;
				}
			}			
		}
		else {
			System.out.println("Login failed :(");
		}
	}
}
