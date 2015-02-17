/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//o(n) time complexity, o(n) space
	//should not add all elements to hashmap, since there may contain duplicate values in the array
    public int[] twoSumHM(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] returnVal = new int[2];
        for (int i = 0; i< numbers.length; i++) {
            int pair = target - numbers[i];
            if(hm.containsKey(pair)) {
                    returnVal[0] = hm.get(pair);
                    returnVal[1] = i + 1;
                    break;
            }
            else {
                hm.put(numbers[i], i+1);
            }
        }
        return returnVal;
    }
    //o(n*logn) time, o(n) space
	public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		//Copy the original array and sort it
		int N = numbers.length;
		int[] sorted = new int[N];
		System.arraycopy(numbers, 0, sorted, 0, N);
        Arrays.sort(sorted);
        //find the two numbers using the sorted arrays
        int first = 0;
        int second = sorted.length - 1;
        while(first < second){
        	if(sorted[first] + sorted[second] < target){
        		first++;
        		continue;
        	}
        	else if(sorted[first] + sorted[second] > target){
        		second--;
        		continue;
        	}
        	else break;
        }
        int number1 = sorted[first];
        int number2 = sorted[second];
        //Find the two indexes in the original array
        int index1 = -1, index2 = -1;
        for(int i = 0; i < N; i++){
        	if((numbers[i] == number1) || (numbers[i] == number2)){
        		 if(index1 == -1) //no element yet, fill the first one
        			 index1 = i + 1;
        		 else
        			 index2 = i + 1;
        	}
        		
        }
        int [] result = new int[]{index1, index2};
        //Arrays.sort(result); already sorted
		return result;
    }
}
