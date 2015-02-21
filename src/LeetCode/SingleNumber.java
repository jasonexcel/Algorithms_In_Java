/**
 * Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
package LeetCode;

import java.util.HashSet;

/**
 * @author Shaun
 *
 */
public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0){
            return Integer.MAX_VALUE;
        }
        int res = 0;
        for(int i=0; i<A.length; i++){
            res = res^A[i];
        }
        return res;
    }
    
	static int singleNumberSet(int[] a) {
        if(a == null || a.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<a.length; i++){
            if(set.contains(a[i])){
                set.remove(a[i]);
            }
            else{
                set.add(a[i]);
            }
        }
        if(set.size() == 1){
            return (int)set.iterator().next();
        }
        return 0;
    }
}
