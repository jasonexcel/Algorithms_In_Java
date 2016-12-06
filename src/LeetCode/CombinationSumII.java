/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
 *  in C where the candidate numbers sums to T.
 *  Each number in C may only be used once in the combination.
 *  */

package LeetCode;
import java.util.*;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<Integer> sol = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		dfs(candidates, target, 0, sol, res);
		return res;
	}

	private void dfs(int[] candidates, int target, int index, List<Integer> sol, List<List<Integer>> res) {
		if(target == 0) {
			res.add(new ArrayList(sol));
			return;
		}
		for(int i=index; i<candidates.length; i++) {
			int val = candidates[i];
			if(val<=target) {
				if(i>index && candidates[i-1] == val) {
					continue;
				}
				sol.add(val);
				dfs(candidates, target-val, i+1, sol, res);
				sol.remove(sol.size()-1);
			} else {
				break;
			}
		}
	}
//    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
//        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
//        if(num.length == 0){
//        	return results;
//        }
//        Arrays.sort(num);
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        combinationSum2Help(num, target, 0, 0, result, results);
//        return results;
//    }
//
//    private void combinationSum2Help(int[] num, int target, int sum, int index, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results){
//    	if(target < sum){
//    		return;
//    	}
//    	if(target == sum){
//    		ArrayList<Integer> temp = new ArrayList<Integer>(result);
//    		if(!results.contains(temp)){
//    			results.add(temp);
//    		}
//    		return;
//    	}
//    	for(int i=index; i<num.length; i++){
//    		result.add(num[i]);
//    		combinationSum2Help(num, target, sum+num[i], i+1, result, results);//!!!
//    		result.remove(result.size()-1);
//    	}
//    }
}