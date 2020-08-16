/*
 * Given an array of integers where every integer occurs three times except for one integer,
 *  which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.
 */
import java.util.*;

public class Day40FindNonDuplicateInteger {

	public static void main(String[] args) {
		
		int arr[] = {6, 1, 3, 3, 3, 6, 6};
		System.out.print("The non-duplicate integer is: ");
		nonDuplicate(arr);

	}
	
	private static void nonDuplicate(int arr[]) {
		
		Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			if(!hmap.containsKey(arr[i])) {
				hmap.put(arr[i], 1);
			} else {
				hmap.put(arr[i], hmap.get(arr[i]) + 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
			if(entry.getValue() == 1) {
				System.out.print(entry.getKey());
			}
		}
	}

}
