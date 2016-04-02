/**
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
package LeetCode;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersinEachNode {
	public class TreeLinkNode {                     
	    int val;                                    
	    TreeLinkNode left, right, next;             
	    TreeLinkNode(int x) { val = x; }            
	}                                               
	
	//DFS works, but violates the constant space rule
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.next != null && root.next.left != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
    // my dfs
    public void connectII(TreeLinkNode root) {
        if(root == null || root.left == null) {
            return;
        }
        root.left.next = root.right;
        if(root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
    // preferred
    public void connectBest(TreeLinkNode root) {
        if(root == null || root.left == null) {
            return;
        }
        TreeLinkNode curNode = root;
        TreeLinkNode leftMost = root;
        while(curNode != null) {
            while(curNode != null) {
                if(curNode.left != null) {
                    curNode.left.next = curNode.right;
                }
                if(curNode.right != null) {
                    curNode.right.next = curNode.next == null ? null : curNode.next.left;
                }
                curNode = curNode.next;
            }
            
            leftMost = leftMost.left;
            curNode = leftMost;
        }
    }
    
    //constant space by level iteration
    public void connectConstantSpace(TreeLinkNode root) {
    	if(root == null){
    		return;
    	}    	
    	TreeLinkNode curHead = root; // track the head
    	TreeLinkNode curLevel = root; // track the first item in that level
    	while(curHead!=null){
    		while(true){
    			if(curHead.left!=null){
        			curHead.left.next = curHead.right;
        		}
        		if(curHead.next != null && curHead.next.left != null){
        			curHead.right.next = curHead.next.left;
            		curHead = curHead.next;
            		continue;
        		}
        		// break when this level end (curHead.next is null)
        		break;
    		}
			//next level
			curHead = curLevel.left;
			curLevel = curHead;
    	}
    }
    
    
}