package LeetCode;
import java.util.ArrayList;
public class ValidateBinarySearchTree {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	
	 public static boolean isValidBST(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<Integer> arrays = new ArrayList<Integer>();
	        treeTraversal(root, arrays);
	        Integer[] arr = arrays.toArray(new Integer[0]);
	        for(int i=0; i<arr.length-1; i++) {
	            if(arr[i] >= arr[i+1]) return false;
	        }
	        return true;
	    }
	    
	    private static void treeTraversal(TreeNode t, ArrayList<Integer> arr){
	        if(t == null) {
	            return;
	        }
	        treeTraversal(t.left, arr);
	        arr.add(t.val);
	        treeTraversal(t.right, arr);
	        return;
	    }

}
