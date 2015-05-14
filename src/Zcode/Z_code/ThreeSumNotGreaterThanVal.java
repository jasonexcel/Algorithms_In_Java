/**
 * 
 */
package Zcode.Z_code;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Shaun
 *
 */
public class ThreeSumNotGreaterThanVal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// binary search to find the upperbound
    public ArrayList<ArrayList<Integer>> threeSumNoGreater(int[] num, int val) {
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
                if(num[i] + num[j] + num[k] < val) {
                    arrays.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k])));
                    j++; // increment first
                    while(j<k && num[j] == num[j-1]){
                    	j++; //skip same values
                    }

                }
                else {
                	if(num[i] + num[j] + num[k] == val) {
                    	arrays.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k])));
                    }
                	k--;
                    while(j<k && num[k]==num[k+1]){
                    	k--; //skip same values
                    }
                }
            }
        }
        return arrays;
	}
}
