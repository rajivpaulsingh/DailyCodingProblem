/*
 * Given a string, find the palindrome that can be made by inserting the fewest number of characters as possible anywhere in the word. 
 * If there is more than one palindrome of minimum length that can be made, return the lexicographically earliest one 
 * (the first one alphabetically).
 * 
 * For example, given the string "race", you should return "ecarace", 
 * since we can add three letters to it (which is the smallest amount to make a palindrome). 
 * There are seven other palindromes that can be made from "race" by adding three letters, but "ecarace" comes first alphabetically.
 * 
 * As another example, given the string "google", you should return "elgoogle".
 */

public class Day34MinInsertionsToMakePalindrome {

	public static void main(String[] args) {
		
		String str1 = "race";
		String str2 = "google";
		
		System.out.println("Minimum insertions required to make palindrome: " + minInsertions(str1));
		System.out.println("Minimum insertions required to make palindrome: " + minInsertions(str2));

	}
	
	public static int minInsertions(String st) {
		
        int[][] dp = new int[st.length()][st.length()];

      for (int i=0; i<st.length(); i++) {
          dp[i][i] = 1;
      }

      for (int start = st.length() - 1; start >= 0; start--) {
          for (int end = start + 1; end < st.length(); end++) {
              if (st.charAt(start) == st.charAt(end)) {
                  dp[start][end] = 2 + dp[start + 1][end - 1];
              } else {
                  dp[start][end] = Math.max(dp[start + 1][end], dp[start][end- 1]);
              }
          }
      }

      return st.length() - dp[0][st.length() - 1];
  }

}
