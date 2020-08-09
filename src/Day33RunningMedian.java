//import java.util.Collections;
//
///*
// * Compute the running median of a sequence of numbers. 
// * That is, given a stream of numbers, print out the median of the list so far on each new element.
// * 
// * Recall that the median of an even-numbered list is the average of the two middle numbers.
// * For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
//
//2
//1.5
//2
//3.5
//2
//2
//2
//
// */
//
//import java.util.*;
//
//public class Day33RunningMedian {
//
//	public static void main(String[] args) {
//		
//		int arr[] = {2, 1, 5, 7, 2, 0, 5};
//		
//		System.out.println("The running median is:");
//		runningMedian(arr);
//
//	}
//	
//	private static void runningMedian(int arr[]) {
//		
//		PriorityQueue<Integer> minHeap = minHeap = new PriorityQueue<>();
//	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//	 
//	    public void addNum(int num) {
//	        minHeap.offer(num);
//	        maxHeap.offer(minHeap.poll());
//	 
//	        if(minHeap.size()<maxHeap.size()){
//	            minHeap.offer(maxHeap.poll());
//	        }
//	    }
//	 
//	    public double findMedian() {
//	        if(minHeap.size() > maxHeap.size()){
//	            return minHeap.peek();
//	        }else {
//	            return (minHeap.peek()+maxHeap.peek())/2.0;
//	        }
//	    }
//	}
//
//}
