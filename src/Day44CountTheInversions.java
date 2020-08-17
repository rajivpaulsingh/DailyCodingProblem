/*
 * We can determine how "out of order" an array A is by counting the number of inversions it has. 
 * Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. That is, a smaller element appears after a larger element.
 * 
 * Given an array, count the number of inversions it has. Do this faster than O(N^2) time.
 * You may assume each element in the array is distinct.
 * 
 * For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions: 
 * (2, 1), (4, 1), and (4, 3). 
 * The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.
 */

public class Day44CountTheInversions {

	public static void main(String[] args) {
		
		int arr1[] = {2, 4, 1, 3, 5};
		int arr2[] = {5, 4, 3, 2, 1};
		
		System.out.println("The number or inversions are: " + inversions(arr1));
		System.out.println("The number or inversions are: " + inversions(arr2));

	}

	private static int inversions(int[] arr) {
		
		if(arr == null) {
			return 0;
		}
		
		int n = arr.length;
		int count = 0;
		
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				if(arr[i] > arr[j]) {
					count++;
				}
			}
		}
		return count;
	}

}
