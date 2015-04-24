/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator {
	int curIndex;
    List<TreeNode> list;
    
    public BSTIterator(TreeNode root) {
        list = new ArrayList<TreeNode>();
        dfs(root, list);
        curIndex = 0;
    }
    
    private void dfs(TreeNode root, List<TreeNode> res) {
        if(root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root);
        dfs(root.right, res);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(curIndex < list.size()){
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        if(curIndex < list.size()) {
        	// increment by one
            return list.get(curIndex++).val;
        }
        return Integer.MAX_VALUE;
    }
}

//Iterative method
 class BSTIteratorII {
    int curIndex;
    List<TreeNode> list;
    
    public BSTIteratorII(TreeNode root) {
        //list = new ArrayList<TreeNode>();
        list = convertToList(root);
        curIndex = 0;
    }
    
    private List<TreeNode> convertToList(TreeNode root) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> tStack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!tStack.isEmpty() || cur != null) {
            if(cur != null) {
                tStack.push(cur);
                cur = cur.left;
            }
            else {
                TreeNode temp = tStack.pop();
                res.add(temp);
                cur = temp.right;
            }
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(curIndex < list.size()){
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        if(curIndex < list.size()) {
            return list.get(curIndex++).val;
        }
        return Integer.MAX_VALUE;
    }
}
