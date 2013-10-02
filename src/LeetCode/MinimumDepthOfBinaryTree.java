package LeetCode;

public class MinimumDepthOfBinaryTree {

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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
            return 0;
        }
        int leftD = minDepth(root.left);
        int rightD = minDepth(root.right);
        if ( leftD == 0 || rightD == 0) {
            return Math.max(leftD, rightD)+1;
        }
        return Math.min(leftD, rightD)+1;
        
    }

}
