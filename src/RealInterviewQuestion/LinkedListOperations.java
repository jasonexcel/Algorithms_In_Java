package RealInterviewQuestion;

import java.util.ArrayList;

public class LinkedListOperations {
	//singly-linked list 
	 class ListNode {              
	    int val;                         
	    ListNode next;                   
	    ListNode(int x) {                
	        val = x;                     
	        next = null;                 
	    }                                
	}  
	// 
	public ArrayList<ListNode> reverseAndSplit(ListNode head) {
		ArrayList<ListNode> results = new ArrayList<ListNode>();
		if(head == null) {
			return results;
		}
		ListNode newHead = reverseLinkedList(head);
		results = splitIntoTwoLinkedList(newHead);
		return results;
	}

	//reverse
	private ListNode reverseLinkedList(ListNode head) {	
		if (head == null || head.next == null) {
            return head;
        }	
	    ListNode prev = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }	
    //split 
    private ArrayList<ListNode> splitIntoTwoLinkedList(ListNode head) {
    	ArrayList<ListNode> results = new ArrayList<ListNode>();
    	if(head == null) {
    		return results;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode half = dummy;
    	while(head != null && head.next != null) {
    		head = head.next.next;
    		half = half.next;
    	}
        ListNode secondHalf = null;
    	if(half != null && half.next != null) {
    		secondHalf = half.next;
    		half.next = null;
    	}
    	results.add(dummy.next);
        if(secondHalf != null) {
            results.add(secondHalf);
        }   
        return results;
    }
	    
    public static void main(String[] args){
    	LinkedListOperations ins = new LinkedListOperations();
    	ListNode head = ins.new ListNode(3);
    	head.next = ins.new ListNode(5);
    	head.next.next = ins.new ListNode(7);
    	ListNode test = ins.reverseLinkedList(head);
    	ArrayList<ListNode> res = ins.reverseAndSplit(head);
    	System.console();
    }
}