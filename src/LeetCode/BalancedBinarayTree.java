/**
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of 
the two subtrees of every node never differ by more than 1.
 */
package LeetCode;

public class BalancedBinarayTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }	
	//o(n) time, o(logn) space
	public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return true;
        }
        return treeDepth(root) != -1;
        
    }
    
    // return -1 if the tree is not balanced, else return a non-negative number
    private int treeDepth(TreeNode n) {
        if(n == null) {
            return 0;
        }
        int leftD = treeDepth(n.left);
        if (leftD == -1) {
            return -1;
        }
        int rightD = treeDepth(n.right);
        if (rightD == -1) {
            return -1;
        }
        if (Math.abs(leftD - rightD) > 1) {
            return -1;
        }
        return Math.max(leftD, rightD) + 1;
            
    }

}
