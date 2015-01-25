/**
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
 */
package LeetCode;

import java.util.ArrayList;

/**
 * time complexity O(n), space complexity O(logN) - the space of stack
 *
 */
public class RecoverBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(4);
		RecoverBinarySearchTree ins = new RecoverBinarySearchTree();
		ins.recoverTree(tn);

	}
	
	public void recoverTree(TreeNode root) {
	    if(root == null){
	    	return;
	    }
	        
	    ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
	    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
	    inOrderTraversal(root, pre, res);
	    
	    if(res.size()>0)
	    {
	    	//swap the values of the first and second objects in the res arraylist
	        int temp = res.get(0).val;
	        res.get(0).val = res.get(1).val;
	        res.get(1).val = temp;
	    }
	}
	
	// in-order traversal
	private void inOrderTraversal(TreeNode root, ArrayList<TreeNode> pre, ArrayList<TreeNode> res)
	{
	    if(root == null)
	    {
	        return;
	    }
	    inOrderTraversal(root.left, pre, res);
	    if(pre.size() == 0){	    	
	    	pre.add(root);
	    }
	    else{
	    	if(pre.get(0).val > root.val){
	    		//find conflicts
	    		if(res.size()==0){
	    			//first conflicts
	    			res.add(pre.get(0));
	    			res.add(root);
	    		}
	    		else{
	    			//the tree may have the second conflicts in the in-order traversal
	    			//find the second conflicts, so the root is the second element
	    			res.set(1, root);
	    			//terminate the traversal
	    			return;
	    		}
	    	}
	    	pre.set(0, root); // move 'pre' to next value in the in-order sequence
	    }

	    inOrderTraversal(root.right,pre,res);
	}

}
