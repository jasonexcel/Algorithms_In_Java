/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Shaun
 *
 */
public class BinaryTreePreorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> preorderTraversalInterative(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			list.add(tmp.val);
			if (tmp.right != null) {
				stack.push(tmp.right);
			}
			if (tmp.left != null) {
				stack.push(tmp.left);
			}
		}
		return list;
	}
	// time complexity: o(n), space complexity: o(logn)
//	public List<Integer> preorderTraversalIterative(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        //must check root before add root into stack
//        if(root == null){
//        	return res;
//        }
//        Stack<TreeNode> s = new Stack<TreeNode>();
//        s.add(root);
//        while(!s.empty()){
//        	TreeNode cur = s.pop();
//        	//visit current node
//        	res.add(cur.val);
//        	//push right child into stack
//        	if(cur.right != null){
//        		s.push(cur.right);
//        	}
//        	//push left
//        	if(cur.left != null){
//        		s.push(cur.left);
//        	}
//        }
//        return res;
//    }
	public List<Integer> preorderTraversalIterativeGeneral(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(root!=null || !s.empty()){
			if(root!=null){
				res.add(root.val);//root visit at first
				s.push(root);				
				root = root.left;
			}
			else{
				root = s.pop();
				root = root.right;
			}
		}
		return res;
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorderTraversalRecursion(root, res);
        return res;
    }
    private void preorderTraversalRecursion(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        preorderTraversalRecursion(root.left, res);
        preorderTraversalRecursion(root.right, res);
    }       
}
