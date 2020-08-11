/*
 * The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.
 * 
 * For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}
 */

import java.util.*;

public class Day37SubsetOfSet {

	public static void main(String[] args) {
		
		int arr[] = {1, 2, 3};
		String str = arr.toString();
		
		System.out.println("Subsets of set are: " + subsets(str));

	}
	
	private static Set<String> subsets(String str) {
		
		if(str.length() < 1) {
			return null;
		}
		
		Set<String> set = new HashSet<String>();
		
		for(int i = 0; i < str.length(); i++) {
			if(!set.contains(str.substring(0, i))) {
				set.add(str.substring(0, i));
			}
		}
		return set;
	}

}
