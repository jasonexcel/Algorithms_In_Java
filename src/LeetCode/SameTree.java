package LeetCode;

public class SameTree {

	/**
	 * Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
	 */
	
	/**
	 * Definition for binary tree*/
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p == null && q == null) {
            return true;
        }
        else if(p  == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean left = isSameTree(p.left, q.left);
        if (!left) {
            return false;
        }
        boolean right = isSameTree(p.right, q.right);
        return right;
    }
    
    public boolean isSameTreeII(TreeNode p, TreeNode q) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(p == null & q==null){
        	return true;
        }
        else if(p==null || q==null){
            return false;
        }
        if(p.val == q.val){
        	if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
        		return true;
        	}        	
        }
        return false;
    }

}
