/*
 * Given a function that generates perfectly random numbers between 1 and k (inclusive), 
 * where k is an input, write a function that shuffles a deck of cards represented as an array using only swaps.
 * 
 * It should run in O(N) time.
 * Hint: Make sure each one of the 52! permutations of the deck is equally likely.
 */

import java.util.*;

public class Day51ShuffleDeckOfCards {

	public static void main(String[] args) {
		
		System.out.println("The shuffled deck of cards is: ");
		System.out.println(Arrays.toString(shuffle()));

	}
	
	private static int[] shuffle() {
		
		int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 
                9, 10, 11, 12, 13, 14, 15, 
                16, 17, 18, 19, 20, 21, 22, 
                23, 24, 25, 26, 27, 28, 29, 
                30, 31, 32, 33, 34, 35, 36, 
                37, 38, 39, 40, 41, 42, 43, 
                44, 45, 46, 47, 48, 49, 50,  
                51}; 
		
		Random rand = new Random();
		
		for(int i = arr.length - 1; i > 0; i--) {
			
			int j = rand.nextInt(i + 1);
			int temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
		}
		
		return arr;
	}

}
