/*
 * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
 * 
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */

import java.util.*;

public class Day13LongestSubstring {

	public static void main(String[] args) {
		
		String str = "abcba";
		int k = 2;
		
		System.out.println("Longest substring with k distinct characters is: " + longestSubstring(str, k));

	}
	
	private static int longestSubstring(String str, int k) {
		
		if(str == null || str.length() == 0 || k <= 0) {
			return 0;
		}
		
		Map<Character, Integer> hmap = new HashMap<Character, Integer>();
		int j = 0;
		int maxLen = 0;
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(!hmap.containsKey(c)) {
				hmap.put(c, 1);
			} else {
				hmap.put(c, hmap.get(c) + 1);
			}
			
			if(hmap.size() > k) {
				maxLen = Math.max(maxLen, i - j);
				
				// Shrink the window size
                while (hmap.size() > k) {
                    char endC = str.charAt(j);
                    if (hmap.get(endC) == 1) {
                    	hmap.remove(endC);
                    } else {
                    	hmap.put(endC, hmap.get(endC) - 1);
                    }
                    j++;
                }
			}
			if(j < str.length()) {
				maxLen = Math.max(maxLen, i - j);
			}
			
		}		
		return maxLen;
	}

}
