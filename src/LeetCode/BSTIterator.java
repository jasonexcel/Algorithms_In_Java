/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BSTIterator{
        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushAll(root);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode tmp = stack.pop();
            pushAll(tmp.right);
            return tmp.val;
        }

        private void pushAll(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }

//
//    int curIndex;
//    List<TreeNode> list; //!!!
//
//    public BSTIterator(TreeNode root) {
//        list = new ArrayList<TreeNode>();
//        dfs(root, list);
//        curIndex = 0; //!!!
//    }
//
//    private void dfs(TreeNode root, List<TreeNode> res) {
//        if(root == null) {
//            return;
//        }
//        dfs(root.left, res);
//        res.add(root);
//        dfs(root.right, res);
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        if(curIndex < list.size()){
//            return true;
//        }
//        return false;
//    }
//
//    /** @return the next smallest number */
//    public Object next() {
//        if(curIndex < list.size()) {
//        	// increment by one
//            return list.get(curIndex++).val;
//        }
//        return Integer.MAX_VALUE;
//    }
//
//	@Override
//	public void remove() {
//		// TODO Auto-generated method stub
//
//	}


//Iterative method
 class BSTIteratorII {
    int curIndex;
    List<TreeNode> list;
    
    public BSTIteratorII(TreeNode root) {
        //list = new ArrayList<CharTreeNode>();
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
                tStack.push(cur); // push
                cur = cur.left; // go left
            }
            else {
                TreeNode temp = tStack.pop(); // pop to get parent
                res.add(temp); // visit parent
                cur = temp.right; // go to right 
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
