package LeetCode;

public class NumberOfDigitOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NumberOfDigitOne().countDigitOne(110);
	}
	public int countDigitOne(int n) {
	    int rearSize = 1; //same as mod
	    long mod = 1;
	    int count = 0;
	    while(mod <= n){
	        long front = n / (mod * 10); //front part
	        long rear = n % mod;  // rear part
	        int curDigit =(int) (n % (mod * 10)) / rearSize;

	        if(curDigit > 1){
	            count += ((front + 1) * rearSize);
	        }
	        else if(curDigit == 1){
	            count += (front * rearSize + rear + 1);   // case: 113, cur digit is the second 1
	        }
	        else{
	            count += (front * rearSize);
	        }

	        mod *= 10;
	        rearSize *= 10;
	    }
	    return count;
	}
}
