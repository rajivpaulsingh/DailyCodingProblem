/*
 * Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. 
 * If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
 * 
 * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", 
 * you should return ['the', 'quick', 'brown', 'fox'].
 * 
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", 
 * return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */

import java.util.*;

public class Day22WordBreak {

	public static void main(String[] args) {
		
		String words1[] = {"quick", "brown", "the", "fox"};
		String str1 = "thequickbrownfox";
		
		String words2[] = {"bed", "bath", "bedbath", "and", "beyond"};
		String str2 = "bedbathandbeyond";
		
		String words3[] = {"this", "th", "is", "famous", "Word", "break", "b", "r", "e", "a", "k", "br", "bre", "brea", "ak", "problem"};
		String str3 = "Wordbreakproblem";
		
		System.out.println("The list is: " + wordBreak(words1, str1));
		System.out.println("The list is: " + wordBreak(words2, str2));
		System.out.println("The list is: " + wordBreak(words3, str3));

	}
	
	private static List<String> wordBreak(String words[], String str) {
		
		int n = words.length;
		if(n == 0) {
			return null;
		}
		
		HashSet<String> hset = new HashSet<String>();
		List<String> list = new ArrayList<String>();
		
		for(String temp : words) {
			hset.add(temp);
		}
		
		for(int i = 1; i <= n; i++) {
			if(hset.contains(str.substring(0, i))) {
				//TODO
			}
		}
		return list;
	}

}
