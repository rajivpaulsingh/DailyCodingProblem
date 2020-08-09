import java.util.Arrays;

/*
 * Given an array of strictly the characters 'R', 'G', and 'B', 
 * segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. 
 * You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 */

public class Day35Sort0s1s2s {

	public static void main(String[] args) {
		
		int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}; 
        int n = arr.length; 
        
        System.out.println("The array after segregation is: " + Arrays.toString(segragate(arr, n)));

	}
	
	private static int[] segragate(int arr[], int n) {
		
		int i;
		int c0 = 0, c1 = 0, c2 = 0;
		
		for(i = 0; i < n; i++) {
			switch(arr[i]) {
			case 0: 
				c0++;
				break;
			
			case 1:
				c1++;
				break;
			
			case 2:
				c2++;
				break;
			}				
		}
		
		i = 0; //update the array;
		while(c0 > 0) {
			arr[i++] = 0;
			c0--;
		}
		while(c1 > 0) {
			arr[i++] = 1;
			c1--;
		}
		while(c2 > 0) {
			arr[i++] = 2;
			c2--;
		}
		
		return arr;
	}

}
