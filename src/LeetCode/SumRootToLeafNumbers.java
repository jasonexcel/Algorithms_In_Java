/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */
package LeetCode;

/**

 */
public class SumRootToLeafNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int sumNumbers(TreeNode root) {
	    return helper(root,0);
	}
	
	// sum means the result from root to current val
	private int helper(TreeNode root, int sum)
	{
	    if(root == null)
	        return 0;
	    if(root.left==null && root.right==null)
	        return sum*10+root.val;
	    return helper(root.left,sum*10+root.val)+helper(root.right,sum*10+root.val);
	}
	
	//my solution
	// top down
    public int sumNumbersII(TreeNode root) {
        int[] sum = {0};
        if(root != null){
            helperII(root, sum);
        }
        return sum[0];
    }
    private void helperII(TreeNode root, int[] sum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sum[0] = sum[0]*10 + root.val;
            return;
        }
        else{
            int[] temp1 = new int[1];
            int[] temp2 = new int[1];
            if(root.left != null){
                temp1[0] = sum[0]*10 + root.val;
                helperII(root.left, temp1);
            }
            if(root.right != null){
                temp2[0] = sum[0]*10 + root.val;
                helperII(root.right, temp2);
            }
            sum[0] = temp1[0] + temp2[0];
        }
    }
}
