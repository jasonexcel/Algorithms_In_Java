package LeetCode;
import java.util.Arrays;
public class ThreeSumClosest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int threeSumClosest(int[] num, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int len = num.length;
	        if(len<3) return -1;
	        int close = num[0] + num[1] + num[len-1];
	        int sum;
	        Arrays.sort(num);
	        for(int i = 0; i<len-2; i++){
	            int j = i+1;
	            int k = len-1;

	            while(j<k){    
	                 sum = num[i] + num[j] + num[k];
	                if(sum == target){
	                    return target;
	                }
	                else if(sum < target){
	                    if(Math.abs(sum-target) < Math.abs(close-target)){
	                        close = sum;
	                    }
	                    j++;
	                }
	                else {
	                    if(Math.abs(sum-target)<Math.abs(close-target)){
	                        close = sum;
	                    }
	                    k--;
	                }
	            }
	        }
	        return close;
	    }
}
