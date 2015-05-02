/**
 * 
 */
package LeetCode;



/**
 * @author Shaun
 *
 */

class ListNode {
	int val;
	ListNode next;
	
	public ListNode(int value) {
		this.val = value;
		next = null;
	}
}
public class LinkedListCycleII {

	public static void main(String[] args) {
		LinkedListCycleII ins = new LinkedListCycleII();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = head;
		
		System.out.println(ins.detectCycle(head).val);
		
	}
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        
        slow = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
