/*
 * Given an array of integers and a number k, where 1 <= k <= length of the array, 
 * compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
 */

public class Day18MaximumInSubarray {

	public static void main(String[] args) {
		
		int arr[] = {10, 5, 2, 7, 8, 7};
		int k = 3;
		
		System.out.println("Maximum subarray number is: ");
		printKMax(arr, k);

	}
	
	private static void printKMax(int arr[], int k) {
		
		int n = arr.length;
		int max = 0;
		
		if(n < 1) {
			System.out.println("Invalid array");
		}
		
		for(int i = 0; i <= n-k; i++) {
			max = arr[i];
			
			for(int j = 1; j < k; j++) {
				if(arr[i + j] > max) {
					max = arr[i + j];
				}
			}
			System.out.print(max + " ");
		}
	}

}
