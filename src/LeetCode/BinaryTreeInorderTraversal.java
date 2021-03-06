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

Morris traversal： http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 */
package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
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
		//root is needed here, not like pre-order traversal
		while(!parentStack.empty() || root!=null){
			if(root!=null){
				//push root into stack first, and then left child
				parentStack.push(root);
				root = root.left;
			}
			//root is null, but not stack
			else {
				//root is null, get new root
				root = parentStack.pop();
				res.add(root.val); //visit root
				root = root.right; //reset root to the right child
			}		
		}
		return res;
    }
}
