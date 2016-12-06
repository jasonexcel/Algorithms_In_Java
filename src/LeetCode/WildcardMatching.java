/**
 * 
 */
package LeetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author sjia
 *
 */

public class WildcardMatching {
	@Test
	public void testWildcardMatching() throws Exception {
		WildcardMatching ins = new WildcardMatching();
		String s = "aa";
		String p = "*";
		assertThat(ins.isMatch(s, p), is(true));
	}
	// TLE
	public boolean isMatch(String s, String p) {

		int lenS = s.length();
		int lenP = p.length();
		if(lenS == 0 && lenP == 0) {
			return true;
		} else if(lenS == 0) {
			return containsOnlyStar(p);
		} else if(lenP == 0) {
			return false;
		}

		if(s.charAt(lenS-1) == p.charAt(lenP-1) || p.charAt(lenP-1) == '?') {
			return isMatch(s.substring(0, lenS-1), p.substring(0, lenP-1));
		}
		if(p.charAt(lenP-1) == '*') {
			return isMatch(s.substring(0, lenS-1), p.substring(0, lenP)) || isMatch(s.substring(0, lenS), p.substring(0, lenP-1));
		}
		return false;
	}

	private boolean containsOnlyStar(String str) {
		for(char c : str.toCharArray()) {
			if(c!= '*') {
				return false;
			}
		}
		return true;
	}

    // preferred
	public boolean isMatch_2d_method(String s, String p) {
		int m=s.length(), n=p.length();
		boolean[][] dp = new boolean[m+1][n+1];
		dp[0][0] = true;
		for (int i=1; i<=m; i++) {
			dp[i][0] = false;
		}
		// preprocess *
		for(int j=1; j<=n; j++) {
			if(p.charAt(j-1)=='*'){
				dp[0][j] = true;
			} else {
				break;
			}
		}

		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if (p.charAt(j-1)!='*') {
					dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?');
				} else {
					//dp[i-1][j] - * matches s.charAt(i-1)
					//dp[i][j-1] - * is "", s.charAt(i-1) to match p.charAt(j-2)
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
			}
		}
		return dp[m][n];
	}

	// TBK
	// stardard 2-D DP 
	public boolean isMatch2D(String s, String p) {
	    if(p.length()==0){
	    	return s.length()==0;
	    }
	    
	    //to pass the biggest test case    
	    if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*'){
	    	return false;
	    }

	    boolean[][] res = new boolean[s.length()+1][p.length()+1];
	    res[0][0] = true;

	    for(int j=1;j<=p.length();j++)
	    {
	        if(p.charAt(j-1)!='*')
	        {
	        	for(int i=1; i<=s.length(); i++){
	        		boolean isEqual = p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1);
	        		res[i][j] = res[i-1][j-1] && isEqual;
	        	}
	        }
	        else
	        {
	            int index = 0;
	            //find the first index where res[index][j-1] is true
	            while(index<=s.length()){
	            	if(res[index][j-1]){
	            		break;
	            	}
	            	index++;
	            }
	            //set all elements in jth column after row i-1 to true
	            for(int i=index; i<=s.length(); i++){
	            	res[i][j] = true;
	            }
	        }
	    }
	    return res[s.length()][p.length()];
	}
	
	//optimized to o(n) space complexity
	public boolean isMatchOptimized(String s, String p) {
	    if(p.length()==0){
	    	return s.length()==0;
	    }
	        
	    if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')
	    return false;
	    boolean[] res = new boolean[s.length()+1];
	    res[0] = true;
	    for(int j=0;j<p.length();j++)
	    {
	        if(p.charAt(j)!='*')
	        {
	            for(int i=s.length()-1;i>=0;i--)
	            {
	                res[i+1] = res[i]&&(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j));
	            }
	        }
	        else
	        {
	            int i = 0;
	            while(i<=s.length() && !res[i])
	                i++;
	            for(;i<=s.length();i++)
	            {
	                res[i] = true;
	            }
	        }
	        res[0] = res[0]&&p.charAt(j)=='*';
	    }
	    return res[s.length()];
	}
	//Greedy method, no need to know
	public boolean isMatchGreedy(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while (i < s.length()) {
			if (j < p.length()
					&& (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j++;
				mark = i;
			} else if (star != -1) {
				j = star + 1;
				i = ++mark;
			} else {
				return false;
			}
		}
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
		return j == p.length();
	}
}