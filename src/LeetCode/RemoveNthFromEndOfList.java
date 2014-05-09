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
	 public ListNode removeNthFromEndII(ListNode head, int n) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        ListNode n1 = new ListNode(0);
	        n1.next = head;
	        ListNode n2 = n1;
	        ListNode newHead = head;
	        for(int i=0; i<n; i++){
	        	newHead = newHead.next;
	        }
	        while(newHead!=null){
	        	n1 = n1.next;
	        	newHead = newHead.next;
	        }
	        n1.next = n1.next.next;
	        return n2.next;
	    }
}
