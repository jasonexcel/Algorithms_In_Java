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
		ConvertSortedListtoBinarySearchTree ins = new ConvertSortedListtoBinarySearchTree();
		ListNode head = ins.new ListNode(1);
		head.next = ins.new ListNode(3);
		ins.sortedListToBST(head);
	}
	
	//method one
	public TreeNode sortedListToBST(ListNode head) {
	    if(head == null){
	        return null;
	    }

	    ListNode cur = head;
	    int count = 0;
	    while(cur!=null)
	    {
	        cur = cur.next;
	        count++;
	    }
	    //ArrayList<ListNode> list = new ArrayList<ListNode>();
	    //list.add(head);
	    ListNode[] list = {head};
	    
	    return bstHelper(list,0,count-1);
	}
	//my solution
	private TreeNode bstHelper(ListNode[] list, int l, int r){
		if(l>r){
			return null;
		}
		else{
			if(l==r){
				TreeNode root = new TreeNode(list[0].val);
				//important, list contains the next node to be added
				list[0] = list[0].next;
				return root;
			}
			else{
				int mid = l+(r-l)/2;
				//construct the leftmost node 
				TreeNode left = bstHelper(list, l, mid-1);
				//list contains current root value
				TreeNode root = new TreeNode(list[0].val);
				root.left = left;
				list[0] = list[0].next;
				root.right = bstHelper(list, mid+1, r);
				return root;
			}
		}
	}
	//this is the method to construct a BST tree recursively by in-order traversal
	//http://blog.csdn.net/linhuanmars/article/details/23904937
	private TreeNode helper(ArrayList<ListNode> list, int l, int r)
	{
	    if(l>r){
	    	return null;
	    }
	    //index m is for current parent node    
	    int m = (l+r)/2;
	    //construct left tree
	    TreeNode left = helper(list,l,m-1);
	    //get parent node value from the first number in the array list
	    TreeNode root = new TreeNode(list.get(0).val);
	    root.left = left;
	    list.set(0,list.get(0).next);
	    root.right = helper(list,m+1,r);
	    return root;
	}
	
	//method two
	
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
