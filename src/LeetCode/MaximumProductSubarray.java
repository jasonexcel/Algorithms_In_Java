/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
package LeetCode;
public class MaximumProductSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//o(n) time, o(1) space
	//http://blog.csdn.net/linhuanmars/article/details/39537283
    public int maxProduct(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        int maxLocal = A[0];
        int minLocal = A[0];
        int maxGlobal = A[0];
        for(int i=1; i<A.length; i++){
            int temp = maxLocal;
            maxLocal = Math.max(A[i], Math.max(maxLocal*A[i], minLocal*A[i]));
            minLocal = Math.min(A[i], Math.min(temp*A[i], minLocal*A[i]));
            maxGlobal = Math.max(maxGlobal, maxLocal);
        }
        return maxGlobal;
    }
}
