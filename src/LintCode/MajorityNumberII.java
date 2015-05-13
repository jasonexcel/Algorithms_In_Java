package LintCode;

import java.util.ArrayList;
import java.util.List;

public class MajorityNumberII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityNumberII ins = new MajorityNumberII();
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(3);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(5);
		l.add(3);
		System.out.println(ins.majorityNumber(l));
	}
	// my solution
	public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        // When there are only 1 or 2 elements in the array,
        // there is no solution.
        if (nums == null || nums.size() <= 2) {
            return -1;
        }
        
        int n1 = 0;
        int n2 = 0;
        
        int cnt1 = 0;
        int cnt2 = 0;
        
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            int num = nums.get(i);
                      
            if (num == n1) {
                cnt1++;
            } else if (num == n2) {
                cnt2++;
            } else if (cnt1 == 0) {
                cnt1 = 1;
                n1 = num;
            } else if (cnt2 == 0) {
                cnt2 = 1;
                n2 = num;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        
        // count the two candidates.
        cnt1 = 0;
        cnt2 = 0;
        for (int num: nums) {
            if (num == n1) {
                cnt1++;
            } else if (num == n2) {
                cnt2++;
            }
        }
        
        if (cnt1 < cnt2) {
            return n2;
        }        
        
        return n1;
    }
	
	public int majorityNumberTwo(ArrayList<Integer> nums) {
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
