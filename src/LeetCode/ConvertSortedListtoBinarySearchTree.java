/**
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 */
package LeetCode;

import java.util.ArrayList;

public class ConvertSortedListtoBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode sortedListToBST(ListNode head) {
	    if(head == null)
	        return null;
	    ListNode cur = head;
	    int count = 0;
	    while(cur!=null)
	    {
	        cur = cur.next;
	        count++;
	    }
	    ArrayList<ListNode> list = new ArrayList<ListNode>();
	    list.add(head);
	    return helper(list,0,count-1);
	}
	private TreeNode helper(ArrayList<ListNode> list, int l, int r)
	{
	    if(l>r)
	        return null;
	    int m = (l+r)/2;
	    TreeNode left = helper(list,l,m-1);
	    TreeNode root = new TreeNode(list.get(0).val);
	    root.left = left;
	    list.set(0,list.get(0).next);
	    root.right = helper(list,m+1,r);
	    return root;
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
    
    
    public TreeNode sortedListToBST_Old(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode temp = head;
        int length = 0;
        //get the size at first
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        return (sortedListToBST(head,0,length-1)).t;
    }
    
    
    public Element sortedListToBST(ListNode head, int start, int end){
        if(start>end) return new Element(head,null);
        
        int mid=start+(end-start)/2;
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
