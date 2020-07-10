// find the lowest positive integer that does not exist in the array
import java.util.*;

public class Day04MissingNumber {

	public static void main(String[] args) {
		
		int arr1[] = {3, 4, -1, 1};
		int arr2[] = {1, 2, 0};
		
		System.out.println("The missing number is: " + missingNum(arr1));
		System.out.println("The missing number is: " + missingNum(arr2));

	}
	
	private static int missingNum(int arr[]) {
		
		int n = arr.length;
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < n; i++) {
			if(!set.contains(arr[i])) {
				set.add(arr[i]);
			}
		}
		
		int num = 1;
		
		while(true) {
			if(!set.contains(num++)) {
				return num - 1;
			}
			else {
				continue;
			}
		}
	}

}
