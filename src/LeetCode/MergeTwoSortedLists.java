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
    //without dummy head
    public ListNode mergeTwoListsII(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode res;
        if(l1.val < l2.val) {
            res = new ListNode(l1.val);
            l1 = l1.next;
        }
        else {
            res = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode head = res;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            res = res.next;
        }
        if(l1 != null) {
            res.next = l1;
        }
        if(l2 != null) {
            res.next = l2;
        }
        return head;
    }

}
