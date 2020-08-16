/*
 * Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. 
 * If such a subset cannot be made, then return null.
 * 
 * Integers can appear more than once in the list. You may assume all numbers in the list are positive.
 * For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
 */

import java.util.*;

public class Day42SubsetSum {

	public static void main(String[] args) {
		
		int arr[] = {12, 1, 61, 5, 9, 2};
		int target = 24;
		
		System.out.println("The subset with given sum is: " + sum(arr, target));

	}
	
	private static List<Integer> sum(int arr[], int target) {
		
		for(int i = 0; i < arr.length; i++) {
			int sum = 0;
			List<Integer> list = new ArrayList<Integer>();
			for(int j = i+1; j < arr.length; j++) {
				list.add(arr[j]);
				sum = sum + arr[i] + arr[j];
				if(sum == target) {
					return list;
				}
			}
		}
		return null;
	}

}
