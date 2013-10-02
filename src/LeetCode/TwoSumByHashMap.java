package LeetCode;

import java.util.HashMap;
public class TwoSumByHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] twoSum(int[] numbers, int target) {
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

}
