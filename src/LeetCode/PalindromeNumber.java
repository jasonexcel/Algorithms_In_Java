/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
package LeetCode;

/**
 * @author Shaun
 *
 */
public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//o(n) time complexity, o(1) space
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0) {
            return false;
        }
        int div = 1;
        while(x/div >=10) {
            div*=10;
        }
        //now, 0<= x/div <=9
        while(x>0) {
            if(x%10 != x/div) {
                return false;
            }
            x = (x%div)/10; //important!
            div = div/100;
        }
        return true;
    }
}
