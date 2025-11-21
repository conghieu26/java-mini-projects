package collectionsFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class theory {
	public static void main(String[] args)  { 
		/*
		 *  List (danh sách, có thứ tự, có thể trùng lặp)
		 *  ArrayList
		 *  LinkedList
		 */
		
		List<String> names = new ArrayList<String>();
		
		names.add("Hieu");
		names.add("Long");
		names.add("Hieu"); // được trùng
		
		System.out.println(names.get(0)); // Hieu
		
		
		// Pagination
		
		List<String> values = new LinkedList<String>();
		
		for(int i = 1; i <= 10; i++) {
			values.add("item" + i);
		}
		
		int pageSize = 3; 
		int page = 1;
		
		for(int start = 0; start < values.size(); start += pageSize) {
			int end = Math.min(start + pageSize, values.size()); 
			values.subList(start, end);
			page++;
		}
		
		
		/*
		 * 	Set (không trùng lặp, không có chỉ số)
		 * 	HashSet → nhanh nhất
		 * 	LinkedHashSet → có thứ tự thêm vào
		 * 	TreeSet → sort tăng dần
		 */
		
		Set<Integer> ids = new HashSet<>();
		ids.add(1);
		ids.add(1); // không thêm
		ids.add(2);

		System.out.println(ids); // [1,2]
		
		/*
		 * Map (key-value): 
		 * 		Map là một tập hợp các cặp key → value.
		 * 		Mỗi key là duy nhất (không được trùng).
		 * 		Value có thể trùng lặp.
		 * 		Map không phải là List hay Set, mà là structure riêng biệt để lưu trữ dữ liệu theo cặp.

		 * HashMap
		 * LinkedHashMap
		 * TreeMap
		 */
		Map<String, Integer> scores = new HashMap<>();
		
		scores.put("Hieu", 95);
		scores.put("Long", 90);

		System.out.println(scores.get("Hieu")); // 95
		
		// Một số thao tác phổ biến với Map
		
		System.out.println(scores.containsKey("Hieu"));// true
		System.out.println(scores.containsValue(100));  // false
		
		// Duyệt Map theo entry
		for (Map.Entry<String, Integer> entry : scores.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		
		
	}
}
