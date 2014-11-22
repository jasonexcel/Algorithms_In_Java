/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */
package LeetCode;

import java.util.ArrayList;

public class PalindromePartitioning {

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0){
        	return results;
        }
        buildResults(results, result, s);
        return results;
    }
	// Backtracking method
    private void buildResults(ArrayList<ArrayList<String>> results, ArrayList<String> result, String s){
    	// iterate to the end of string
    	if(s.length() == 0){
    		//! here we must create an new object with same value as current result list
    		//! and then add it to results list of list, otherwise, the results will be empty
    		ArrayList<String> tempList = new ArrayList<String>(result);
    		results.add(tempList);
            return;
    	}
    	for(int end=1; end<=s.length(); end++){
    		String temp = s.substring(0, end);
    		if(isPalindrome(temp)){
    			//add the case with index = end
    			result.add(temp);
    			// finish all these cases for index = 'end'
    			buildResults(results, result, s.substring(end));
    			// remove the case with index = end(still keep the same part), prepare for index 'end+1'
    			result.remove(result.size()-1);
    		}
    	}    	
    }
    private boolean isPalindrome(String str){
    	for(int i=0; i<str.length()/2; i++){
    		if(str.charAt(i) != str.charAt(str.length() - i - 1)){
    			return false;
    		}
    	}
    	return true;
    }
}