/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
package LeetCode;
import java.util.LinkedList;
import java.util.Stack;
public class ValidParentheses {
	public static void main(String[] args){
		String s = "()";
		if(isValid(s))
			System.out.println("valid");
	}
	// time- O(n), spece O(n)
	public static boolean isValid(String s) {
	    if(s==null || s.length()==0)
	        return true;
	    LinkedList<Character> stack = new LinkedList<Character>();
	    for(int i=0;i<s.length();i++)
	    {
	        switch(s.charAt(i))
	        {
	            case '(':
	            case '{':
	            case '[':
	                stack.push(s.charAt(i));
	                break;
	            case ')':
	                if(stack.isEmpty() || stack.pop()!='(')
	                    return false;
	                break;
	            case '}':
	                if(stack.isEmpty() || stack.pop()!='{')
	                    return false;
	                break;
	            case ']':
	                if(stack.isEmpty() || stack.pop()!='[')
	                    return false;
	                break; 
	            default:
	                break;
	        }
	    }
	    if(stack.isEmpty())
	        return true;
	    return false;
	}
	public static boolean isValidII(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> stack = new Stack<Character>();
        if(s == null) return true;
        for(int i=0; i<s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            //char c = ((Character) stack.peek()).charValue();
            char c = stack.peek();
            char d = s.charAt(i);
            if(( c == '('  && d == ')') || (c == '{' && d == '}') || (c == '[' && d == ']')) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }            
        }
        if(stack.isEmpty()) return true;
        return false;
    }

}
