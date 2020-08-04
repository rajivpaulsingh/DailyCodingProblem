/*
 * The edit distance between two strings refers to the minimum number of character insertions, deletions, 
 * and substitutions required to change one string to the other. 
 * 
 * For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”, 
 * substitute the “e” for “i”, and append a “g”.
 * 
 * Given two strings, compute the edit distance between them.
 */

public class Day31EditDistance {

	public static void main(String[] args) {
		
		String str1 = "kitten";
		String str2 = "sitting";
		int n1 = str1.length();
		int n2 = str2.length();
		
		System.out.println("The edit distance is: " + distance(str1, n1, str2, n2));

	}
	
	private static int distance(String str1, int n1, String str2, int n2) {
		
		if(n1 == 0) {
			return n2;
		}
		
		if(n2 == 0 ) {
			return n1;
		}
		
		int cost = (str1.charAt(n1-1) == str2.charAt(n2-1)) ? 0 : 1;
		
		return minimum(distance(str1, n1 - 1, str2, n2) + 1,  //deletion
				distance(str1, n1, str2, n2 - 1) + 1,         //insertion
				distance(str1, n1 - 1, str2, n2 - 1) + cost); //substitution

	}
	
	// Utility function to find minimum of three numbers
	public static int minimum(int a, int b, int c) {
		
		return Integer.min(a, Integer.min(b, c));
	}

}
