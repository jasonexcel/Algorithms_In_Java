/**
 * 
 */
package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shaun
 *
 */
public class BinaryTreePostOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> postorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
//	    if(root == null){
//	        return res;
//	    }
	    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	    TreeNode pre = null;//!!!
	    while(root != null || !stack.isEmpty()){
	        if(root!=null){
	            stack.push(root);
	            root = root.left;
	        }
	        else{
	            TreeNode peekNode = stack.peek(); //!!! difference
	            // right child is not null and not visited
	            if(peekNode.right!=null && pre != peekNode.right){
	            	//go to right child 
	                root = peekNode.right;
	            }
	            else{
	            	//visit current node
	                stack.pop();
	                res.add(peekNode.val);
	                pre = peekNode;//reset pre node
	            }
	        }
	    }
	    return res;
	}
}
