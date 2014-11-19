/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
http://fisherlei.blogspot.com/2012/12/leetcode-maximum-subarray.html
http://blog.csdn.net/linhuanmars/article/details/21314059

 */
package LeetCode;

public class MaximumSubarray {
	
	public int maxSubArray(int[] A) {
	    if(A == null || A.length == 0){
	    	return 0;
	    }
	    
	    // !!! initialization
	    int max = Integer.MIN_VALUE;
	    int local = 0;

	    for(int i = 0; i<A.length; i++){
	        if(local>=0){
	        	local+=A[i];
	        }
	        else{
	        	local=A[i];
	        }
	    	if(local > max){
	    		max =local;
	    	}	    		    	
	    }
	    return max;
	}
	// maybe easier to understand
	public int maxSubArrayII(int[] A) {
	    if(A==null || A.length==0)
	        return 0;
	    int global = A[0];// store the max value
	    int local = A[0]; //store the contiguous subarray until last one
	    for(int i=1;i<A.length;i++)
	    {
	        local = Math.max(A[i],local+A[i]);
	        global = Math.max(local,global);
	    }
	    return global;
	}
	
}
