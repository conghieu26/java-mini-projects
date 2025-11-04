package ex;
import java.util.List;

public class Order {
	private String orderId;
	private Customer customer;
	private List<Product> products;
	
	public Order(String orderId, Customer customer, List<Product> products) {
	
		this.orderId = orderId;
		this.customer = customer;
		this.products = products;
	}

	public String getOrderId() {
		return orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<Product> getProducts() {
		return products;
	}
	

    public double getTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
	
	@Override
    public String toString() {
        return "Order " + orderId + " | Customer: " + customer.getName() +
               " | Total: $" + getTotal();
    }  
}
