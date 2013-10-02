package LeetCode;

public class ConvertSortedArraytoBinarySearchTree {

	/**
	 * @param args
	 */
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int v){
			val = v;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length == 0) return null;
        return bstHelper(num, 0, num.length-1);
        
        
    }
    private TreeNode bstHelper(int[] arr, int start, int end){
        if(start<=end){
            int mid = start + (end-start)/2;
            TreeNode t = new TreeNode(arr[mid]);
            t.left = bstHelper(arr, start, mid -1);
            t.right = bstHelper(arr, mid+1, end);
            return t;
            
        }
        return null;
    }
}
