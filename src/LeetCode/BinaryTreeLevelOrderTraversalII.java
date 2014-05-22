package LeetCode;

import java.util.*;

/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 *  (ie, from left to right, level by level from leaf to root).*/

public class BinaryTreeLevelOrderTraversalII {
	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return results;
		}
		Stack<ArrayList<Integer>> s = new Stack<ArrayList<Integer>>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int l1 = 1, l2 = 0;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			result.add(node.val);
			l1--;
			if (node.left != null) {
				q.add(node.left);
				l2++;
			}
			if (node.right != null) {
				q.add(node.right);
				l2++;
			}
			if (l1 == 0) {
				l1 = l2;
				l2 = 0;
				s.push(result);
				result = new ArrayList<Integer>();
			}
		}
		while (!s.empty()) {
			results.add(s.pop());
		}
		return results;
	}
}