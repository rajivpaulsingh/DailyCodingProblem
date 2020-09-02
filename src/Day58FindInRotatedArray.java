/*
 * An sorted array of integers was rotated an unknown number of times.
 * Given such an array, find the index of the element in the array in faster than linear time. 
 * If the element doesn't exist in the array, return null.
 * 
 * For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).
 * You can assume all the integers in the array are unique.
 */

public class Day58FindInRotatedArray {

	public static void main(String[] args) {
		
		int arr[] = {13, 18, 25, 2, 8, 10};
		int target = 8;
		
		System.out.println("The target is at index: " + search(arr, target));
	}
	
	public static int search(int[] arr, int target) {
		
		int left = 0;
		int right = arr.length - 1;
		int index = -1;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			
			if(arr[mid] >= target) {
				index = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return index;
	}

}
