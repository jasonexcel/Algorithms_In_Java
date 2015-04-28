/**
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
package LeetCode;

public class RotateArray {

	public RotateArray() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// simplest solution, O(n) time and space
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k<=0) {
            return;
        }
        int len = nums.length;
        int[] temp = new int[len];
        for(int i=0; i<len-k; i++) {
            temp[i+k] = nums[i];
        }
        for(int i=len-k; i<len; i++) {
            temp[i-len+k] = nums[i];
        }
        for(int i=0; i<len; i++) {
            nums[i] = temp[i];
        }        
    }
    
    // preferred solution
    // 1,2,3,4,5,6  k = 2
    // expect: 5, 6, 1, 2, 3, 4
    public void rotateInPlace(int[] nums, int k) {
    	if(nums == null || nums.length == 0) {
    		return;
    	}
    	k = k % nums.length;
    	if(k <= 0) {
    		return;
    	}
    	// convert to 6, 5, 4, 3, 2, 1
    	reversePartialArray(nums, 0, nums.length-1);
    	// convert to 5, 6, 4, 3, 2, 1
    	reversePartialArray(nums, 0, k-1);
    	// convert to 5, 6, 1, 2, 3, 4 
    	// !!! starting from k, not k -1
    	reversePartialArray(nums, k, nums.length-1);
    	return;
    }
    private void reversePartialArray(int[] nums, int start, int end) {
    	if(start < 0 || end > nums.length - 1) {
    		return;
    	}
    	while(start < end) {
    		int temp = nums[start];
    		nums[start] = nums[end]; 
    		nums[end] = temp;
    		start++;
    		end--;
    	}
    	return;
    }
}
