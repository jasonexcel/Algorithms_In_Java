/**
 * Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
http://blog.csdn.net/linhuanmars/article/details/20024907
 */
package LeetCode;

/**
 * @author sjia
 *
 */
public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
	    if(divisor == 0)
	    {
	        return Integer.MAX_VALUE;
	    }
	    //check the first digits for dividend and divisor,
	    //if one of them is 1 and another is 0, then the result is negative
	    boolean isNeg = (dividend^divisor)>>>31 == 1;
	    int res = 0;
	    //handle min_value 
	    if(dividend == Integer.MIN_VALUE)
	    {
	    	//!!
	        dividend += Math.abs(divisor);
	        if(divisor == -1)
	        {
	            return Integer.MAX_VALUE;
	        }
	        res++;
	    }
	    if(divisor == Integer.MIN_VALUE)
	    {
	        return res;
	    }
	    dividend = Math.abs(dividend);
	    divisor = Math.abs(divisor);
	    int digit = 0;
	    //the new divisor equals old divisor * 2^digit, new divisor is just less than or equal to 
	    while(divisor <= (dividend>>1))
	    {
	        divisor <<= 1;
	        digit++;
	    }
	    while(digit>=0)
	    {
	        if(dividend>=divisor)
	        {
	        	//add result with 2^digit
	            res += 1<<digit;
	            //dividend leftover
	            dividend -= divisor;
	        }
	        // decrease digit by 1, new divisor, divisor is always associated with digit
	        divisor >>= 1;
	        digit--;
	    }
	    return isNeg?-res:res;
	}
}
