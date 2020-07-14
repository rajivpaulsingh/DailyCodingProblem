/*
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. 
 * Numbers can be 0 or negative.
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. 
 * [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 */

public class Day09LargestNonAdjacentSum {

	public static void main(String[] args) {
		
		int arr1[] = {2, 4, 6, 2, 5};
		int arr2[] = {5, 1, 1, 5};
		
		System.out.println("The max sum is: " + maxSum(arr1));
		System.out.println("The max sum is: " + maxSum(arr2));

	}
	
	private static int maxSum(int arr[]) {
		
		int n = arr.length;
		if(n < 1) {
			return 0;
		}
		
		int incl = arr[0];
		int excl = 0;
		int excl_new = 0;
		
		for(int i = 1; i < n; i++) {
			
			excl_new = Math.max(incl, excl);
			incl = excl + arr[i];
			excl = excl_new;
		}
		return Math.max(incl, excl);
	}

}
