/*
 * Given an array of numbers, find the maximum sum of any contiguous subarray of the array.
 * For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.
 * 
 * Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.
 */

public class Day49MaxContinuousSum {

	public static void main(String[] args) {
		
		int arr1[] = {34, -50, 42, 14, -5, 86};
		int arr2[] = {-5, -1, -8, -9};
		
		System.out.println("The maximum sum is: " + maxSum(arr1));
		System.out.println("The maximum sum is: " + maxSum(arr2));
	}
	
	private static int maxSum(int arr[]) {
		
		int n = arr.length;
		if(n < 1) {
			return -1;
		}
		
		int sum = arr[0];
		int max = arr[0];
		for(int i = 1; i < n; i++) {
			sum = Math.max(sum + arr[i], arr[i]);
			max = Math.max(max, sum);
		}
		
		return max;
	}

}
