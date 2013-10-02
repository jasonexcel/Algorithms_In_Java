package LeetCode;

public class MaximumDepthOfBinaryTree {

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
	public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) 
        return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return leftDepth>rightDepth ? leftDepth+1 : rightDepth+1;
    }    

}
