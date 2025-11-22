package crud;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserService {
	List<User> users = new ArrayList<>();
	Set<User> uniqueUser = new HashSet<>();

	// ------------------- ADD -------------------
	public void addUser(User u) {
		boolean exists = users.stream().anyMatch(user -> user.getId() == u.getId());
		if (exists) {
			throw new RuntimeException("ID " + u.getId() + " already exists!");
		}
		users.add(u);
		System.out.println("User added successfully!");
	}

	// ------------------- DELETE -------------------
	public void deleteUser(int id) {

		boolean removed = users.removeIf(user -> user.getId() == id);

		if (!removed) {
			throw new UserNotFoundException("Cannot delete: User with id " + id + " not found!");
		}

		uniqueUser.removeIf(user -> user.getId() == id);
		System.out.println("User deleted!");

	}

	// ------------------- EDIT -------------------
	public void editUser(int id, String newName) {
		User u = users.stream().filter(user -> user.getId() == id).findFirst()
				.orElseThrow(() -> new UserNotFoundException("Cannot edit: User with id " + id + " not found!"));

		u.setName(newName);

		System.out.println("User updated!");
	}

	public User findUser(int id, String name) {
		return users.stream().filter(u -> u.getId() == id || u.getName().equalsIgnoreCase(name)).findFirst()
				.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id + " OR name: " + name));
	}

	public List<User> printAllUser() {
		return users.stream().toList();
	}
}
