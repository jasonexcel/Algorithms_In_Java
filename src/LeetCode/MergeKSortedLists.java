/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * Warning: I think the sort is from lower to higher value
 */
package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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

public class MergeKSortedLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		    val = x;
		    next = null;
		}
	}
	
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0){
            return null;
        }
    	int size = lists.size();
    	if(size>1){
    		List<ListNode> left = lists.subList(0, size/2);
    		List<ListNode> right = lists.subList(size/2, size);
    		ListNode listA = mergeKLists(left);
    		ListNode listB = mergeKLists(right);
    		return mergeTwoLists(listA, listB);
    	}
    	else{
    		return lists.get(0);
    	}
    }

    //my initial solution  
    //time complexity:O(n*k*logk)
    private ListNode mergeTwoLists(ListNode listA, ListNode listB){
    	ListNode res = new ListNode(0);
        ListNode dummy = res;

    	while(listA != null && listB != null){
    		//lower value first
    		if(listA.val <= listB.val){
    			//use res.next not res here!
    		    res.next = new ListNode(listA.val); 
    			res = res.next;
    			listA = listA.next;	
    		}
    		else{
    			res.next = new ListNode(listB.val);
    			res = res.next;
    			listB = listB.next;
    		}
    	}
    	if(listA != null){
    		res.next = listA;
    	}
    	if(listB != null){
    		res.next = listB;
    	}
    	return dummy.next;
    }
    
    //http://blog.csdn.net/linhuanmars/article/details/19899259
    //time complexity: O(n*k*logk), space complexity: O(k)
    public ListNode mergeKListsHeap(ArrayList<ListNode> lists) {
    	Comparator<ListNode> comp = new Comparator<ListNode>() {
    		@Override
    		public int compare(ListNode n1, ListNode n2) {
    			return n1.val - n2.val;
    		}    		
    	};
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10, comp);
        
        // build a heap with n heads of linked list
        for(int i=0;i<lists.size();i++)
        {
            ListNode node = lists.get(i); 
            if(node!=null)
            {
                heap.offer(node);
            }
        }
        ListNode head = null;
        ListNode pre = head;
        //k*n loops
        while(heap.size()>0)
        {
        	//always 
            ListNode cur = heap.poll();
            if(head == null)
            {
                head = cur;
                pre = head;
            }
            else
            {
                pre.next = cur;
            }
            pre = cur;
            if(cur.next!=null) {
            	heap.offer(cur.next);//logk time complexity
            }
                
        }
        return head;
    }
}