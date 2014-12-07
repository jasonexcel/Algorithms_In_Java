/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        //not necessary 
		if(root==null){
        	return res;
        }
		inorderTraversalRecursive(root, res);
		return res;
    }
	private void inorderTraversalRecursive(TreeNode node, List<Integer> res){
		if(node==null){
			return;
		}
		inorderTraversalRecursive(node.left, res);
		res.add(node.val);
		inorderTraversalRecursive(node.right, res);
	}
	public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> parentStack = new Stack<TreeNode>();
		while(!parentStack.empty() || root!=null){
			if(root!=null){
				parentStack.push(root);
				root = root.left;
			}
			//root is null, but not stack
			else {
				root = parentStack.pop();
				res.add(root.val);
				root = root.right;
			}		
		}
		return res;
    }
}
