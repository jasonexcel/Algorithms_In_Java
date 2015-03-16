/**
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
package LeetCode;

public class SwapNodesInPairs {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	//my solution
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode runner = new ListNode(0);
        ListNode dummy = runner;
        runner.next = head;
        while(head != null && head.next != null) {
            runner.next = head.next;
            head.next = runner.next.next;
            runner.next.next = head;
            //move forward
            runner = head;
            head = head.next;
        }
        return dummy.next;
    }
	
    public ListNode swapPairsOld(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode ln = new ListNode(0);
        ln.next = head;
        ListNode start = ln;
        // check head and head.next here
        while(head != null && head.next != null) {
        	// 技巧：从链表最左边逐渐开始修改指向结点；最后再向前移动结点本身
        	//swap
            start.next = head.next;
            head.next = head.next.next;
            start.next.next = head;
            // two steps forward for start
            start = head;
            head = head.next;
        }
        
        return ln.next;
    }

}
