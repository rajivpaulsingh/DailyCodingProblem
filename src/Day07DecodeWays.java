/*
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */

public class Day07DecodeWays {

	public static void main(String[] args) {
		
		String str1 = "111";
		String str2 = "23";
		
		System.out.println("Number of ways it can be decoded: " + decode(str1));
		System.out.println("Number of ways it can be decoded: " + decode(str2));

	}
	
	private static int decode(String str) {
		
		if(str == null || str.length() == 0) {
			return 0;
		}
		
		int dp[] = new int[str.length() + 1];
		dp[0] = 1; //if the size is zero;
		
		//If the first character is any number b/w 1 and 9, then there is one way to decode.
	    //If the first character is 0, which is invalid in the context, so then there is no  way to decode.
		dp[1] = str.charAt(0) == '0' ? 0 : 1;
		
		for(int i = 2; i <= str.length(); i++) {
			
			//We are just converting the current character to number 
		    //For example, If we have s = '25', For i=2, we do a substring(1,2) to get '5' and store it in oneDigit
			int oneDigit = Integer.valueOf(str.substring(i - 1, i));
			
			//Next, we try just getting the last two digits (including the current character and the previous character)
		    //For example, If we have s = '25', For i=2, we get substring(0,2) to get '25' and store it in twoDigit
			int twoDigits = Integer.valueOf(str.substring(i - 2,  i));
			
		    //if the current digit is a valid decodable digit (any digit other than '0')  
			if(oneDigit >= 1) {
				dp[i] = dp[i] + dp[i - 1];
			}
			
			if(twoDigits >= 10 && twoDigits <= 26) {
				dp[i] = dp[i] + dp[i - 2];
			}
		}
		
		//Finally we return the number of ways to decode the string length
		return dp[str.length()];
	}

}
