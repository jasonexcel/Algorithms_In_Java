/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
 *  in C where the candidate numbers sums to T.
 *  Each number in C may only be used once in the combination.
 *  */

package LeetCode;
import java.util.*;

public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0){
        	return results;
        }
        Arrays.sort(num);
        ArrayList<Integer> result = new ArrayList<Integer>();
        combinationSum2Help(num, target, 0, 0, result, results);
        return results;
    }

    private void combinationSum2Help(int[] num, int target, int sum, int index, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results){
    	if(target < sum){
    		return;
    	}
    	if(target == sum){
    		ArrayList<Integer> temp = new ArrayList<Integer>(result);
    		if(!results.contains(temp)){
    			results.add(temp);
    		}
    		return;
    	}
    	for(int i=index; i<num.length; i++){
    		result.add(num[i]);
    		combinationSum2Help(num, target, sum+num[i], i+1, result, results);
    		result.remove(result.size()-1);
    	}
    }
}