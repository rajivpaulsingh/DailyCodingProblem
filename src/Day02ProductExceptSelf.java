import java.util.*;

public class Day02ProductExceptSelf {

	public static void main(String[] args) {
		
		int arr1[] = {1, 2, 3, 4, 5};
		int arr2[] = {3, 2, 1};
		int arr3[] = {-2, -5, 3, 1};
		
		System.out.println(Arrays.toString(productExceptSelf(arr1)));
		System.out.println(Arrays.toString(productExceptSelf(arr2)));
		System.out.println(Arrays.toString(productExceptSelf(arr3)));

	}
	
	private static int[] productExceptSelf(int arr[]) {
		
		int n = arr.length;
		int newArr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			
			int temp = 1;
			for(int j = 0; j < n; j++) {
				if(i != j) {
					temp = temp * arr[j];
				}
			}
			newArr[i] = temp;
		}
		return newArr;
	}

}
