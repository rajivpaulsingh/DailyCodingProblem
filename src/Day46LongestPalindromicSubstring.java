/*
 * Given a string, find the longest palindromic contiguous substring. 
 * If there are more than one with the maximum length, return any one.
 * 
 * For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana"
 */

public class Day46LongestPalindromicSubstring {

	public static void main(String[] args) {
		
		String str = "aabcdcb";
		
		System.out.println("The longest palindromic string is: " + longPalin(str));

	}
	
	private static String longPalin(String str) {
		
		int n = str.length();
		if(str == null || n == 0) {
			return "";
		}
		
		String LongestPalindrome = "";
		
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				if(j - i > LongestPalindrome.length() && isPalin(str.substring(i, j))) {
					LongestPalindrome = str.substring(i, j);
				}
			}
		}
		return LongestPalindrome;
	}
	
	private static boolean isPalin(String str) {
		
		int left = 0;
		int right = str.length()-1;
		
		while(left < right) {
			if(str.charAt(left) != str.charAt(right)) {
				return false;
			}
		}
		return true;
	}

}
