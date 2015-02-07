/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */
package LeetCode;

/**
 *  time complexity: o(logn), space compexity: o(1)
 *
 */
public class SearchInRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int search(int[] A, int target) {
        int res = -1;
    	if(A == null || A.length == 0){
    		return res;
    	}
    	int left = 0, right = A.length-1;
    	while(left <= right){
    		int mid = left + (right - left) / 2;
    		if(A[mid] == target){
    			return mid;
    		}
    		// compare mid with right 
    		else if(A[mid] < A[right]){
    			//from mid to right is in order
    			if(A[right] == target){
    				return right;
    			}
    			if(A[mid] < target && target < A[right]){
    				// inside this new range
    				left = mid + 1;    				
    			}
    			else{
    				right = mid - 1;
    			}
    		}
    		else{
    			//left part is in order
    			if(A[left] == target){
    				return left;
    			}
    			else if(A[left] < target && target < A[mid]){    				
    				right = mid - 1;
    			}
    			else{
    				left = mid + 1;
    			}
    		}
    	}
    	return res;
    }
}
