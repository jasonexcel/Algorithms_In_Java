/**
 * Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

warning: no duplicate value in the array
reference: http://blog.csdn.net/linhuanmars/article/details/21569031
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shaun
 *
 */
public class Permutations {
	public static void main(String[] args){
		int[] num = {1,3,2,5};
		new Permutations().permute(num);
	}
    public List<List<Integer>> permute(int[] num) {
    	if(num == null || num.length == 0){
    		return null;
    	}
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	// default is false
        boolean[] usedNum = new boolean[num.length];
        List<Integer> res = new ArrayList<Integer>();
        buildResults(num, usedNum, res, results);
        return results;
}
    // backtracking by recursive method
    private void buildResults(int[] num, boolean[] used, List<Integer> res, List<List<Integer>> results){
    	if(res.size() == num.length){
    		List<Integer> temp = new ArrayList<Integer>(res);
    		results.add(temp);
    		return;
    	}
    	for(int i=0; i<num.length; i++){
    		// no order for the integer array, for loop always starting from 0 to end, use object "used" 
    		//to track used integer 
    		if(!used[i]){
    			res.add(num[i]);
        		used[i] = true;
        		buildResults(num, used, res, results);
        		//back from the recursion, restore the last state
        		res.remove(res.size()-1);
        		// !!!
        		used[i] = false;
    		}
    		
    	}
    }

}