/*
 * Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
 * 
 * For example, given the string "([])[]({})", you should return true.
 * Given the string "([)]" or "((()", you should return false.
 */

import java.util.Stack;

public class Day27BalanceBrackets {

	public static void main(String[] args) {
		
		String str1 = "([])[]({})";
		String str2 = "([)]";
		String str3 = "((()";
		
		System.out.println("Are these brackets " + str1 + " balanced? " + isBalance(str1));
		System.out.println("Are these brackets " + str2 + " balanced? " + isBalance(str2));
		System.out.println("Are these brackets " + str3 + " balanced? " + isBalance(str3));

	}
	
	private static boolean isBalance(String str) {
		
		int n = str.length();
		if(str == null || n < 2) {
			return false;
		}
		
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < n; i++) {
			char c = str.charAt(i);
			
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if(c == ')') {
				if(stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			}
			else if(c == '}') {
				if(stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			}
			else if(c == ']') {
				if(stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			}
		}
		if(stack.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

}
