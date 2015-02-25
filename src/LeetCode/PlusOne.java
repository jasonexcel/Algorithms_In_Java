/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */
package LeetCode;

public class PlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = digits.length;
        for (int i=0; i<size; i++) {
        	//!!!
            if(digits[size-i-1] != 9) {
                digits[size-i-1]++;                
                return digits;
            }
            digits[size-i-1] = 0;            
        }
        int[] newD = new int[size+1];
        newD[0] = 1;
//        for(int i =1; i<newD.length; i++) {
//            newD[i] = 0;
//        }
        return newD;
        
    }
    

}
