/**
 * Given a binary tree where all the right nodes are leaves.
 * Write a function to turn the tree upside down.
* for example, turn these:
 *
 *        1                 1
 *       / \                 / \
 *      2   3            2   3
 *     / \
 *    4   5
 *   / \
 *  6   7
 *
 * into these:
 *
 *        1                1
 *       /                /
 *      2---3            2---3
 *     /
 *    4---5
 *   /
 *  6---7
 *
 * where 6 is the new root node for the left tree, and 2 for the right tree.
 * oriented correctly:
 *
 *      6                      2
 *     /  \                   / \
 *    7    4                 3   1
 *        / \
 *       5   2
 *          / \
 *         3   1
 *
 *
 * Spcae: O(1), Time: O(n)
 */

package RealInterviewQuestion;

public class FlipTree {

	public FlipTree() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;
	
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		TreeNode parent = null;
		TreeNode parentRight = null; //right sibling
		return upsideDownBinaryTree(root, parent, parentRight); 
	}
	// visited n/2 + 1 nodes, just left side of the tree, 
	private TreeNode upsideDownBinaryTree(TreeNode cur, TreeNode parent, TreeNode parentRight) {
		if (cur == null) {
			return parent; //find the left leaf node and return it
		}
		TreeNode left = cur.left;
		TreeNode curRight = cur.right;
		cur.left = parentRight; // !!!
		cur.right = parent; /// !!!
		return upsideDownBinaryTree(left, cur, curRight);
	}

}
