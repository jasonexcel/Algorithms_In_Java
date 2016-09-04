/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
package LeetCode;

import java.util.*;

////Definition for binary tree
//class CharTreeNode {
//	int val;
//	CharTreeNode left;
//	CharTreeNode right;
//
//	CharTreeNode(int x) {
//		val = x;
//	}
//}
// see ConstructBinaryTreeFromPreorderAndInorderTraversal for clean code

public class ConstrucBinaryTreeFromInorderAndPostorderTraversal {
	//better
	public TreeNode buildTree(int[] inorder, int[] postorder) {
	    if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0)
	    {
	        return null;
	    }
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int i=0;i<inorder.length;i++)
	    {
	        map.put(inorder[i],i);
	    }
	    return helper(inorder,postorder,0,inorder.length-1, 0, postorder.length-1,map);
	}
	private TreeNode helper(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR, HashMap<Integer, Integer> map)
	{
	    if(inL>inR || postL>postR)
	        return null;
	    TreeNode root = new TreeNode(postorder[postR]);
	    int index = map.get(root.val);
	    root.left = helper(inorder,postorder,inL,index-1,postL,postL+index-inL-1,map);
	    root.right = helper(inorder,postorder,index+1,inR,postR-(inR-index),postR-1,map);
	    return root;
	}
	
	public TreeNode buildTreeII(int[] inorder, int[] postorder) {
		TreeNode node = new TreeNode(0);
		if (inorder.length < 1 || postorder.length < 1) {
			return null;
		}
		int ios = 0, pos = 0; // inOrderStart, postOrderStart
		int ioe = inorder.length - 1, poe = inorder.length - 1; // inOrderEnd,
																// postOrderEnd
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			hm.put(inorder[i], i);
		}
		buildTreeHelper(node, hm, postorder, ios, ioe, pos, poe);
		return node;
	}

	private void buildTreeHelper(TreeNode node, HashMap<Integer, Integer> hm,
			int[] postorder, int ios, int ioe, int pos, int poe) {
		if (ios > ioe || pos > poe) {
			return;
		}
		node.val = postorder[poe];
		int index = hm.get(node.val);
		if (index > ios) {
			node.left = new TreeNode(0);
			// poe is equal to pos+(index-1-ios) here !!!
			buildTreeHelper(node.left, hm, postorder, ios, index - 1, pos, pos
					+ (index - 1 - ios));

		}
		if (index < ioe) {
			node.right = new TreeNode(0);
			// pos is pos+index-ios here
			buildTreeHelper(node.right, hm, postorder, index + 1, ioe, pos
					+ index - ios, poe - 1);
		}
		return;
	}
}