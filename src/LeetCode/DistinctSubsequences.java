/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

http://blog.csdn.net/abcbc/article/details/8978146
http://blog.csdn.net/linhuanmars/article/details/23589057
Dynamic programming
 */
package LeetCode;

public class DistinctSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public int numDistinct1(String S, String T) {
		    // Start typing your Java solution below
		    // DO NOT write main() function
		    int[][] dp = new int[T.length() + 1][S.length() + 1];
		    dp[0][0] = 1;
		    for (int i = 1; i <= T.length(); i++) {
		      dp[i][0] = 0;
		    }
		    for (int j = 1; j <= S.length(); j++) {
		      dp[0][j] = 1;
		    }
		    for (int i = 1; i <= T.length(); i++) {
		      for (int j = 1; j <= S.length(); j++) {
		        dp[i][j] = dp[i][j - 1];
		        if (T.charAt(i - 1) == S.charAt(j - 1)) {
		          dp[i][j] += dp[i - 1][j - 1];
		        }
		      }
		    }
		    return dp[T.length()][S.length()];
		      
		  }
	  
	  public int numDistinct(String S, String T) {
		    if(T.length()==0)
		    {
		        return 1;
		    }
		    if(S.length()==0)
		        return 0;
		    int[] res = new int[T.length()+1];
		    res[0] = 1;
		    for(int i=0;i<S.length();i++)
		    {
		        for(int j=T.length()-1;j>=0;j--)
		        {
		            res[j+1] = (S.charAt(i)==T.charAt(j)?res[j]:0)+res[j+1];
		        }
		    }
		    return res[T.length()];
		}

}
