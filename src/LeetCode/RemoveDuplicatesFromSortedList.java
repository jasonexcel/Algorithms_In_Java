package LeetCode;

public class RemoveDuplicatesFromSortedList {

	/**
	 * @param args
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }

	//my solution
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode runner = head.next;
        ListNode keeper = head;
        while(runner != null) {
            if(runner.val != keeper.val) {
                keeper.next = runner;
                keeper = keeper.next;
            }
            runner = runner.next;
        }    
        keeper.next = null;
        return head;
    }
	    public ListNode deleteDuplicatesIII(ListNode head) {
	        // Start typing your Java solution below
	        // DO NOT write main() function

	        if (head == null) {
	            return null;
	        }
	        ListNode newHead = head;
	        while(head.next != null) {
	            if (head.val == head.next.val) {
	                head.next = head.next.next;
	            }
	            else {
	                head = head.next;
	            }
	        }
	        
	        return newHead;
	    }
	    
	    // easier to understand and code
	    public ListNode deleteDuplicatesII(ListNode head) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        ListNode slow = head;
	        if(head ==null || head.next==null){
	        	return head;
	        }
	        ListNode fast = head.next;
	        while(fast != null){
	        	if(fast.val == slow.val){
	        		fast = fast.next;        		
	        	}
	        	else{
	        		slow.next = fast;
	        		slow = slow.next;
	        	}
	        }
	        slow.next = null;
	        return head;
	    }
}
