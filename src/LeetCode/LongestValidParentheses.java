/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
package LeetCode;

import java.util.Stack;

public class LongestValidParentheses {

	/**
	 * O(n) time, O(n) space
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidParentheses ins = new LongestValidParentheses();
		String s = "()(()";
		ins.longestValidParentheses(s);

	}
    public int longestValidParentheses(String s) {
	    if(s==null || s.length()==0){
	    	return 0;
	    }
	    // Integer type here    
	    Stack<Integer> stack = new Stack<Integer>();
	    int start = 0;
	    int max = 0;
	    for(int i=0;i<s.length();i++)
	    {
	    	//All elements in the stack are '('
	        if(s.charAt(i)=='(')
	        {
	            stack.push(i);
	        }
	        else
	        {
	            if(stack.isEmpty())
	            {
	                start = i+1;	// new start from next char index in the string
	            }
	            else
	            {
	                stack.pop(); 	//clear the () pair
	                if(stack.isEmpty()){
	                	//() match the from the start to the i element
	                	max = Math.max(max, i-start+1);
	                }
	                else{
	                	//left elements in the stack cannot be paired
	                	max = Math.max(max,  i-stack.peek());
	                }
	            }
	        }
	    }
	    return max;
    }
}
