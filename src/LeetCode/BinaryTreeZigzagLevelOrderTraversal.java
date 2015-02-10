/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Shaun
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Recursive， two stacks for odd and even tree level
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if(root==null){
    		return results; 
        }
    	Stack<TreeNode> oddLevel = new Stack<TreeNode>();
    	Stack<TreeNode> evenLevel = new Stack<TreeNode>();
    	evenLevel.push(root);
    	int level = 0;
    	composeZigZagLevels(oddLevel, evenLevel, level, results);
    	return results;
    }
    
    private void composeZigZagLevels(Stack<TreeNode> oddLevel, Stack<TreeNode> evenLevel, int level,
    		List<List<Integer>> results){
    	if(oddLevel.empty() && evenLevel.empty()){
    		return;
    	}
    	else{
			List<Integer> res = new ArrayList<Integer>();
    		if(level%2==0){
    			while(!evenLevel.empty()){
    				TreeNode temp = evenLevel.pop();
    				res.add(temp.val);
    				if(temp.left!=null){
    				    oddLevel.push(temp.left);
    				}
                    if(temp.right!=null){
                        oddLevel.push(temp.right);
                    }    				
    			}
    		}
    		else{
    			while(!oddLevel.empty()){
    				TreeNode temp = oddLevel.pop();
    				res.add(temp.val);
    				if(temp.right!=null){
    				    evenLevel.push(temp.right);
    				}
    				if(temp.left!=null){
    				    evenLevel.push(temp.left);
    				}    				    			
    			}
    		}
			level++;
			results.add(res);
			composeZigZagLevels(oddLevel, evenLevel, level, results);
			return;
    	}    	
    }
    
    //Iterative method, o(n) time and space complexity
    public List<List<Integer>> zigzagLevelOrderIterative(TreeNode root) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if(root==null){
    		return results; 
        }
    	Stack<TreeNode> oddLevel = new Stack<TreeNode>();
    	Stack<TreeNode> evenLevel = new Stack<TreeNode>();
    	evenLevel.push(root);
    	int level = 0;
    	while(!oddLevel.empty() || !evenLevel.empty()){
    		List<Integer> res = new ArrayList<Integer>();
    		if(level%2 == 0){
    			while(!evenLevel.empty()){
        			TreeNode temp = evenLevel.pop();
        			res.add(temp.val);
        			if(temp.left!=null){
        				oddLevel.push(temp.left);
        			}
        			if(temp.right!=null){
        				oddLevel.push(temp.right);    				
        			}
    			}
    		}
    		else{
    			while(!oddLevel.empty()){
        			TreeNode temp = oddLevel.pop();
        			res.add(temp.val);
        			if(temp.right!=null){
        				evenLevel.push(temp.right);
        			}
        			if(temp.left!=null){
        				evenLevel.push(temp.left);
        			}
    			}
    		}
    		level++;
    		results.add(res);
    	}
    	return results;
    }
}
