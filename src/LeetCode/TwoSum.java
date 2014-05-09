package LeetCode;

import java.util.Arrays;

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
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
        		 if(index1 == -1)
        			 index1 = i + 1;
        		 else
        			 index2 = i + 1;
        	}
        		
        }
        int [] result = new int[]{index1, index2};
        Arrays.sort(result);
		return result;
    }
}
