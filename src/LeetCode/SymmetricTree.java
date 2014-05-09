package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

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
	// recursive 1
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
    //recursive 2
    private boolean checkSymmetric(TreeNode l, TreeNode r){
    	if(l == null && r == null){
    		return true;
    	}
    	else if(l == null || r == null){
    		return false;
    	}
    	else if(l.val != r.val) {
    		return false;
    	}
    	return (checkSymmetric(l.left, r.right)&&checkSymmetric(l.right, r.left));
    }
    
    // iterative
    public boolean isSymmetricIterative(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
         if(root == null){
         	return true;
         }
         Queue<TreeNode> s1 = new LinkedList<TreeNode>(),
        		 		 s2 = new LinkedList<TreeNode>();
         
         s1.add(root.left);
         s2.add(root.right);
         while(!s1.isEmpty() && !s2.isEmpty()){
         	TreeNode n1 = (TreeNode) s1.poll();
         	TreeNode n2 = (TreeNode) s2.poll();
         	// for this comparison, they meet the requirement, continue comparing
         	if(n1==null&&n2==null){
         	    continue;
         	}
         	if(n1!=null&&n2==null || n1==null&&n2!=null){
         		return false;
         	}      
         	if(n1.val!=n2.val){
         		return false;
         	}
         	
         	s1.add(n1.left);
         	s1.add(n1.right);
         	s2.add(n2.right);
         	s2.add(n2.left);
        }
         // both queues are empty, return true
        return true;
    }

}
