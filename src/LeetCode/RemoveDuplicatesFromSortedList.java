package LeetCode;

public class RemoveDuplicatesFromSortedList {

	/**
	 * @param args
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
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

	        if (head == null) {
	            return null;
	        }
	        ListNode newHead = head;
	        while(head.next != null) {
	            if (head.val == head.next.val) {
	                head.next = head.next.next;
	            }
	            else {
	                head = head.next;
	            }
	        }
	        
	        return newHead;
	    }
}
