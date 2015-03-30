/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right 
child points to the next node of a pre-order traversal.
 */
package LeetCode;

import java.util.Stack;

import LeetCode.SymmetricTree.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* use stack to save sequence, pre-order visit, prepend node to the right of the parent at the end
 * The stack is not in-place method*/

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null){
        	return;
        }
        Stack<TreeNode> preorder = new Stack<TreeNode>();
        preorder.push(root);
        TreeNode cur = null;
        while(!preorder.empty()){
        	TreeNode temp = preorder.pop();
        	if(temp.right != null){
        		preorder.push(temp.right);
        	}
        	if(temp.left != null){
        		preorder.push(temp.left);
        	}
            // do the change at last, otherwise temp.left will be forced to null!
            if(cur != null){
                cur.left = null;
                cur.right = temp;
                cur = cur.right;
            }
            else{
                cur = root;
            }
        }
        return;
    }
    
    /* Good in-place solution*/
    public void flatten2(TreeNode root) {
        if(root == null){
        	return;
        }
        if(root.left != null){
        	//find the right most node of left child
        	TreeNode rightMost = findRightMost(root.left);
        	rightMost.right = root.right;
        	root.right = root.left;
        	root.left = null;        		       	
        }
    	flatten2(root.right);
    }
    
    private TreeNode findRightMost(TreeNode node){
    	TreeNode rightMost = node;
    	while(node != null){
    		if(node.right != null){
    			rightMost = node.right;
    		}    		
    		node = node.right;
    	}
    	return rightMost;
    }
    
}
