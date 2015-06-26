package RealInterviewQuestion;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EvaluateReversePolishNotation ins = new EvaluateReversePolishNotation();
		String str = "93 3 /";
		float res = ins.calcExpe(str);
		String str2 = ins.buildMathString(str);
		System.out.println(res);
		System.out.println(str2);

	}
	// This is the text editor interface. 
	// Anything you type or change here will be seen by the other person in real time.

//	Input:
//
//	"1 2 +"          ===> "(1 + 2)"             ===> 3
//	"1 2 3 + +"      ===> "(1 + (2 + 3))"       ===> 6
//	"6 3 * 5 +"      ===> "((6 * 3) + 5)"       ===> 23
//	"9 3 / 4 5 + *"  ===> "((9 / 3) * (4 + 5))" ===> 27
//	"5 2 /"          ===> "(5 / 2)"             ===> 2.5
//
//	3 * 9= 27


	public String buildMathString(String str) {
	    if(str == null || str.length() == 0) {
	        return "";
	    }
	    StringBuilder res = new StringBuilder();
	    Stack<StringBuilder> vals = new Stack<StringBuilder>();
	    String[] strArr = str.split(" ");
	    for(int index=0; index<strArr.length; index++) {
	        String cur = strArr[index];
	        if(isOperator(cur)){
	            StringBuilder right;
	            StringBuilder left;
	            if(!vals.empty()) {
	                 right = vals.pop();
	            }
	            else {
	                throw new IllegalArgumentException();
	            }
	            if(!vals.empty()) {
	                left = vals.pop();
	            }
	            else {
	                throw new IllegalArgumentException();
	            }
	            StringBuilder val = composeExpression(left, right, cur);
	            vals.push(val);
	        }
	        else {
	            vals.push(new StringBuilder(cur));
	        }
	    }
	    if(!vals.empty()) {
	        res = vals.pop();
	    }
	    if(vals.empty()) {
	        return res.toString();
	    }
	    else {
	        throw new IllegalArgumentException();
	    }
	}

	private StringBuilder composeExpression(StringBuilder left, StringBuilder right, String oper) {
	    StringBuilder result = new StringBuilder();
	    result.append("(");
	    result.append(left);
	    result.append(" ");
	    result.append(oper);
	    result.append(" ");
	    result.append(right);
	    result.append(")");
	    return result;
	}

	public float calcExpe(String str) {
	    if(str == null || str.length() == 0) {
	        return 0;
	    }
	    float res = 0;
	    Stack<Float> vals = new Stack<Float>();
	    String[] strArr = str.split(" ");
	    for(int index=0; index<strArr.length; index++) {
	        String cur = strArr[index];
	        if(isOperator(cur)){
	            float right;
	            float left;
	            if(!vals.empty()) {
	                 right = vals.pop();
	            }
	            else {
	                throw new IllegalArgumentException();
	            }
	            if(!vals.empty()) {
	                left = vals.pop();
	            }
	            else {
	                throw new IllegalArgumentException();
	            }
	            float val = calcSimpleExpression(left, right, cur.charAt(0));
	            vals.push(val);
	        }
	        else {
	        	float curValue = (float) Integer.parseInt(cur);
	            //float curValue = (float) convertStringToNumeric(cur);
	            vals.push(curValue);
	        }
	    }
	    if(!vals.empty()) {
	        res = vals.pop();
	    }
	    if(vals.empty()) {
	        return res;
	    }
	    else {
	        throw new IllegalArgumentException();
	    }
	}

	private int  convertStringToNumeric(String str) {
	    if(str == null || str.length() == 0) {
	        return 0;
	    }
	    int res = 0;
	    for(int i=0; i<str.length(); i++) {
	        int cur = str.charAt(i) - '0';
	        res = res*10 + cur;
	    }
	    return res;
	}

	private boolean isOperator(String str) {
	    if(str == null || str.length() == 0) {
	        return false;
	    }
	    if(str.length() == 1) {
	        char tempC = str.charAt(0);
	        if(tempC == '+' || tempC == '-' || tempC == '*' || tempC == '/') {
	            return true;
	        }

	    }
	    return false;
	}

	private float calcSimpleExpression(float left, float right, char oper) {
	    float result;
	    switch(oper) {
	        case '+' : result = left + right;
	        break;
	        case '-' : result = left - right; 
	        break;
	        case '*' : result = left * right;
	        break;
	        case '/' : if(right != 0.0) {
	            result = left / right;
	        }
	        else {
	            throw new IllegalArgumentException();
	        }
	        break;
	        default : throw new IllegalArgumentException();
	    }        
	     
	    return result;   
	}
}
