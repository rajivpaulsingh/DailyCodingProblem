import java.util.Random;

/*
 * Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, 
 * implement a function rand7() that returns an integer from 1 to 7 (inclusive).
 */

public class Day45Rand7UsingRand5 {

	public static void main(String[] args) {
		
		System.out.println("Random number between 1 to 7 is: " + rand7());

	}
	
	private static int rand7() {
		
		int arr[][] = {
				{1, 2, 3, 4, 5},
				{6, 7, 1, 2, 3},
				{4, 5, 6, 7, 1},
				{2, 3, 4, 5, 6},
				{7, 0, 0, 0, 0}		
		};
		
		int row = rand5() - 1;
		int col = rand5() - 1;
		
		if(row == 4 & col > 0) {
			return rand7();
		}
		
		return arr[row][col];
	}
	
	private static int rand5() {
		
		Random rand = new Random();
		int result = 0;
		int arr[] = {1, 2, 3, 4, 5};
		
		for(int i = 0; i < arr.length; i++) {
			result = rand.nextInt(arr[i]);
		}
		return result;
	}

}
