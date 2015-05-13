package LintCode;
import java.util.*;

public class MajorityNumberI {

	/**
	 * @param args
	 * http://www.lintcode.com/en/problem/majority-number/
	 * 
	 * Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

Example
Given [1, 1, 1, 1, 2, 2, 2], return 1

Challenge
O(n) time and O(1) extra space
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//my solution
	public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            // No majority number.
            return -1;
        }
        
        int candidate = 0;
        
        // The phase 1: Voting.
        int cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
        	if (nums.get(i) == candidate) {
                cnt++;
            } 
            else if(cnt == 0) {
                candidate = nums.get(i);
                    cnt = 1;
            }
            else {
                cnt--;
            }
        }
        
        // The phase 2: Examing.
        cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candidate) {
                cnt++;
            }
        }
        
        // No majority number.
        if (cnt <= nums.size() / 2) {
            return -1;
        }
        
        return candidate;
    }
	
	//碰撞法，依次碰撞
	//https://richdalgo.wordpress.com/2015/02/01/lintcode-majority-number-i-ii-iii/
	public int majorityNumberTwo(ArrayList<Integer> nums) {
	    int len = nums.size();
	    if (len == 0) {
	        return -1;
	    }
	    int elem = nums.get(0);
	    int count = 1;
	    for (int i = 1; i < len; i++) {
	        int val = nums.get(i);
	        if (elem == val) {
	            count++;
	        } else {
	        	// !!!
	            count--;
	            if (count == 0) {
	                elem = val;
	                count = 1;
	            }
	        }
	    }
	    return elem;
	}
}
