/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 */

package LeetCode;

public class LongestPalindromicSubstring {
	//General solution, o(n^2) time complexity  
	// iterating through the center of the substring
	public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
        	return "";
        }
        int maxLen = 0;
        String longestPal="";
        for(int i=0;i<=2*s.length()-1;i++){
        	int left = i/2;
        	int right;
        	if(i%2==0){
        		// staring from the center
        		right = left;
        	}
        	else{
        		//center is between left and right
        		right = left+1;
        	}
        	String subPal;
        	subPal = findSubPalindrome(s, left, right);
        	if(subPal.length()>maxLen){
        		maxLen = subPal.length();
        		longestPal = subPal;
        	}
        }
        return longestPal;
    }

    private String findSubPalindrome(String str, int leftStart, int rightStart){
    	while(leftStart>=0 && rightStart<=str.length()-1){
    		if(str.charAt(leftStart) == str.charAt(rightStart)){
    			leftStart--;
    			rightStart++;
    		}
    		else{
    			break;
    		}
    	}
    	return str.substring(leftStart+1,rightStart);
    }
    
    //Dynamic programming solution, time complexity - o(n^2)
    //http://fisherlei.blogspot.com/2012/12/leetcode-longest-palindromic-substring.html
    public String longestPalindromeDP(String s) {
        if(s == null || s.length()==0)
            return "";
        boolean[][] palin = new boolean[s.length()][s.length()];
        String res = "";
        int maxLen = 0;
        for(int i=0;i<s.length();i++)
        {
            //j is not greater than i
            for(int j=0;j<=i;j++)
            {
            	// must match && (either j, i is at certain distance or subproblem is true)
                if(s.charAt(i)==s.charAt(j) && (i-j<2 || palin[j+1][i-1]))
                {
                    // palin[j][i]: start index at j, end index at i
                    palin[j][i] = true;
                    if(maxLen<i-j+1)
                    {
                        maxLen=i-j+1;
                        res = s.substring(j,i+1);
                    }
                }
            }
        }
        return res;
    }
}
