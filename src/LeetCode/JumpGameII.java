/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *Each element in the array represents your maximum jump length at that position.
 *Your goal is to reach the last index in the minimum number of jumps.
 *For example:
 *Given array A = [2,3,1,1,4]
 *The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 *solution: update needed steps and max cover, continually find the next max coverage
 */
package LeetCode;

public class JumpGameII {
	public int jump(int[] A) {
    	assert (A != null && A.length > 0);
    	
    	int jumpedStep = 0;
    	int maxCover = 0;
    	int nextMaxCover = 0;
    	
    	for(int i=0; i<A.length && i<=nextMaxCover; i++){
    		//increment step to current max cover
    		if(i>maxCover){
    			jumpedStep++;
    			maxCover = nextMaxCover;
    		}
    		nextMaxCover = Math.max(nextMaxCover, A[i]+i);
    	}
    	if(nextMaxCover<A.length-1){
    		return 0;
    	}
    	return jumpedStep;
    }
}
