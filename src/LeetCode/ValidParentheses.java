package LeetCode;
import java.util.Stack;
public class ValidParentheses {
	public static void main(String[] args){
		String s = "()";
		if(isValid(s))
			System.out.println("valid");
	}
	
	public static boolean isValid(String s) {
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
