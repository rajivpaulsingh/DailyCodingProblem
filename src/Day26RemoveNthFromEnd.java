
public class Day26RemoveNthFromEnd {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode temp = head;
        int size = 0;
        
        while(temp != null){
            
            size++;
            temp = temp.next;
        }
        
        if(size == n)
            return head.next;
        
        temp = head;
        int i = 0;
        
        while(i != size - n - 1){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        
        return head;    
    }

}
