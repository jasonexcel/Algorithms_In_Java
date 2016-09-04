/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
package LeetCode;

/**
 * http://www.cnblogs.com/springfor/p/3877101.html
 *
 */
public class TrappingRainWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater ins = new TrappingRainWater();
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Integer.toString(ins.trap(A)));
	}
	public int trap(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int i, max, total = 0;
        int left[] = new int[A.length];
        int right[] = new int[A.length];

        // count the max value for index i from left to i
        left[0] = A[0];
        for (i = 1; i < A.length; i++) {
            left[i] = Math.max(left[i-1], A[i]);
        }

        // count the max value for index i from right to i
        right[A.length-1] = A[A.length-1];
        for (i = A.length-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], A[i]);
        }

        // leftmost and rightmost index don't trap any water
        for (i = 1; i < A.length-1; i++) {
            // the trapped water at index i
            int bit = Math.min(left[i], right[i]) - A[i];
            if (bit > 0)
                total += bit;
        }

        return total;
    }

}
