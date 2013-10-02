package LeetCode;

public class PathSum {

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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
            return false;
        }
        if (sum == root.val && root.left == null && root.right == null) {
            return true;
        }
        return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }
}
