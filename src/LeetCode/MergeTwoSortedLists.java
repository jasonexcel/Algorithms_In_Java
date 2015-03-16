/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
package LeetCode;

public class MergeTwoSortedLists {
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode l3 = new ListNode(0);
        ListNode ls = l3;
        while(l1 != null && l2!=null) {
            if(l1.val<l2.val) {
                l3.next = l1;
                l1 = l1.next;
                l3 = l3.next;
            }
            else {
                l3.next = l2;
                l2 = l2.next;
                l3 = l3.next;
            }
        }
        if(l1 != null) {
            l3.next = l1;
        }
        else if(l2 != null) {
            l3.next = l2;
        }
        return ls.next;    
    }

}
