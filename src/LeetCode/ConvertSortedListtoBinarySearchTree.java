package LeetCode;

import java.util.Arrays;

public class ConvertSortedListtoBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Definition for singly-linked list.
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; next = null; }
	}
	
	
	//Definition for binary tree
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public class Element{
	    
        ListNode n;
        TreeNode t;
        
        public Element(ListNode n, TreeNode t){
            this.n=n;
            this.t=t;
        }
    }    
    
    
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode temp = head;
        int length = 0;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        return (sortedListToBST(head,0,length-1)).t;
    }
    
    
    public Element sortedListToBST(ListNode head, int start, int end){
        if(start>end) return new Element(head,null);
        
        int mid=(start+end)/2;
        Element leftChild = sortedListToBST(head, start,mid-1); 
        
        head = leftChild.n;
        TreeNode parent = new TreeNode(head.val);       
        parent.left=leftChild.t;
        head = head.next;
        Element rightChild = sortedListToBST(head, mid+1,end);
        parent.right = rightChild.t;
        return new Element(rightChild.n,parent);
    }

}
