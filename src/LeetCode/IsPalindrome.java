/**
 * 
 */
package LeetCode;

public class IsPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsPalindrome ip = new IsPalindrome();
		ip.isPalindrome(1325335231);

	}
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
        while(x>0) {
            if(x%10 != x/div) {
                return false;
            }
            x = (x%div)/10; //!!!
            div = div/100;
        }
        return true;
    }
}
