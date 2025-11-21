package ex1;

import java.util.List;

public class exStream {
	public static void main(String[] args) {
		List<User> user = List.of(new User(1, "Hieu", true), new User(2, "Long", false), new User(3, "An", true));
		
		List<String> activeName = user.stream().filter(User::isActive).map(User::getName).toList();
	}
}
