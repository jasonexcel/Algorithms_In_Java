package basicAlgorithms;


public class ConstructBSTfromPreorderArray {

	/**
	 * @param args
	 */
	 class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;
			TreeNode(int x) { val = x; }
		}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static int index;
	 
	/**
	* Converts a pre-order tree traversal into a binary search tree
	* @param arr - the array containing the traversal
	* @param length - length of the array
	* @return a <code>Node</code> representing the root of the tree
	*/
	public  TreeNode binaryPreorderToTree(int[] arr, int length) {
	    if (length <= 0) {
	        return null;
	    }
	    
	    return binaryPreorderToTree(
	        arr, length, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	 
	/**
	* Converts (recursively) a preorder traversal into a tree,<br/> 
	* using min and max value to validate a node
	* @param arr - array with the pre-order traversal
	* @param length - the length of the array
	* @param min - current minimum value
	* @param max - current maximum value
	* @return - root node
	*/
	private  TreeNode binaryPreorderToTree(
	    int[] arr, int length, int min, int max) {
	        
	    if (index >= length) {
	        return null;
	    }
	    
	    TreeNode root = null;
	    
	    int currentNode = arr[index];
	    
	    if (currentNode > min && currentNode < max) {
	        root = new TreeNode(currentNode);
	        index++;
	        
	        if (index < length) {
	            root.left = 
	                binaryPreorderToTree(arr, length, min, currentNode);
	        }
	        
	        if (index < length) {
	            root.right = 
	                binaryPreorderToTree(arr, length, currentNode, max);
	        }
	    }
	    
	    return root;
	}
}
