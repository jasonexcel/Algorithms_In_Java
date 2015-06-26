/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
package LeetCode;

import java.util.*;

public class Combinations {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Combinations ins = new Combinations();
		ArrayList<ArrayList<Integer>> results = ins.combine(3,2);
		System.out.println(results.size()+ " groups");
		for(ArrayList<Integer> list : results) {
			for(int str : list) {				
					System.out.print(str+", ");
			}
			System.out.println();
		}
	}
	
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(n<1 || k<1 || n<k){
        	return results;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        combineHelp(results, res, 1, n, k);
        return results;
    }

    private void combineHelp(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> res, int val, int n, int k){
    	if(res.size() == k){
    		results.add(new ArrayList<Integer>(res));
    		return;
    	}
    	for(int i=val; i<=n; i++){
			res.add(i);
    		combineHelp(results, res, i+1, n, k);
    		res.remove(res.size()-1);
    	}    
    	return;		
    }
}