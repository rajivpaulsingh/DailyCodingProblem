/*
 * Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.
 */

/**
 * So how do we generate a random number from the whole stream such that the probability of picking any 
 * number is 1/n. with O(1) extra space? This problem is a variation of Reservoir Sampling. Here the value of k is 1.

1) Initialize ‘count’ as 0, ‘count’ is used to store count of numbers seen so far in stream.
2) For each number ‘x’ from stream, do following
…..a) Increment ‘count’ by 1.
…..b) If count is 1, set result as x, and return result.
…..c) Generate a random number from 0 to ‘count-1’. Let the generated random number be i.
…..d) If i is equal to ‘count – 1’, update the result as x.
 * @author singh2rajiv
 *
 */

import java.util.Random; 

public class Day15RandomFromStream {

	static int res = 0;    // The resultant random number 
    static int count = 0;  //Count of numbers visited so far in stream 
    
	public static void main(String[] args) {
		
		int stream[] = {1, 2, 3, 4}; 
        int n = stream.length; 
        for(int i = 0; i < n; i++) {
        	System.out.println("Random number from first " + (i+1) + " numbers is " + selectRandom(stream[i]));
        }
            
	}
	
	private static int selectRandom(int x) {
		
		count++; // increment count of numbers seen so far 
        
        // If this is the first element from stream, return it 
        if (count == 1) {
        	res = x;
        } 
        else { 
             // Generate a random number from 0 to count - 1 
            Random r = new Random(); 
            int i = r.nextInt(count); 
              
            // Replace the prev random number with new number with 1/count probability 
            if(i == count - 1) 
                res = x; 
        } 
        
        return res; 
	}

}
