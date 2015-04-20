/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
package LeetCode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public EvaluateReversePolishNotation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// time complexity, space complexity  O(n)
	public int evalRPN(String[] tokens) {
	        int res = Integer.MIN_VALUE;
	        if(tokens == null) {
	            return res;
	        }
	        Stack<Integer> s = new Stack<Integer>();
	        int leftOperand;
	        int rightOperand;
	        for(int i=0; i<tokens.length; i++) {
	            char firstChar = tokens[i].charAt(0);
	            if(tokens[i].length() == 1 && isOperator(firstChar)) {
	                if(!s.empty()){
	                    rightOperand = s.pop();
	                }
	                else {
	                    return res;
	                }
	                if(!s.empty()) {
	                     leftOperand= s.pop();
	                }
	                else {
	                    return res;
	                }
	                int tempResult = calculateExpression(firstChar, leftOperand, rightOperand);
	                s.push(tempResult);
	            }
	            else {
	                int curOperand = Integer.parseInt(tokens[i]);
	                s.push(curOperand);
	            }
	        }
	        if(!s.empty()) {
	            res = s.pop();
	        }
	        return res;
	    }
	    
	    private boolean isOperator(char singleChar) {
	        switch(singleChar) {
	            case '+' :
	            case '-' :
	            case '*' :
	            case '/' :
	                return true;
	            default :
	                return false;
	        }
	    }
	    private int calculateExpression(char operator, int left, int right) {
	        int res;
	        switch(operator) {
	            case '+' : 
	                res = left + right;
	                break;
	            case '-' : 
	                res = left - right;
	                break;
	            case '*' : 
	                res = left * right;
	                break;
	            case '/' :
	                if(right == 0) {
	                    res = Integer.MIN_VALUE;
	                }
	                else {
	                    res = left / right;
	                }
	                
	                break;
	            default :
	                res = Integer.MIN_VALUE;
	        }
	        return res;
	    }
}
