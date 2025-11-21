package collectionsFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
		
		/*
		 * 	Set (không trùng lặp, không có chỉ số)
		 * 	HashSet → nhanh nhất
		 * 	LinkedHashSet → có thứ tự thêm vào
		 * 	TreeSet → sort tăng dần
		 */
		
		Set<String> ids = new HashSet<String>();
		
		Set<Integer> ids = new HashSet<>();
		ids.add(1);
		ids.add(1); // không thêm
		ids.add(2);

		System.out.println(ids); // [1,2]
		
		/*
		 * Map (key-value)
		 * HashMap
		 * LinkedHashMap
		 * TreeMap
		 */
		Map<String, Integer> scores = new HashMap<>();
		
		scores.put("Hieu", 95);
		scores.put("Long", 90);

		System.out.println(scores.get("Hieu")); // 95
	}
}
