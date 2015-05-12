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
	//碰撞法，依次碰撞
	//https://richdalgo.wordpress.com/2015/02/01/lintcode-majority-number-i-ii-iii/
	public int majorityNumber(ArrayList<Integer> nums) {
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
