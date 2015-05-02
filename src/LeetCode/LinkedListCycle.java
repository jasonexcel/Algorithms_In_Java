/**
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */
package LeetCode;

import LeetCode.AddTwoNumbers.ListNode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!= null && slow != null) {
            if(slow == fast) {
                return true;
            }
            else {
                slow = slow.next;
                if(fast.next == null){
                    return false;
                }
                fast = fast.next.next;
            }
        }
        return false;
    }
}
