
import java.util.HashMap;

public class Order {
	public int order_id;
	public String username;
	public HashMap<Integer, Product> products;
	public Order(int order_id, String username, HashMap<Integer, Product>products) {		
		this.order_id = order_id;
		this.username = username;
		this.products = products;
	}
	public void PlaceOrder() {
		System.out.println("Placing the order...");
		DataClass.BuyAndUpdateProduct(username);
		DataClass.UserData.get(username).cart.clear();
	}
}
