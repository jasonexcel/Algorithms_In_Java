package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
            return 0;
        }
        int leftD = minDepth(root.left);
        int rightD = minDepth(root.right);
        if ( leftD == 0 || rightD == 0) {
            return Math.max(leftD, rightD)+1;
        }
        return Math.min(leftD, rightD)+1;
        
    }
    
    public int minDepthByBFS(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root == null){
        	return 0;
        }
        int minHeight = 1;
        int curL = 1, nextL = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
        	TreeNode n = q.remove();
        	curL--;
        	if(n.left==null&&n.right==null){
        		return minHeight;
        	}
        	if(n.left!=null){
        		q.add(n.left);
        		nextL++;
        	}
        	if(n.right!=null){
        		q.add(n.right);
        		nextL++;
        	}
        	if(curL==0){
        		curL = nextL;
        		nextL = 0;
        		minHeight++;
        	}
        }
        return minHeight;
    }

}
