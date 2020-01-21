
public class Product {
 	private int product_id;
 	private String product_name;
 	private double product_price;
 	private int quantity;
	public Product(int id, String name, double price, int qty) {
		this.product_id = id;
		this.product_name = name;
		this.product_price = price;
		this.quantity = qty;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
 	
}
