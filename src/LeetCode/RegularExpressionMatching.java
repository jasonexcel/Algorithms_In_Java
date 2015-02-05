/**
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */
package LeetCode;

/**
 * http://blog.csdn.net/linhuanmars/article/details/21145563
 *
 */
public class RegularExpressionMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isMatch(String s, String p) {
	    return helper(s,p,0,0);
	}
	private boolean helper(String s, String p, int i, int j)
	{
	    if(j==p.length())
	        return i==s.length();
	    
	    if(j==p.length()-1 || p.charAt(j+1)!='*')
	    {
	        if(i==s.length()|| s.charAt(i)!=p.charAt(j) && p.charAt(j)!='.')
	            return false;
	        else
	            return helper(s,p,i+1,j+1);
	    }
	    //p.charAt(j+1)=='*'
	    while(i<s.length() && (p.charAt(j)=='.' || s.charAt(i)==p.charAt(j)))
	    {
	        if(helper(s,p,i,j+2))
	            return true;
	        i++;
	    }
	    return helper(s,p,i,j+2);
	}
}
