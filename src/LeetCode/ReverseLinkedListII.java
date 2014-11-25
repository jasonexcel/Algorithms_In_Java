/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
package LeetCode;

import LeetCode.RotateList.ListNode;


public class ReverseLinkedListII {
	//Definition for singly-linked list.   
	public class ListNode {              
	    int val;                         
	    ListNode next;                   
	    ListNode(int x) {                
	        val = x;                     
	        next = null;                 
	    }                                
	}  
	
	//My solution, better
	public ListNode reverseBetween(ListNode head, int m, int n) {
	    if(head == null){
	        return null;
	    }
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode pre = dummy;
	    int count = 1;
	    while(pre.next!=null && count<m){
	    	pre = pre.next;
	    	count++;
	    }
	    ListNode mNode = pre.next;
	    while(mNode.next!=null && count<n){
	    	ListNode nextNext = mNode.next.next;
	    	mNode.next.next = pre.next;
	    	pre.next = mNode.next;
	    	mNode.next = nextNext;
	    	count++;
	    }
	    return dummy.next;
    }
	
	//ignore
    public ListNode reverseBetweenII(ListNode head, int m, int n) {
	    if(head == null){
	        return null;
	    }
	    ListNode runner = new ListNode(0);
	    //ListNode dummy = new ListNode(0);
	    runner.next = head;
	    //dummy.next = head;
	    int count = 1;
	    while(runner.next!=null && count<n){
	    	runner = runner.next;
	    	count++;
	    }
	    //ListNode mNode = runner.next;
	    ListNode pre = runner;
	    ListNode cur = runner.next;
	    while(cur.next!=null && count<m){
	    	ListNode nextNext = cur.next.next;
	    	cur.next.next = pre.next;
	    	pre.next = cur.next;
	    	cur.next = nextNext;
	    	count++;
	    }
	    return head;
    }    
    
    public static void main(String[] args){
    	ReverseLinkedListII ins = new ReverseLinkedListII();
    	ListNode head = ins.new ListNode(3);
    	head.next = ins.new ListNode(5);
    	ListNode test = ins.reverseBetween(head,1,2);
    	System.console();
    }
}
