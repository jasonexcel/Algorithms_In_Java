/**
 * Implement pow(x, n).
 */
package LeetCode;

public class Pow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((int) -1/2);
		System.out.println(pow(2,11));
	}
    public static double pow(double x, int n) {
        if(n == 0) return 1.0;

        else if(n%2 == 0){
        	double temp = pow(x, n/2);
            return temp*temp ;
        }
        else{
        	double temp = pow(x, n/2);
        	if(n<0){
        		return temp*temp*1/x;
        	}
        	return temp*temp*x;
        }
        
    }
    // first choice
    //no difference to the first one
    public static double powII(double x, int n) {
        if(n == 0) return 1.0;
        // warning: Integer.MIN_VALUE needs to be treated differently
        // since -Integer.MIN_VALUE is it self, 
        // Integer.MIN_VALUE % 2 == 0, even number 
        if(n == Integer.MIN_VALUE) {
        	double temp = pow(x, -n/2);
        	return temp*temp;
        }
        else if(n<0){
        	return 1/pow(x, -n);
        }
        else if(n%2 == 0){
        	double temp = pow(x, n/2);
            return temp*temp ;
        }
        else{
        	double temp = pow(x, n/2);
        	return temp*temp*x;
        }
        
    }
    //solid solution; o(logn) time complexity
    //http://blog.csdn.net/linhuanmars/article/details/20092829
    public double powIII(double x, int n) {
        if(n==0){
            return 1.0;	
        }
        
        double res = 1.0;   
        if(n<0){
            if(x>=1.0/Double.MAX_VALUE||x<=1.0/-Double.MAX_VALUE) {
            	x = 1.0/x;
            }                
            else{
            	return Double.MAX_VALUE;//overflow when n<0
            }
                
            if(n==Integer.MIN_VALUE)
            {
                res *= x;
                n++;
            }
        }
        n = Math.abs(n);
        boolean isNeg = false;
        if(n%2==1 && x<0)
        {
            isNeg = true;
        }
        x = Math.abs(x);
        //square-based method
        while(n>0)
        {
            if((n&1) == 1) // equal to (n%2 == 1)
            {
                if(res>Double.MAX_VALUE/x){
                	return Double.MAX_VALUE; //overflow
                }                    
                res *= x;
            }
            x *= x;
            n = n>>1; // equal to n=n/2;
        }
        return isNeg?-res:res;
    }

}
