/**
 * Given a linked list and a value x, partition it such that all nodes less than x come 
 * before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
package LeetCode;

public class PartitionList {
	//Definition for singly-linked list.              
	public class ListNode {                         
	    int val;                                    
	    ListNode next;                              
	    ListNode(int x) {                           
	        val = x;                                
	        next = null;                            
	    }                                           
	}       

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionList ins = new PartitionList();
		//!!! learn how to initiate the inner class object here
		ListNode head =  ins.new ListNode(1);
		ins.partition(head, 0);
	}
                                        
	
	public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode ListAKeeper = new ListNode(0);
        ListNode ListARunner = ListAKeeper;
        ListNode ListBKeeper = new ListNode(0);
        ListNode ListBRunner = ListBKeeper;
        while(head != null){
            if(head.val < x){
                ListARunner.next = new ListNode(head.val);
                ListARunner = ListARunner.next;                
            }
            else{
                ListBRunner.next = new ListNode(head.val);
                ListBRunner = ListBRunner.next;
            }
            head = head.next;
        }
        ListARunner.next = ListBKeeper.next;
        return ListAKeeper.next;
    }
}

