package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }	
	public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) 
        return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return leftDepth>rightDepth ? leftDepth+1 : rightDepth+1;
    }    
	
	public int maxDepthByBFS(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root == null){
        	return 0;
        }
        int height = 0;
        // l1 - length of nodes in current level; l2 - length of nodes in next level
        int l1 = 1, l2 = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
        	TreeNode temp = q.remove();
        	l1--;
        	if(temp.left!=null){
        		q.add(temp.left);
        		l2++;
        	}
        	if(temp.right!=null){
        		q.add(temp.right);
        		l2++;
        	}
        	if(l1 == 0){
        		l1 = l2;
        		l2 = 0;
        		height++;
        	}
        }
        return height;
    }

}
