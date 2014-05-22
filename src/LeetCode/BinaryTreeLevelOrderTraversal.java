/*
 * Given a binary tree, return the level order traversal of its nodes' values.
 *  (ie, from left to right, level by level).*/

package LeetCode;
import java.util.*;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	if(root==null){
    	    return results;
    	}
    	ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        // l1 - length of nodes in current level; l2 - length of nodes in next level
        int l1 = 1, l2 = 0;
        while(!q.isEmpty()){
        	TreeNode node = q.poll();
        	result.add(node.val);
        	l1--;
        	if(node.left != null){
        		q.add(node.left);
        		l2++;
        	}
        	if(node.right != null){
        	 	q.add(node.right);
        	 	l2++;
        	}
        	if(l1 == 0){
        		l1 = l2;
        		l2 = 0;
        		results.add(new ArrayList<Integer>(result));
        		result = new ArrayList<Integer>();
        	}
        }
        return results;
    }
}