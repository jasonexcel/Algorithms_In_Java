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
