package LeetCode;

import LeetCode.SameTree.TreeNode;

public class SymmetricTree {

	/**
	 * @param args
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
	public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return true;
        }
        return areMirrorTrees(root.left, root.right);        
    }
    private boolean areMirrorTrees(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        else if(left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean outside = areMirrorTrees(left.left, right.right);
        if (!outside) {
            return false;
        }
        boolean inside = areMirrorTrees(left.right, right.left);
        return inside;
    }

}
