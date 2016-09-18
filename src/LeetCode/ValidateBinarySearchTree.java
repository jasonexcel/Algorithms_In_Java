/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
package LeetCode;
import java.util.ArrayList;
public class ValidateBinarySearchTree {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	//preferred method
	//better but hard, o(n) time complexity, o(logn) space complexity
    public boolean isValidBST_2(TreeNode root) {
        ArrayList<Integer> pre = new ArrayList<Integer>();
        //the first element in 'pre' represent the previous number in the array sorted by in-order traversal
        pre.add(null);
        return helper(root, pre);
    }
    // in-order
    private boolean helper(TreeNode root, ArrayList<Integer> pre)
    {
        if(root == null)
            return true;
        //left part
        boolean left = helper(root.left,pre);
        if(!left){
        	return false;
        }
        //verify by comparing root value with the previous number
        if(pre.get(0)!=null && root.val<=pre.get(0)){
            return false;
        }
        //set current root value as the previous number
        pre.set(0,root.val);
        //right part
        return helper(root.right,pre);
    }
	
	//O(n) time complexity, O(n) space complexity
	 public static boolean isValidBST(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<Integer> arrays = new ArrayList<Integer>();
	        treeTraversal(root, arrays);
	        Integer[] arr = arrays.toArray(new Integer[0]);
	        for(int i=0; i<arr.length-1; i++) {
	            if(arr[i] >= arr[i+1]) return false;
	        }
	        return true;
	    }
	    
	    private static void treeTraversal(TreeNode t, ArrayList<Integer> arr){
	        if(t == null) {
	            return;
	        }
	        treeTraversal(t.left, arr);
	        arr.add(t.val);
	        treeTraversal(t.right, arr);
	        return;
	    }
	    	    
	    
	    //same as the 2nd method, only change the object 'pre' type 
	    public boolean isValidBST_3(TreeNode root) {
	    	//cast Integer.MIN_VALUE to long int first
	        long[] pre = {(long)Integer.MIN_VALUE-1};
	        return helper(root, pre);
	    }
	    private boolean helper(TreeNode root, long[] pre)
	    {
	        if(root == null)
	            return true;
	        //left part
	        boolean left = helper(root.left,pre);
	        if(!left){
	        	return false;
	        }
	        //verify by comparing root value with the previous number
	        if(root.val<=pre[0]){
	            return false;
	        }
	        //set current root value as the previous number
	        pre[0] = root.val;
	        //right part
	        return helper(root.right,pre);
	    }

	    // my solution
	    // pre-order: validate root; then go left, then go right
	    public boolean isValidBSTIII(TreeNode root) {
	        return isValidBSTHelper(root, (long)Integer.MAX_VALUE+1, (long)Integer.MIN_VALUE-1);
	    }
	    private boolean isValidBSTHelper(TreeNode root, long upperRange, long lowerRange) {
	        if(root == null) {
	            return true;
	        }
	        if(root.val>=upperRange || root.val <= lowerRange) {
	            return false;
	        }
	        return isValidBSTHelper(root.left, root.val, lowerRange) && isValidBSTHelper(root.right, upperRange, root.val);
	    }
	    
	    private boolean isValidBSTHelperII(TreeNode root, long leftMax, long rightMin) {
	        if(root == null) {
	            return true;
	        }
	        if(root.left != null) {
	            if(root.left.val >= root.val || root.left.val <= rightMin) {
	                return false;
	            }
	        }
	        if(root.right != null) {
	            if(root.right.val <= root.val || root.right.val >= leftMax) {
	                return false;
	            }
	        }
	        return isValidBSTHelper(root.left, root.val, rightMin) && isValidBSTHelper(root.right, leftMax, root.val);
	    }
	    
}
