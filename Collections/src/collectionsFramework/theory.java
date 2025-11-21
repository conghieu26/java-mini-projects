package collectionsFramework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
		
		
	}
}
