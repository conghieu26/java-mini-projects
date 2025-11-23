package crudProductManager;

import java.util.List;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {

	        ProductService service = new ProductService();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("===== PRODUCT MANAGER =====");
	            System.out.println("1. Add product");
	            System.out.println("2. Delete product");
	            System.out.println("3. Edit product");
	            System.out.println("4. Find product");
	            System.out.println("5. Print all products");
	            System.out.println("6. Exit");
	            System.out.print("Choose: ");

	            int choice = sc.nextInt();
	            sc.nextLine(); // clear buffer

	            try {
	                switch (choice) {

	                    // --------------------- ADD ---------------------
	                    case 1:
	                        System.out.print("Enter ID: ");
	                        int id = sc.nextInt();
	                        sc.nextLine();

	                        System.out.print("Enter Name: ");
	                        String name = sc.nextLine();

	                        System.out.print("Enter Price: ");
	                        double price = sc.nextDouble();
	                        sc.nextLine();

	                        System.out.print("Enter Category (FOOD, ELECTRONIC, FASHION): ");
	                        String cate = sc.nextLine();
	                        Category category = Category.valueOf(cate.toUpperCase());

	                        service.AddProduct(new Product(id, name, price, category));
	                        break;

	                    // --------------------- DELETE ---------------------
	                    case 2:
	                        System.out.print("Enter ID to delete: ");
	                        int delId = sc.nextInt();
	                        service.DeleteProduct(delId);
	                        break;

	                    // --------------------- EDIT ---------------------
	                    case 3:
	                        System.out.print("Enter ID to edit: ");
	                        int editId = sc.nextInt();
	                        sc.nextLine();

	                        System.out.print("New name: ");
	                        String newName = sc.nextLine();

	                        System.out.print("New price: ");
	                        double newPrice = sc.nextDouble();
	                        sc.nextLine();

	                        System.out.print("New category: ");
	                        String newCate = sc.nextLine();
	                        Category newCategory = Category.valueOf(newCate.toUpperCase());

	                        service.EditProduct(editId, newName, newPrice, newCategory);
	                        break;

	                    // --------------------- FIND ---------------------
	                    case 4:
	                        System.out.print("Enter ID (or null): ");
	                        String idInput = sc.nextLine();
	                        Integer findId = idInput.equals("null") ? null : Integer.parseInt(idInput);

	                        System.out.print("Enter Category (or null): ");
	                        String catInput = sc.nextLine();
	                        Category findCategory = catInput.equals("null")
	                                ? null
	                                : Category.valueOf(catInput.toUpperCase());

	                        System.out.print("Enter Max Price (or null): ");
	                        String priceInput = sc.nextLine();
	                        Double maxPrice = priceInput.equals("null") ? null : Double.parseDouble(priceInput);

	                        List<Product> results = service.findProduct(findId, findCategory, maxPrice);

	                        System.out.println("---- FOUND ----");
	                        results.forEach(System.out::println);
	                        break;

	                    // --------------------- PRINT ALL ---------------------
	                    case 5:
	                        System.out.println("---- ALL PRODUCTS ----");
	                        service.printProduct().forEach(System.out::println);
	                        break;

	                    case 6:
	                        System.out.println("Bye!");
	                        return;

	                    default:
	                        System.out.println("Invalid choice!");
	                }

	            } catch (Exception e) {
	                System.out.println("ERROR: " + e.getMessage());
	            }

	            System.out.println("\n");
	        }
	    }
}
