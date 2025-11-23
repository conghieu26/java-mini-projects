package crudProductManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductService {
	List<Product> products = new ArrayList<>();
		
	
	//-----------------Add Product-----------------
	
	public void AddProduct(Product p) {
		boolean exits = products.stream().anyMatch(product -> product.getId() == p.getId());
		
		if(exits) {
			throw new InvalidProductException("Product Id already exist!!");
		}
		
		if (p.getPrice() <= 0) {
			throw new InvalidProductException("Price must be greater than 0!");
		}
		
		products.add(p);
		System.out.println("Product already added!!");
	}
	
	//-----------------Delete Product-----------------
	
	public void DeleteProduct(int id) {
		
		 boolean removed = products.removeIf(product -> product.getId() == id);
		 
		 if(!removed) {
			 throw new ProductNotFoundException("Not found product id");
		 }
		 
		 System.out.println("Product deleted!");
	}
	
	//-----------------Edit Product-----------------
	
	public void EditProduct(int id, String newName, double newPrice, Category newCategory) {
		
		Product editProduct = products.stream().filter(product -> product.getId() == id).findFirst()
										 .orElseThrow(() -> new InvalidProductException("Cannot edit: Product with id " + id + " not found!"));
		
		if (newPrice <= 0) {
	        throw new InvalidProductException("Price must be greater than 0!");
	    }
		
		editProduct.setName(newName);
		editProduct.setPrice(newPrice);
		editProduct.setCategory(newCategory);
		
		System.out.println("Product updated!");
	}
	
	//-----------------Find Product-----------------
	
	public List<Product> findProduct(Integer id, Category category, Double maxPrice) {
		return products.stream().filter(p -> (id != null && p.getId() == id) || (category != null && p.getCategory() == category) || (maxPrice != null && p.getPrice() < maxPrice)).toList();
	}
	
	//-----------------Print Product-----------------
	
	public List<Product> printProduct() {
		return products.stream().sorted(Comparator.comparing(Product::getPrice)).toList();
	}
	
	
}
