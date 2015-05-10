package basicAlgorithms;

public class LongestCommonSubsequences {

	/**
	 * @param args
	 * http://www.lintcode.com/en/problem/longest-common-subsequence/
	 * Given two strings, find the longest comment subsequence (LCS).

Your code should return the length of LCS.

Example
For "ABCD" and "EDCA", the LCS is "A" (or D or C), return 1

For "ABCD" and "EACB", the LCS is "AC", return 2

subsequences is not substring, not need to be consecutive to the original strings
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     * O(n^2) time and space, DP method
     */	
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || A.length() == 0 || B == null || B.length() == 0) {
        	return 0;
        }
        int lenA = A.length();
        int lenB = B.length();
        int[][] commonS = new int[lenA+1][lenB+1];
        for(int i=0; i<=lenA; i++) {
        	commonS[i][0] = 0;
        }
        for(int j=0; j<=lenB; j++) {
        	commonS[0][j] = 0;
        }
        for(int i=1; i<=lenA; i++) {
        	for(int j=1; j<=lenB; j++) {
        		if(A.charAt(i-1) == B.charAt(j-1)) {
        			commonS[i][j] = commonS[i-1][j-1] + 1;
        		}
        		else {
        			// !!!
        			commonS[i][j] = Math.max(commonS[i-1][j], commonS[i][j-1]);
        		}
        	}
        }
        return commonS[lenA][lenB];
    }
}
