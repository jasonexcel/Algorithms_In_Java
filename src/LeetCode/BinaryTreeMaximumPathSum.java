/**
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
package LeetCode;

/**
 * @author Shaun
 *
 */
public class BinaryTreeMaximumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxPathSum(TreeNode root) {
        if(root==null){
        	return 0; 
        }
        int[] maxSum = {Integer.MIN_VALUE};
        maxBranchSum(root, maxSum);
        return maxSum[0];
    }
    
    /*
     * parameter: current node, current max path sum 
     * return: max branch sum - the maximum sum from root to one of its descendants
     */
    private int maxBranchSum(TreeNode root, int[] maxSum){
    	if(root==null){
    		return 0;
    	}
    	//the left node must be included in the leftBranchSum
    	// the sum is the max of left node to any its descendant 
    	int leftBranchSum = maxBranchSum(root.left, maxSum);
    	int rightBranchSum = maxBranchSum(root.right, maxSum);
    	int curPathSum = root.val;
    	if(leftBranchSum>0){
    		curPathSum+=leftBranchSum;
    	}
    	if(rightBranchSum>0){
    		curPathSum+=rightBranchSum;
    	}
    	if(curPathSum>maxSum[0]){
    		maxSum[0] = curPathSum;
    	}
    	//return the maxBranchSum: from root to any its descendant
    	int res = leftBranchSum>0 ? leftBranchSum : 0;
    	res = res>rightBranchSum ? res : rightBranchSum;
    	return res+root.val;
    }
}
