/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

Sort the array first, for duplicate values, if the former one is used, the current can be added;
otherwise, continue the loop
 */
package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public static void main(String[] args){
		int[] num = {1,1,2};
		new PermutationsII().permuteUnique(num);
	}
	
	public List<List<Integer>> permuteUnique(int[] num) {
	    List<List<Integer>> results = new ArrayList<List<Integer>>();
	    if(num==null && num.length==0){
	    	return results;
	    }
	    int[] sortedNum = Arrays.copyOf(num, num.length);
	    Arrays.sort(sortedNum);
	    boolean[] used = new boolean[sortedNum.length];
	    List<Integer> result = new ArrayList<Integer>();
	    helper(sortedNum, new boolean[sortedNum.length], result, results);
	    return results;
	}
	private void helper(int[] num, boolean[] used, List<Integer> result, List<List<Integer>> results)
	{
	    if(result.size() == num.length)
	    {
	    	results.add(new ArrayList<Integer>(result));
	        return;
	    }
	    for(int i=0;i<num.length;i++)
	    {
	    	// i is not the first value; value at i is same as the former one; 
	    	// ! and the former one is not used, so you cannot use current value 
	    	// at i, skip it
	        if(i>0 && num[i]==num[i-1] && !used[i-1]) {
	        	continue;
	        }
	        if(!used[i])
	        {
	            used[i] = true;
	            result.add(num[i]);
	            helper(num, used, result, results);
	            result.remove(result.size()-1);
	            used[i] = false;
	        }
	    }
	}
}
