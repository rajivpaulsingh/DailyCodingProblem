/*
 * Run-length encoding is a fast and simple method of encoding strings. 
 * The basic idea is to represent repeated successive characters as a single count and character. 
 * For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 * 
 * Implement run-length encoding and decoding. You can assume the string to be encoded have no digits 
 * and consists solely of alphabetic characters. You can assume the string to be decoded is valid.
 */

public class Day29RunLengthEncoding {

	public static void main(String[] args) {
		
		String str = "AAAABBBCCDAA";
		System.out.println("The run-length encoding is: " + encode(str));

	}
	
	private static String encode(String str) {
		
		int n = str.length();
		if(str == null || n < 1) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n-1; i++) {
			
			int len = 1;			
			while(i + 1 < n && str.charAt(i) == str.charAt(i + 1)) {
				len++;
				i++;
			}
			sb.append(len);
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

}
