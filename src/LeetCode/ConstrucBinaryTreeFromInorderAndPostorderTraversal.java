package LeetCode;

import java.util.*;

////Definition for binary tree
//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}
// see ConstructBinaryTreeFromPreorderAndInorderTraversal for clean code

public class ConstrucBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
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