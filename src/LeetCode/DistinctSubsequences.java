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
		String S = "abbbi";
		String T = "abbi";
		System.out.println(numberDistinctIV(S, T));
	}

	// easier to understand, O(m*n)
	public int numDistinct1(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] dp = new int[T.length() + 1][S.length() + 1];
		dp[0][0] = 1;
		// S is empty
		for (int i = 1; i <= T.length(); i++) {
			dp[i][0] = 0;
		}
		// T is empty
		for (int j = 1; j <= S.length(); j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i <= T.length(); i++) {
			for (int j = 1; j <= S.length(); j++) {
				if (T.charAt(i - 1) != S.charAt(j - 1)) {
					//!!!
					dp[i][j] = dp[i][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
				}
			}
		}
		return dp[T.length()][S.length()];
	}
	// dp
	public int numDistinct(String S, String T) {
		if (T.length() == 0) {
			return 1;
		}
		if (S.length() == 0)
			return 0;
		int[] res = new int[T.length() + 1];
		res[0] = 1;
		for (int i = 0; i < S.length(); i++) {
			for (int j = T.length() - 1; j >= 0; j--) {
				res[j + 1] = (S.charAt(i) == T.charAt(j) ? res[j] : 0)
						+ res[j + 1];
			}
		}
		return res[T.length()];
	}
	// recursive, tle
	  public static int numDistinctIII(String S, String T) {
		    // Start typing your Java solution below
		    // DO NOT write main() function
		    if (S.length() == 0) {
		      return T.length() == 0 ? 1 : 0;
		    }
		    if (T.length() == 0) {
		      return 1;
		    }
		    int cnt = 0;
		    for (int i = 0; i < S.length(); i++) {
		      if (S.charAt(i) == T.charAt(0)) {
		        cnt += numDistinctIII(S.substring(i + 1), T.substring(1));
		      }
		    }
		    return cnt;
		  }
	  // TLE C(n, m) time complexity
	  public static int numberDistinctIV(String s, String t) {
		  if(t == null || t.length() == 0) {
			  return 1;
		  }
		  if(s == null || s.length() == 0) {
			  return 0;
		  }
		  int[] count = {0};
		  helper(s, t, count);
		  return count[0];
	  }
	  
	  private static void helper(String s, String t, int[] count) {
		  if(s.length() == 0) {
			  if(t.length() == 0) {
				  count[0]++;
			  }
		  }
		  else if(t.length() == 0) {
			  count[0]++;
		  }
		  else {
			  for(int i=0; i<s.length(); i++) {
				  if(s.charAt(i) == t.charAt(0)) {
					  helper(s.substring(i+1), t.substring(1), count);
				  }
			  }
		  }
	  }

}
