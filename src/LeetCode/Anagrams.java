/**
 * Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
 */
package LeetCode;

import java.util.*;
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
    	if(strs == null || strs.length == 0){
    		return null;
    	}
    	ArrayList<String> result = new ArrayList<String>();
    	HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
    	for(String str : strs){
    		if(str == null){
    			continue;
    		}
    		String sortedStr = sortString(str);
    		if(hm.containsKey(sortedStr)){
    			ArrayList<String> temp = hm.get(sortedStr);
    			temp.add(str);
    		}
    		else{
    			ArrayList<String> temp = new ArrayList<String>();
    			temp.add(str);
    			hm.put(sortedStr, temp);
    		}
    	}    	
    	    	
    	for(ArrayList<String> arrList : hm.values()){
    		//!!! at least two strings
    		if(arrList.size()>1){
    			for(String str : arrList){
    				result.add(str);
    			}
    		}
    	}
    	return result;
    }
    
    public String sortString(String str){
    	char[] arr = str.toCharArray();
    	Arrays.sort(arr);
    	return Arrays.toString(arr);
    }
}
