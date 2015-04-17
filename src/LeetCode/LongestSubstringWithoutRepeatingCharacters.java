/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */

package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters ins = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(ins.lengthOfLongestSubstringIII("abba"));
		String s = "abc";
		String b = s;
		String c = new String(s);
		char a1 = '1';
		char[] a = {'a','b'};
		char[] ab = a;
		char[] ac = a.clone();
		int a2 = a1;

	}

    //* my solution: hashmap or hashset
    public int lengthOfLongestSubstringByHashMap(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int length = 0, maxLength = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++){
        	// not occur or occur before start, then increment length
        	if(!hm.containsKey(s.charAt(i)) || (hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i)) < start)){
        		hm.put(s.charAt(i), i);
        		length++;
        	}
        	// occurred after the start
        	else{
        		//set new start
        		start = hm.get(s.charAt(i))+1;
        		//update new length
        		length = i - start+1;
        		// !!!remove old entry, add new entry
        		hm.remove(s.charAt(i));
        		hm.put(s.charAt(i), i);
        	}
        	if(length>maxLength){
        			maxLength = length;
        		}
        }
        return maxLength;
    }
	//good to learn the boolean array, two pointers, but harder to understand
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null) return 0;
        if(s.length()==0) return 0;
        boolean[] repeat = new boolean[256];
        for(int i = 0; i<256; i++){
            repeat[i] = false;
        }
        int maxLen = 0;
        int start = 0, i = 0;
        for(i = 0; i<s.length(); i++){
        	// !!! direct access 
            if(repeat[s.charAt(i)] == false){
            	// not occur in the past, set to true and continue the loop
                repeat[s.charAt(i)] = true;
                
            }
            else{
                maxLen = maxLen>(i-start)? maxLen:(i-start);
                // !!! reset all the characters before the new start
                while(s.charAt(start) != s.charAt(i)){
                    repeat[s.charAt(start)] = false;
                    start++;
                }
                start++;
            }
        }
        // compare with the last substring
        maxLen = maxLen>(i-start)? maxLen:(i-start);
        return maxLen;
    }
    
    // my array solution
    public int lengthOfLongestSubstringIII(String s) {
    	if(s == null || s.length() == 0) {
            return 0;
        }
        int[] positions = new int[256];
        for(int i=0; i<positions.length; i++) {
            positions[i] = -1;
        }
        int start = 0;
        int cur = 0;
        int maxLen = 0;
        while(cur < s.length()) {
            int position = positions[s.charAt(cur)];
            // if the current char occurs at the index of the start or after, then update the "start position"
            if(position != -1 && position >= start) {
                if(cur - start > maxLen) {
                    maxLen = cur - start;
                }
                start = position + 1;
            }

            positions[s.charAt(cur)] = cur;
            cur++;
        }
        return Math.max(maxLen, cur - start);
    }
}
