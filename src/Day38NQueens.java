/*
 * You have an N by N board. Write a function that, given N, 
 * returns the number of possible arrangements of the board where N queens can be 
 * placed on the board without threatening each other, 
 * 
 * i.e. no two queens share the same row, column, or diagonal.
 */
import java.util.*;

public class Day38NQueens {

	public static void main(String[] args) {
		
		int N = 5;
		System.out.println("The N Queen placement are: ");
		System.out.println(solveNQueens(N));

	}
	
	public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        
        //0 is for initial row number
        //new arrayList is for choices(columns)
        helper(n,0,new ArrayList<Integer>(),res);
        
        return res;
    }
    public static void helper(int n,int rowNum,ArrayList<Integer> choices,List<List<String>> res)
    {
        if(rowNum == n)
        {
            solution(choices,res);
            return;
        }
        else
        {
            for(int col=0;col<n;col++)
            {
                choices.add(col);//make choice
                if(checkChoice(choices))//constraints <checkChoice() function>
                {
                    helper(n,rowNum + 1,choices,res);//increment one row
                }
                choices.remove(choices.size() - 1);//remove choice
            }
        }
    }
    public static boolean checkChoice(ArrayList<Integer> choices)
    {
        int rowNumber = choices.size() - 1;
        for(int ch=0;ch<rowNumber;ch++)
        {
            int difference = Math.abs(choices.get(ch) - choices.get(rowNumber));
            //difference == 0 means same column of previous Queen
            //difference == rowNumber - ch means same diagonal of previous Queen
            if(difference == 0 || difference == rowNumber - ch)
            {
                return false;
            }
        }
        
        return true;
    }
    public static void solution(ArrayList<Integer> choices,List<List<String>> res)
    {
        List<String> al = new ArrayList<>();
        int n = choices.size();
        String str = "";
        for(int i=0;i<n;i++)
        {
            str = "";
            for(int j=0;j<n;j++)
            {
                if(choices.get(i) == j)
                {
                    str = str + 'Q';
                }
                else
                {
                    str = str + '.';
                }
            }
            al.add(str);
        }
        res.add(al);
    }

}
