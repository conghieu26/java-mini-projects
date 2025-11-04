package ex;

public class Product {
	private String id;
	private String name; 
	private double price;
	
	public Product(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return id + " - " + name + " - $" + price;
	}
	
	@Override 
	public boolean equals(Object o) { 
		if (this == o) return true; 
		if (! (o instanceof Product)) return false; 
		
		Product p = (Product) o;
		
		return name.equalsIgnoreCase(p.name);
	}
		
	@Override 
	public int hashCode() {
		return name.toLowerCase().hashCode();
	}
	
}
