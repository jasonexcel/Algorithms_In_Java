/**
 * Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
package LeetCode;

import java.util.*;
/**
 * @author Shaun
 *
 */
public class Subsets {
	public static void main(String[] args){
		Subsets ins = new Subsets();
		int[] S = {0,3, 1};
		System.out.print(Arrays.toString(S));
	}
	
	//iterative solution or DP, double prev results
	public List<List<Integer>> subsets(int[] S) {
    	if(S==null){
        	return null;
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();
        results.add(empty);
        //sort S first to meet requirement
        Arrays.sort(S);
        for(int i=0; i<S.length; i++){
        	//! need to get the current size first
        	int size = results.size();
        	for(int j=0; j<size; j++){
        		//to each current result, add the new number to the end of list
        		List<Integer> temp = new ArrayList<Integer>(results.get(j));
        		temp.add(S[i]);
        		results.add(new ArrayList<Integer>(temp));
        	}
        }
        return results;
    }	
}
