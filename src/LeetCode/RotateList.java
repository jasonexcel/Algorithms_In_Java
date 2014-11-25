/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
package LeetCode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RotateList {
	//Definition for singly-linked list.   
	public class ListNode {              
	    int val;                         
	    ListNode next;                   
	    ListNode(int x) {                
	        val = x;                     
	        next = null;                 
	    }                                
	}                                    
	
    public ListNode rotateRight(ListNode head, int n) {
        if(n<=0 || head==null){
        	return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode runner = head;
        ListNode keeper = head;;
        int space=0;
        while(runner!=null){
        	space++;
        	runner = runner.next;
        }
        //space is not since head is not null here
        int rotateTimes = n%space;
        if(rotateTimes==0){
        	return head;
        }
        runner = head;
        space = 0;
        while(runner.next!=null){
        	if(space>=rotateTimes){
        		keeper = keeper.next;
        	}
        	runner = runner.next;
        	space++;
        }

        dummy.next = keeper.next;
        keeper.next = null;
        runner.next = head;
        return dummy.next;
    }
}