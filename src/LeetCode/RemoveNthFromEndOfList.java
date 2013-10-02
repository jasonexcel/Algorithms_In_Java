package LeetCode;

public class RemoveNthFromEndOfList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; next = null;}
	  }	
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(n<=0) return head;
	        int count = 1;
	        ListNode pointA = new ListNode(0);
	        pointA.next = head;
	        ListNode pointB = pointA;
	        while(head.next != null) {
	            head = head.next;
	            if(count>=n) {
	                pointA = pointA.next;
	            }
	            count++;
	            
	        }
	        if (pointA.next != null)    pointA.next = pointA.next.next;
	        return pointB.next;
	    }
}
