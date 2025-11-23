package crudProductManager;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
	List<Product> products = new ArrayList<>();
		
	
	//-----------------Add Product-----------------
	
	public void AddProduct(Product p) {
		boolean exits = products.stream().anyMatch(product -> product.getId() == p.getId());
		
		if(!exits) {
			throw new InvalidProductException("Product Id already exist!!");
		}
		
		products.add(p);
		System.out.println("Product already added!!");
	}
	
}
