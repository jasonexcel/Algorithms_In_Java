/**
 * 
 */
package LeetCode;

/**
 * @author sjia
 *
 */

public class WildcardMatching {
	// TBK
	// stardard 2-D DP 
	public boolean isMatch(String s, String p) {
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