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
            if (i>0 && num[i]==num[i-1]) continue;  
            int j = i+1;
            int k = num.length-1;
            while(j<k) {
                if(num[i] + num[j] + num[k] == 0) {
                    arrays.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k])));
                    do{
                        j++;
                    }while(j<k && num[j]==num[j-1]);
                    do{
                        k--;
                    }while(j<k &&num[k]==num[k+1]);
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
