/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
package LeetCode;

import java.util.ArrayList;

import LeetCode.PathSum.TreeNode;
public class PathSumII {

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
	//o(n) time, o(k*logn) space
	    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if (root != null) {
				ArrayList<Integer> path = new ArrayList<Integer>();
				findPathSum(root, sum, result, path);
			}
			return result;
		}

		public void findPathSum(TreeNode root, int sum,
				ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
			if (root == null)
				return;
			path.add(root.val);
			if (root.left == null && root.right == null && root.val == sum) {
				//!!! make a new copy, otherwise, add same path to the result
				ArrayList<Integer> clone = new ArrayList<Integer>(path);
				result.add(clone);
			} else {
				if (root.left != null) {
					findPathSum(root.left, sum - root.val, result, path);
				}
				if (root.right != null) {
					findPathSum(root.right, sum - root.val, result, path);
				}
				//!!! remove the element at the index
	            path.remove(path.size() - 1);
			}
		}

}
