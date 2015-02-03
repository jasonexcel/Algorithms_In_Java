/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */
package LeetCode;

/**
 * dp[i][j] = dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1) || dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1)
 *	time complexity: o(m*n), space complexity : o(m*n) can be optimized to be o(min(m,n))
 */
public class InterleavingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isInterleave(String s1, String s2, String s3) {
	       if(s3.length()!=s1.length()+s2.length()){
	    	   return false;  
	       }	         
	        
	       boolean [][] dp = new boolean [s1.length()+1][s2.length()+1];//!!!
	       dp[0][0]=true;
	       
	       for(int i = 1; i<=s1.length() && s1.charAt(i-1)==s3.charAt(i-1); i++){
	    	   //only s1 used 
	    	   dp[i][0]=true;
	       }
	           	       
	       for(int i = 1; i<=s2.length() && s2.charAt(i-1)==s3.charAt(i-1); i++){
	    	   //only s2 used
	    	   dp[0][i]=true;
	       }
	           	       
	       for(int i = 1; i <= s1.length(); i++){
	           for(int j = 1; j <= s2.length(); j++){
	               char c = s3.charAt(i+j-1);
	               if(c == s1.charAt(i-1) && dp[i-1][j]){	            	   
	            	   dp[i][j] = true;
	               }	                 
	               if(c == s2.charAt(j-1) && dp[i][j-1]){
	            	   dp[i][j] = true;
	               }
	                 
	           }
	       }
	      return dp[s1.length()][s2.length()];
	    }
}
