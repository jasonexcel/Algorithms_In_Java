package LeetCode;

public class LengthOfLastWord {

	/**
	 * @param args
	 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int lengthOfLastWord(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int len = s.length();
	        if (len == 0) {
	            return 0;
	        }
	        int wordLen = 0;
	        for (int i = 0; i < len; i++) {
	            if(s.charAt(len - i - 1) != ' ') {
	                wordLen++;
	                continue;                
	            }
	            if(s.charAt(len - i - 1) == ' ' && wordLen != 0) {
	                break;
	            }
	            
	            
	        }
	        return wordLen;
	        
	    }

}
