/*
 * Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.
 * 
 * For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, 
 * it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.
 * 
 * Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets that add up to the same sum.
 */

public class Day60PartitionProblem {

	public static void main(String[] args) {
		
		int arr[] = {3, 1, 5, 9, 12}; 
        int n = arr.length; 
        
        if (findPartition(arr, n) == true) 
            System.out.println("Can be divided into two subsets of equal sum"); 
        else
            System.out.println("Can not be divided into two subsets of equal sum");

	}
	
	public static boolean findPartition (int arr[], int n) { 
        // Calculate sum of the elements in array 
        int sum = 0; 
        for (int i = 0; i < n; i++) 
            sum += arr[i]; 
  
        // If sum is odd, there cannot be two subsets with equal sum 
        if (sum%2 != 0) 
            return false; 
  
        // Find if there is subset with sum equal to halfof total sum 
        return isSubsetSum (arr, n, sum/2); 
    } 
	
	public static boolean isSubsetSum (int arr[], int n, int sum) { 
        // Base Cases 
        if (sum == 0) 
            return true; 
        if (n == 0 && sum != 0) 
            return false; 
  
        // If last element is greater than sum, then ignore it 
        if (arr[n-1] > sum) 
            return isSubsetSum (arr, n-1, sum); 
  
        /* else, check if sum can be obtained by any of the following 
        (a) including the last element 
        (b) excluding the last element 
        */
        return isSubsetSum (arr, n-1, sum) || 
               isSubsetSum (arr, n-1, sum-arr[n-1]); 
    } 

}
