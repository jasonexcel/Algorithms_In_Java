
package LeetCode;

import java.util.*;
public class CombinationSum {
  	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(candidates.length<1){
		    return results;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		Arrays.sort(candidates);
		combinationSumHelp(candidates, target, 0, 0, result, results);
		return results;
	}
	
	public void combinationSumHelp(int[] candidates, int target, int sum, int step, 
			ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results){
		if(sum>target){
			return;
		}
		if(sum == target){
			ArrayList<Integer> temp = new ArrayList<Integer>(result);
			if(!results.contains(temp)){
				results.add(temp);
			}
			return;
		}
		for(int i=step; i<candidates.length; i++){
			result.add(candidates[i]);
			combinationSumHelp(candidates, target, sum+candidates[i], i, result, results);
			result.remove(result.size() - 1);
		}
		return; // not needed
	}
}
