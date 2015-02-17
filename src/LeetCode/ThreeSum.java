/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 *  Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */

package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
public class ThreeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i=0; i<num.length-2 && num[i]<=0; i++) {
            if (i>0 && num[i]==num[i-1]) {
            	continue;  //avoid duplicate results
            }
            //two sum here
            int j = i+1;
            int k = num.length-1;
            while(j<k) {
                if(num[i] + num[j] + num[k] == 0) {
                    arrays.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k])));
                    j++;
                    k--;
                    while(j<k && num[j] == num[j-1]){
                    	j++; //skip same values
                    }
                    while(j<k &&num[k]==num[k+1]){
                    	k--; //skip save values
                    }
                }
                else if(num[i] + num[j] + num[k] > 0) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return arrays;
	}

}
