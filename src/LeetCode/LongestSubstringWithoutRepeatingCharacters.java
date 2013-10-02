package LeetCode;

import java.util.ArrayList;

public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		String b = s;
		String c = new String(s);
		char a1 = '1';
		char[] a = {'a','b'};
		char[] ab = a;
		char[] ac = a.clone();
		int a2 = a1;

	}
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
            if(repeat[s.charAt(i)] == false){
                repeat[s.charAt(i)] = true;
                
            }
            else{
                maxLen = maxLen>(i-start)? maxLen:(i-start);
                while(s.charAt(start) != s.charAt(i)){
                	// !!! reset the characters before new start
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
}
