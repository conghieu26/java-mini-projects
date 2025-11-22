package crud;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		UserService service = new UserService();

		while (true) {
			System.out.println("\n===== USER MANAGEMENT SYSTEM =====");
			System.out.println("1. Add User");
			System.out.println("2. Delete User");
			System.out.println("3. Edit User");
			System.out.println("4. Find User");
			System.out.println("5. Print All Users");
			System.out.println("6. Exit");
			System.out.print("Choose option: ");

			int option = sc.nextInt();
			sc.nextLine(); // clear buffer

			try {
				switch (option) {

				// ADD USER
				case 1 -> {
					System.out.print("Enter ID: ");
					int id = sc.nextInt();
					sc.nextLine();

					System.out.print("Enter name: ");
					String name = sc.nextLine();

					User u = new User(id, name);
					service.addUser(u);
				}

				// DELETE USER
				case 2 -> {
					System.out.print("Enter ID to delete: ");
					int id = sc.nextInt();
					service.deleteUser(id);
				}

				// EDIT USER
				case 3 -> {
					System.out.print("Enter ID to edit: ");
					int id = sc.nextInt();
					sc.nextLine();

					System.out.print("New name: ");
					String name = sc.nextLine();

					service.editUser(id, name);
				}

				// FIND USER
				case 4 -> {
					System.out.print("Enter ID: ");
					int id = sc.nextInt();
					sc.nextLine();

					System.out.print("Enter Name: ");
					String name = sc.nextLine();

					User found = service.findUser(id, name);
					System.out.println("Found user: " + found);
				}

				// PRINT ALL USERS
				case 5 -> {
					System.out.println("\n--- USER LIST ---");
					service.printAllUser().forEach(System.out::println);
				}

				// EXIT
				case 6 -> {
					System.out.println("Exit program...");
					System.exit(0);
				}

				default -> System.out.println("Invalid option, try again!");
				}

			} catch (Exception e) {
				System.out.println("❌ Error: " + e.getMessage());
			}
		}
	}
}
