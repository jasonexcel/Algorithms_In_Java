package LeetCode;
import java.util.HashMap;
public class RomanToInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s = s.trim();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int len = s.length();
        //!!!
        int sum = hm.get(s.charAt(len-1));
        for (int i = len-2; i>=0; i--) {
            char c = s.charAt(i);
            int a = hm.get(s.charAt(i));
            int b = hm.get(s.charAt(i+1));
            if( a >= b) {
                sum +=  a;
            }
            else {
                sum -= a;
            }
        }
        return sum;        
    }

}
