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
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x == 0) return 0;
        if(n == 0) return 1;
        boolean isPositive = true;
        if(n < 0) {
        	return 1/pow(x, -n);
        }
        if (n == 1) return x;
        else if(n%2 == 0){
        	double temp = pow(x, n/2);
            return temp*temp ;
        }
        else{
        	double temp = pow(x, n/2);
        	return temp*temp*x;
        }
        
    }

}
