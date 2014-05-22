package LeetCode;
import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static void main(String[] args){
		int[] preorder = {1, 2};
		int[] inorder = {2, 1};
		new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	    for(int i = 0; i<inorder.length; i++){
	    	hm.put(inorder[i], i);
	    }

	    return buildTreeHelp(hm, preorder, 0, inorder.length-1, 0, preorder.length-1);
	}

	private TreeNode buildTreeHelp(HashMap<Integer, Integer> hm, int[] preorder, int ios, int ioe, int pos, int poe){
		if(ios>ioe || pos>poe){
			return null;
		}
		int rootVal = preorder[pos];
		TreeNode node = new TreeNode(rootVal);
		int index = hm.get(rootVal);
		if(index>ios){
			node.left = buildTreeHelp(hm, preorder, ios, index-1, pos+1, pos+index-ios);
		}
		if(index<ioe){
			node.right = buildTreeHelp(hm, preorder, index+1, ioe, poe-ioe+index+1, poe);
		}
		return node;    	
	}
}
