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
	
	public ListNode deleteDuplicatesII(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode keeper = dummy;
        if(head == null){
        	return null;
        }
        int curVal=head.val;
        int numCount = 1;
        while(head.next!=null){
        	if(head.next.val==curVal){
        		numCount++;
        		head = head.next;
        	}
        	else{
        		if(numCount==1){
        			//no duplicate
        			keeper.next = head;
        			keeper = keeper.next;
        		}
        		else{
            		//reset numCount to remove all duplicates
            		numCount = 1;
        		}

        		curVal = head.next.val;
        		head = head.next;
        	}
        }
        if(numCount==1){
        	keeper.next = head;
        }
        else{
        	//remove all duplicates
        	keeper.next = null;
        }
        return dummy.next;
    }
}
