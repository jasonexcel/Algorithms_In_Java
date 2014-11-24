/**
 * 
 */
package LeetCode;

import LeetCode.PopulatingNextRightPointersinEachNode.TreeLinkNode;

/**
 * @author Shaun
 *
 */
public class PopulatingNextRightPointersinEachNodeII {
	//DFS visit sequence here: p -> right -> left
	public void connect(TreeLinkNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root == null) {
            return;
        }

        TreeLinkNode p = root.next;
        //find the next node for current node's children
        while (p != null) {
            if (p.left != null) {
                p = p.left;
                break;
            }
            if (p.right != null) {
                p = p.right;
                break;
            }
            p = p.next;
        }
        //handle right node first
        if (root.right != null) {
            root.right.next = p;
        }

        if (root.left != null) {
            root.left.next = root.right == null ? p : root.right;
        }
        // build right first
        connect(root.right);
        connect(root.left);
    }
}
