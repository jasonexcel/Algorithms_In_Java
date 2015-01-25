/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
package LeetCode;

/**
 * O(n) time, O(1) space
 *
 */


public class ReverseNodesInKGroup {

	/**
	 * @param args
	 */
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1){
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        int pos = 1;
        while(cur!=null){
        	ListNode next = cur.next;
        	if(pos%k==0){
        		pre = reverse(pre, next);
        	}
        	cur = next;
        	pos++;
        }
        return dummy.next;
    }
    //reverse the section, and return the first node of the section
    private ListNode reverse(ListNode pre, ListNode curEndNext){
    	//last round ended at the last node in the linked node , pre is null
    	if(pre == null || pre.next == null){
    		return null;
    	}
    	ListNode curHead = pre.next;
    	ListNode runner = curHead.next;
    	//runner will run before current section's end's next node
    	while(runner != curEndNext){
    		// in the loop, always insert runner at the head of linked list
    		ListNode runnerNext = runner.next;
    		runner.next = pre.next;
    		pre.next = runner;
    		runner = runnerNext;
    	}
    	curHead.next = curEndNext; // point the first node in the linked list to the first node of next section
    	return curHead;
    }
    
    
}
