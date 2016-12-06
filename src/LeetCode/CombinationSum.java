/**
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 */
package LeetCode;

import java.util.*;
public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> group = new ArrayList<>();
		dfs(candidates, target, 0, res, group);
		return res;
	}

	private void dfs(int[] can, int target, int cur, List<List<Integer>> res, List<Integer> group) {
		if(target == 0) {
			res.add(new ArrayList<Integer>(group));
			return;
		}

		for(int i=cur; i<can.length; i++) {
			if(can[i] > target) {
				break;
			}
			group.add(can[i]);
			dfs(can, target-can[i], i, res, group);
			group.remove(group.size()-1);
		}
	}
}
