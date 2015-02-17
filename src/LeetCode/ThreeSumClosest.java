/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
package LeetCode;
import java.util.Arrays;
public class ThreeSumClosest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//time complexity o(n^2), space o(n)
	 public int threeSumClosest(int[] num, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int len = num.length;
	        if(len<3) return -1;
	        int close = num[0] + num[1] + num[len-1];//initialization
	        int sum;
	        Arrays.sort(num);
	        for(int i = 0; i<len-2; i++){
	            int j = i+1;
	            int k = len-1;

	            while(j<k){    
	                 sum = num[i] + num[j] + num[k];
	                if(sum == target){
	                    return target;
	                }
	                else if(sum < target){
	                    if(Math.abs(sum-target) < Math.abs(close-target)){
	                        close = sum;
	                    }
	                    j++;
	                }
	                else {
	                    if(Math.abs(sum-target)<Math.abs(close-target)){
	                        close = sum;
	                    }
	                    k--;
	                }
	            }
	        }
	        return close;
	    }
}
