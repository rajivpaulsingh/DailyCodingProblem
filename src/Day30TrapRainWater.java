/*
 * You are given an array of non-negative integers that represents a two-dimensional elevation map 
 * where each element is unit-width wall and the integer is the height. 
 * Suppose it will rain and all spots between two walls get filled up.
 * 
 * Compute how many units of water remain trapped on the map in O(N) time and O(1) space.
 * For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.
 * 
 * Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, 
 * and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
 */

public class Day30TrapRainWater {

	public static void main(String[] args) {
		
		int arr1[] = {2, 1, 2};
		int arr2[] = {3, 0, 1, 3, 0, 5};
		
		System.out.println("Max trapped water is: " + trap(arr1));
		System.out.println("Max trapped water is: " + trap(arr2));

	}
	
	public static int trap(int[] arr) {
	      
		  int water = 0;
		  int left = 0;
		  int right = arr.length-1;
		    
		  int leftMax = 0;
		  int rightMax = 0;
		    
		  while(left <= right) {
		      leftMax = Math.max(leftMax, arr[left]);
		      rightMax = Math.max(rightMax, arr[right]);
		        
		      if(leftMax < rightMax) {
		          water = water + (leftMax - arr[left]);
		          left++;
		      }
		      else {
		          water = water + (rightMax - arr[right]);
		          right--;
		      }
		  }
		  return water;
	  }

}
