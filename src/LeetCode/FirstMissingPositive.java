/**
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */
package LeetCode;

/**
 * 
 *
 */
public class FirstMissingPositive {

	/**
	 * 对于那些不在范围内的数字，我们可以直接跳过，比如说负数，0，或者超过数组长度的正数
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0){
        	return 1;
        }
        int len = A.length;
        for(int i=0; i<len; i++){
        	if(A[i]>0 && A[i]<=len){
            	int temp = A[A[i]-1];
            	//avoid infinite loop
            	if(A[i] != temp){
            		A[A[i]-1] = A[i];
            		A[i] = temp;
            		i--; //!!brilliant idea
            	}
        	}
        }
        for(int i=0; i<len; i++){
        	if(A[i]!=i+1){
        		return i+1;
        	}
        }
        return len+1;
    }
}
