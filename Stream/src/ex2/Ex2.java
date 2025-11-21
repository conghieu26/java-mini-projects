package ex2;

import java.util.Comparator;
import java.util.List;

public class Ex2 {
	public static void main(String[] args) {
		List<Product> products = List.of(
                new Product(1, "Laptop", 1500.0),
                new Product(2, "Smartphone", 800.0),
                new Product(3, "Headphones", 120.0),
                new Product(4, "Keyboard", 45.0),
                new Product(5, "Mouse", 25.0),
                new Product(6, "Monitor", 300.0),
                new Product(7, "SSD 1TB", 100.0),
                new Product(8, "USB-C Cable", 10.0)
        );
		
		// Lọc sản phẩm có giá > 100k
		List<Product> expensiveProducts  = products.stream().filter(p -> p.getPrice() > 100).toList();
		System.out.println("=== Sản phẩm giá > 100,000 ===");
		expensiveProducts.forEach(System.out::println);
		
		// Lấy danh sách tên sản phẩm
		List<String> productNames = products.stream().map(Product::getName).toList();
        System.out.println("\n=== Tên sản phẩm ===");
        productNames.forEach(System.out::println);
		
		//	Sắp xếp sản phẩm theo giá tăng dần
		List<Double> sortedProducts = products.stream().sorted(Comparator.comparing(Product::getPrice)).map(Product::getPrice).toList(); 
		
		System.out.println("\n=== Sắp xếp theo giá tăng dần ===");
        sortedProducts.forEach(System.out::println);
		
	}
}
