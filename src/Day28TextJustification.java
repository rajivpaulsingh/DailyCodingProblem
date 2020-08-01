/*
 * Write an algorithm to justify text. Given a sequence of words and an integer line length k, 
 * return a list of strings which represents each line, fully justified.

More specifically, you should have as many words as possible in each line. 
There should be at least one space between each word. Pad extra spaces when necessary so that each line has exactly length k. 
Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting from the left.

If you can only fit one word on a line, then you should pad the right-hand side with spaces.

Each word is guaranteed not to be longer than k.

For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"]
 and k = 16, you should return the following:

["the  quick brown", # 1 extra space on the left
"fox  jumps  over", # 2 extra spaces distributed evenly
"the   lazy   dog"] # 4 extra spaces distributed evenly
 */

import java.util.*;

public class Day28TextJustification {

	public static void main(String[] args) {
		
		String words[] = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
		int k = 16;
		
		System.out.println("Justified text is: " + fullJustify(words, k));

	}
	
	public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        if(words.length == 0) return ans;
        // the total width of the words that have been visited
        int width = 0;
        // the total number of the words that have been visited
        int count = 0;
        for(int i = 0, j = 0; i < words.length; i++){
            width += words[i].length();
            count++;
            //construct the lines that are not the last
            //(count - 1) is the number of slots
            if(width + (count - 1) > maxWidth){ 
                count--;
                width -= words[i].length();
                int subWidth = maxWidth - width;
                int avgSpace = (count - 1) == 0 ? 0 :subWidth / (count - 1);
                //if the spaces can't be distributed evenly.
                int extraSpace = subWidth - avgSpace * (count - 1);
                StringBuilder sb = new StringBuilder();
                for(int k = j; k < i; k++){
                    sb.append(words[k]);
                    if(k != i - 1){
                        for(int m = 0; m < avgSpace; m++) sb.append(' ');
                        if(extraSpace > 0){
                            sb.append(' ');
                            extraSpace--;
                        }
                    }
                    //spiecial situation: just have 1 word
                    else if(count == 1){
                        for(int m = 0; m < extraSpace; m++) sb.append(' ');
                    }
                }
                ans.add(sb.toString());
                width = 0;
                count = 0;
                j = i;
                i--;
            }
            //construct the last line
            else if(i == words.length - 1){
                StringBuilder sb = new StringBuilder();
                int subWidth = maxWidth - width;
                for(int k = j; k <= i; k++){
                    sb.append(words[k]);
                    if(subWidth > 0){
                        sb.append(' ');
                        subWidth--;
                    }
                }
                for(int m = 0; m < subWidth; m++) sb.append(' ');
                ans.add(sb.toString());
            }
        }
        
        return ans;
    }

}
