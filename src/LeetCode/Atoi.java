/**
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, 
please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature 
accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first 
non-whitespace character is found. Then, starting from this character, takes an optional 
initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, 
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, 
or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value 
is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
package LeetCode;

public class Atoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int atoi(String str) {
	    if(str==null)
	    {
	        return 0;
	    }
	    str = str.trim();
	    if(str.length()==0)
	        return 0;
	    boolean isNeg = false;
	    int i = 0;
	    if(str.charAt(0)=='-' || str.charAt(0)=='+')
	    {
	        i++;
	        if(str.charAt(0)=='-')
	            isNeg = true;
	    }
	    int res = 0;
	    while(i<str.length())
	    {
	        if(str.charAt(i)<'0'||str.charAt(i)>'9')
	            break;
	        int digit = (int)(str.charAt(i)-'0');
	        // transform to res*10+digit > -Integer.MIN_VALUE
	        if(isNeg && res>-((Integer.MIN_VALUE+digit)/10))
	            return Integer.MIN_VALUE;
	        else if(!isNeg && res>(Integer.MAX_VALUE-digit)/10)
	            return Integer.MAX_VALUE;
	        res = res*10+digit;
	        i++;
	    }
	    return isNeg?-res:res;
	}
	
    public int atoiII(String s) {
        s = s.trim();
        long value = 0; // long here
        boolean isPositive = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                if (s.charAt(i) == '-') {
                    isPositive = false;
                }
                continue;
            }
            if (s.charAt(i) < '0' || s.charAt(i) > '9') 
            	break;
            
            value = 10 * value + s.charAt(i) - '0';
            
            if(value > Integer.MAX_VALUE && !isPositive) {
                    return  -1*Integer.MIN_VALUE;
                }
            if(value >=Integer.MAX_VALUE && isPositive) {
                    return Integer.MAX_VALUE;
                }
        }
        value = isPositive == true ? value : value * -1;

        return (int) value;
        
    }

    // my solution
    public int atoiIII(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        // skip heading zeros
        int i = 0;
        while(str.charAt(i) == ' ' && i < str.length()) {
            i++;
        }
        
        boolean isNegative = false;
        if(str.charAt(i) == '-') {
            isNegative = true;
            i++;
        }
        else if(str.charAt(i) == '+') {
            i++;
        }
        int res = 0;
        while(i < str.length()) {
            char tempChar = str.charAt(i);
            if('0'<= tempChar && tempChar <= '9') {
                int digit = tempChar - '0';
                if(validIntegerResult(res, digit, isNegative)){
                    res = res * 10 + digit;
                }
                else {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            }
            else {
                return isNegative ? 0 - res : res;
            }
            i++;
            
        }
        
        return isNegative ? 0 - res : res;
    }
    
    private boolean validIntegerResult(int res, int digit, boolean isNegative) {
        if(!isNegative) {
            if(res > (Integer.MAX_VALUE - digit) / 10) {
                return false;
            }
        }
        else {
            if(res >- ((digit + Integer.MIN_VALUE) / 10)) {
                return false;
            }
        }
        return true;
    }
}
