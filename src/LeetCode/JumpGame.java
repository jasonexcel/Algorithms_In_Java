/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *Each element in the array represents your maximum jump length at that position.
 *Determine if you are able to reach the last index.
 *For example:
 *A = [2,3,1,1,4], return true.
 *
 *A = [3,2,1,0,4], return false.
 *special edge case: [0, 1]; [1, 0, 1]
 * Refenrence:http://blog.csdn.net/linhuanmars/article/details/21354751
 * 
 */

package LeetCode;

public class JumpGame {
	public boolean canJump(int[] A) {
		assert (A != null && A.length > 0);
		int maxCover = 0;
		// i <= maxCover is critical here, need to terminate the loop if the maxCover 
		// cannot reach current index i
		for(int i = 0; i < A.length-1 && i <= maxCover && maxCover < A.length - 1; i++){
			// get global optimal by comparing local optimal and prev optimal
			maxCover = Math.max(A[i] + i, maxCover);
		}
		if(maxCover < A.length - 1){
			return false;
		}
		return true;
	}
}
