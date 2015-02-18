/**
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 */
package LeetCode;

public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//can handle integer overflow case, it will return 0
	public int reverse(int x) {
	    if(x==Integer.MIN_VALUE){
	    	return 0;
	    }
	        
	    int num = Math.abs(x);
	    int res = 0;
	    while(num!=0) {
	    	//to avoid res*10 + num%10 > Integer.MAX_VALUE, chech the condition here
	        if(res>(Integer.MAX_VALUE-num%10)/10){
	        	return 0;
	        }
	            
	        res = res*10+num%10;
	        num /= 10;
	    }
	    return x>0?res:-res;
	}
	
    public int reverseII(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x<0) {
            return 0-reversePos(0-x);
        }
        if (x>0) {
            return reversePos(x);
        }
        return x;
    }
    //this code can handle the case like '10', '100'
    private int reversePos(int x) {
        int reversed = 0;
            
            while(x>0) {  
                reversed = reversed * 10 +  x%10;//!
                x= x/10;
            }
            return reversed;
    }

}
