package LeetCode;

public class RemoveDuplicatesFromSortedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	
	public ListNode deleteDuplicates(ListNode head) {
		    // Start typing your Java solution below
		    // DO NOT write main() function
		ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode start = sentinel;
        while(head != null) {
            boolean dup = false;
            while(head.next != null && head.val == head.next.val) {
                dup = true;
                head = head.next;
            }
            if(dup) {
            	// remove duplicates
                start.next = head.next;
            }
            else{
            	//no duplication, move to current location
                start = head;
            }
            head = head.next;
        }
        return sentinel.next;
		}

}
