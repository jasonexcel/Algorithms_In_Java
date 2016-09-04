package LeetCode;

/**
 * Created by Shaun on 9/3/2016.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(findLCA(root.val, p.val, q.val)) {
            return root;
        }
        if(root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return lowestCommonAncestor(root.left, p, q);
    }

    private boolean findLCA(int rootVal, int pVal, int qVal) {
        if(rootVal >= pVal && rootVal <= qVal || rootVal <= pVal && rootVal >= qVal) {
            return true;
        }
        return false;
    }
}
