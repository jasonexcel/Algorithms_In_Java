package Zcode.Z_code;
import java.util.*;

class Expression {
    boolean hasValue = false;
    double val;
    char operator;
    List<Expression> numbers;
    
    public Expression() {
        numbers = new ArrayList<Expression>();
    }
    
}
public class ExpressionEvaluation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// This is the text editor interface. 
	// Anything you type or change here will be seen by the other person in real time.
	// An "expression" is either a number, or a list (AKA vector/array) with the first element one of '+',' -', '*', '/' , and then other expressions. 
	//Write a function "evaluate" that gets an expression and returns its value.
	// ['+', 1, 2] --> 3
	// ['*', 3, ['+', 1, 10]] --> 33
	// ['+', 1, 2, 3, 4] --> 10

	// Expression(operator='*', numbers=[])

	// ['+', a, b, c] == ['+', a, ['+', b, c]]
	

	// time complexity: O(N*M) (N is the total expression size, M is the average element length of each expression); space complexity: O(logN) the average stack size
	public double evaluate(Expression exp) {
	    if(exp == null) {
	        return 0;
	    }
	    // exp is not null, but it is a number
	    if(exp.hasValue) {
	        return exp.val;
	    }
	    // exp is a full expression
	    char oper = exp.operator;
	    List<Double> vals = new ArrayList<Double>();
	    List<Expression> numbers = exp.numbers;
	    // handle case: Expression(operator='*', numbers=[])
	    if(numbers == null || numbers.size() == 0) {
	    	if(oper == '*') {
	    		return 1.0;
	    	}
	    	return 0.0;
	    }
	    for(int i=0; i < numbers.size(); i++) {
	        double res;
	        // handle case: Expression(operator='*', Expression('+', 2, 3), Expression()) -- second child expression is null
	        if(numbers.get(i) == null) {
	            if(oper == '*') {
	                res = 1.0;
	            }
	            else {
	                res = 0.0;
	            }
	        }
	        else {
	            res = evaluate(numbers.get(i));
	        }
	        
	        vals.add(res);
	    }
	    return calc(oper, vals);
	}

	private double calc(char oper, List<Double> vals) {
	    double result = 0;
	    if(vals == null || vals.size() == 0) {
	    	throw new IllegalArgumentException("vals is null or empty");
	    }
	    switch(oper) {
	        case '+' : 
	            for(double e : vals) {
	                result += e;
	            }
	            break;
	        case '-' : 
	            if(vals.size() == 2) {
	                result = vals.get(0) - vals.get(1);
	            }
	            break;
	        case '*' : 
	            result = vals.get(0);
	            for(int i= 1; i< vals.size(); i++) {
	                result *= vals.get(i);
	                if(result == 0.0) {
	                    break;
	                }
	            }               
	            break;
	        case '/' : 
	            if(vals.size() == 2 && vals.get(1) != 0.0) {
	                result = vals.get(0) / vals.get(1);
	            }
	            break;
	        default :
	            throw new IllegalArgumentException("error");
	    }
	    return result;
	}
}
