import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and 
an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. 
For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", 
and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path 
to a file in the abstracted file system. If there is no file in the system, return 0.
 */

public class Day17LongestAbsolutePath {

	//Array
	public int lengthLongestPath1(String input) {
        String[] files = input.split("\n");
        int[] stack = new int[files.length + 1];
        int maxLength = 0;
        stack[0] = 0;
        for (String s : files) {
            int level = s.lastIndexOf("\t") + 1;
            int curLength = stack[level] + s.length() - level + 1;
            stack[level + 1] = curLength;
            if (s.contains(".")) {
                maxLength = Math.max(maxLength, curLength - 1);
            }
        }
        return maxLength;
    }
	
	//Stack
	public int lengthLongestPath2(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s:input.split("\n")){
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            while(lev+1<stack.size()) stack.pop(); // find parent
            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len-1); 
        }
        return maxLen;
    }

}
