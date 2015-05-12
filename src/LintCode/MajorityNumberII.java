package LintCode;

import java.util.ArrayList;

public class MajorityNumberII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int majorityNumber(ArrayList<Integer> nums) {
	    int len = nums.size();
	    if (len < 3) {
	        return -1;
	    }
	    int a = 0, b = 0, c1 = 0, c2 = 0;
	    boolean isA = false, isB = false;
	    for (int val : nums) {
	        if (!isA || val == a) {
	            a = val; c1++; isA = true;
	        } else if (!isB || val == b) {
	            b = val; c2++; isB = true;
	        } else { // has both a and b
	            c1--;
	            c2--;
	            if (c1 == 0) isA = false;
	            if (c2 == 0) isB = false;
	        }
	    }
	    if (!isA) return b;
	    if (!isB) return a;
	    int c = 0;
	    for (int x : nums) {
	        if (a == x) c++;
	    }
	    return c > len/3 ? a : b;
	}
}
