package LeetCode;

import LeetCode.ReverseLinkedListII.ListNode;

public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList ins = new ReverseLinkedList();
    	ListNode head = ins.new ListNode(3);
    	head.next = ins.new ListNode(5);
    	ListNode test = ins.reverse(head);
    	System.console();
	}
	class ListNode {              
	    int val;                         
	    ListNode next;                   
	    ListNode(int x) {                
	        val = x;                     
	        next = null;                 
	    }                                
	}  
	
	// prev 		1 -> 2 -> 3
    public ListNode reverse(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode prev = new ListNode(0);
		prev.next = head;
		ListNode cur = head.next; //cur = 2
		head.next = null; // 1.next = null, cut 2 to 1
		while(cur != null) {			
			ListNode temp = cur.next; // temp = 3
			cur.next = prev.next; //cur points to the old head
			prev.next = cur;	// prev point to cur - the new head
			cur = temp;			//move cur node forward
		}
		return prev.next;
	}
}
