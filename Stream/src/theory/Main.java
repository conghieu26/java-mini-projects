package theory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		/*
		 * Stream API là gì? Stream API được giới thiệu từ Java 8 Stream là dòng dữ liệu
		 * trừu tượng, cho phép bạn xử lý tập hợp dữ liệu (Collections, Arrays, IO...)
		 * theo cách khai báo, dễ đọc.
		 */

		// Filter (lọc dữ liệu)

		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

		List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).toList();

		System.out.println(evenNumbers); // [2,4,6]

		// Map (chuyển đổi dữ liệu): Chuyển đổi từ kiểu dữ liệu này sang kiểu khác.

		List<String> names = List.of("Hieu", "Long", "An");

		List<Integer> nameLengths = names.stream().map(String::length).toList();

		System.out.println(nameLengths); // [4,4,2]

		// sorted (sắp xếp dữ liệu)

		List<Integer> nums = List.of(5, 2, 3, 1, 4);

		List<Integer> asc = nums.stream().sorted().toList();

		List<Integer> desc = nums.stream().sorted(Comparator.reverseOrder()).toList();

		// forEach (thực thi cuối cùng)
		List<String> names2 = List.of("Hieu", "Long", "An");

		names2.stream().forEach(System.out::println);

		// collect (chuyển Stream về Collection)
		List<Integer> nums1 = List.of(1, 2, 3, 4, 5);

		// Lọc số chẵn và collect về List
		List<Integer> evenNums = nums1.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		
		//	reduce (tính toán tổng hợp)	
		
		int sum = List.of(1,2,3,4,5)
	              .stream()
	              .reduce(1, (a, b) -> a + b);

		System.out.println(sum);  // 15
	}
}
