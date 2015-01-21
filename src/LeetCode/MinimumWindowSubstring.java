/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

S = "BB", T = "BB", results is "BB" not "B"
S = "cbbac", T = "bac"
 */
package LeetCode;

import java.util.HashMap;

/**
 * @author Shaun	Time complexity O(n), space O(n)
 */
public class MinimumWindowSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumWindowSubstring ins = new MinimumWindowSubstring();
		String S = "bbba", T = "ba";
		System.out.println(ins.minWindow(S, T));
	}
	public String minWindow(String S, String T) {
	    if(S==null || S.length()==0){
	    	return "";
	    }
	    //build the hash table    
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i=0; i<T.length();i++){
	        if(map.containsKey(T.charAt(i))){
	            map.put(T.charAt(i),map.get(T.charAt(i))+1);
	        }
	        else{
	            map.put(T.charAt(i),1);
	        }
	    }
	    //two pointers
	    int left = 0;
	    int count = 0;
	    int minLen = S.length()+1;
	    int minStart = 0;
	    for(int right=0; right<S.length();right++){
	        if(map.containsKey(S.charAt(right))){
	            map.put(S.charAt(right),map.get(S.charAt(right))-1); //decrement by 1
	            if(map.get(S.charAt(right))>=0){
	                count++;
	            }
	            //if count equals the length of T string, then we find a solution
	            //update the count and move the left pointer inside the loop
	            while(count == T.length()){	            	
	                if(!map.containsKey(S.charAt(left))){
	                	left++;
	                }
	                else{
	                	map.put(S.charAt(left), map.get(S.charAt(left))+1); //add 1
	                    //when map.get(S.charAt(left)) is just greater than 0, there will be no redundant s.charAt(left)
	                    if(map.get(S.charAt(left))>0){
	                    	//find the correct left side of window in "left"
	                    	//to update the new min length and start position
	    	                if(right-left+1<minLen){	    	                	
	    	                    minLen = right-left+1;
	    	                    minStart = left;                    
	    	                }
	                    	//decrease the "count" to update the number of characters in the window 
	                        count--;	    	                
	                    }
	                    //move left pointer position	                    
	                    left++;
	                }	                
	            }
	        }
	    }
	    if(minLen>S.length()){
	        return "";
	    }
	    return S.substring(minStart,minStart+minLen);
	}
}
