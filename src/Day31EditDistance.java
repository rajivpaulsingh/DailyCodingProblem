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
		
		System.out.println("The edit distance is: " + distance1(str1, n1, str2, n2));
		System.out.println("The edit distance is: " + distance2(str1, n1, str2, n2));

	}
	
	private static int distance1(String str1, int n1, String str2, int n2) {
		
		if(n1 == 0) {
			return n2;
		}
		
		if(n2 == 0 ) {
			return n1;
		}
		
		int cost = (str1.charAt(n1-1) == str2.charAt(n2-1)) ? 0 : 1;
		
		return minimum(distance1(str1, n1 - 1, str2, n2) + 1,  //deletion
				distance1(str1, n1, str2, n2 - 1) + 1,         //insertion
				distance1(str1, n1 - 1, str2, n2 - 1) + cost); //substitution

	}
	
	// Utility function to find minimum of three numbers
	public static int minimum(int a, int b, int c) {
		
		return Integer.min(a, Integer.min(b, c));
	}
	
	private static int distance2(String str1, int n1, String str2, int n2) {
		
		int dp[][] = new int[n1+1][n2+1];
		
		for(int i = 0; i <= n1; i++) {
			for(int j = 0; j <= n2; j++) {
				if(i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = 1 + minimum(dp[i][j-1],    //Insert
										   dp[i-1][j],    //Remove
										   dp[i-1][j-1]); //Replace
				}
			}
		}
		return dp[n1][n2];
	}

}
