/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */
package LeetCode;

import java.util.ArrayList;

/**
 * @author Shaun
 *
 */
public class PermutationSequence {

	/**
	 * o(n^2) time complexity
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String getPermutation(int n, int k) {
	    if(n<=0)
	        return "";
	    k--; //to transfer it as begin from 0 rather than 1
	    StringBuilder res = new StringBuilder();
	    int factorial = 1;
	    ArrayList<Integer> nums = new ArrayList<Integer>();
	    // factorial = (n-1)!
	    for(int i=2;i<n;i++)
	    {
	        factorial *= i;
	    }
	    for(int i=1;i<=n;i++)
	    {
	        nums.add(i);
	    }
	    int round = n-1;
	    while(round>=0)
	    {
	        int index = k/factorial;
	        k %= factorial;
	        res.append(nums.get(index));
	        nums.remove(index);//!!!remove used, remove operation require o(n) time complexity
	        if(round>0)
	            factorial /= round;
	        round--;
	    }
	    return res.toString();
	}
}
