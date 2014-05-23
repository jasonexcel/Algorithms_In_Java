package LeetCode;

import java.util.*;

public class Combinations {
	
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