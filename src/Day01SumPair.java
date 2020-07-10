import java.util.*;

public class Day01SumPair {

	public static void main(String[] args) {
		
		int arr[] = {10, 15, 3, 7};
		int k = 17;

		System.out.println("The pair with this sum is: ");
		sumPair1(arr, k);
		sumPair2(arr, k);
		
	}
	
	private static void sumPair1(int arr[], int k) {
		
		int n = arr.length;
		
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				
				if(arr[i] + arr[j] == k) {
					System.out.println("(" + arr[i] + ", " + arr[j] + ")");
				}
			}
		}
		
	}
	
	private static void sumPair2(int arr[], int k) {
		
		int n = arr.length;
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for(int i = 0; i < n; i++) {
			if(!hmap.containsKey(arr[i])) {
				hmap.put(k - arr[i], arr[i]);
			}
			else {
				System.out.println("(" + hmap.get(arr[i]) + ", " + arr[i] + ")");
			}
		}
	}

}
