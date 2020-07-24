/*
 * Given two singly linked lists that intersect at some point, find the intersecting node. 
 * The lists are non-cyclic.
 * 
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 */

import java.util.HashMap;

public class Day20LinkedListIntersection {

	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		     val = x;
		     next = null;
		 }
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        HashMap<ListNode, Integer> hmap = new HashMap<ListNode, Integer>();
        ListNode temp = headA;
        while(temp != null) {
            hmap.put(temp, 1);
            temp = temp.next;
        }
        
        temp = headB;
        while(temp != null) {
            if(hmap.containsKey(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        
        return null;
    }

}
