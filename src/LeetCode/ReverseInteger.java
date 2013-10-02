package LeetCode;

public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int reverse(int x) {
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
    
    private int reversePos(int x) {
        int reversed = 0;
            
            while(x>0) {  
                reversed = reversed * 10 +  x%10;
                x= x/10;
            }
            return reversed;
    }

}
