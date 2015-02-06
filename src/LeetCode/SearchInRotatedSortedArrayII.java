/**
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 */
package LeetCode;

/**
 * @author Shaun
 *
 */
public class SearchInRotatedSortedArrayII {

	/**
	 * O(n) time, O(1) space
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean search(int[] A, int target) {
        if(A == null || A.length == 0){
             return false;
        }
        int len = A.length;
        int left = 0, right = len-1;
        while(left<=right){
            int mid = left + (right - left)/2;
            int mVal = A[mid];
            if(target == mVal){
                return true;
            }
            else if(A[left] < A[mid]){
                if(A[left] == target){
                	return true;
                }
                else if(A[left] < target && target < mVal){
                	right = mid - 1;
                }
                else{
                	left = mid + 1;
                }
            }
            else if(A[left] > A[mid]){
            	//mid to right is in order
            	if(A[right] == target){
            		return true;
            	}
            	else if(A[mid] < target && target < A[right]){
            		left = mid + 1;
            	}
            	else{
            		right = mid - 1;
            	}
            }
            else{
            	left++;
            }
        }
        return false;
    }
}
