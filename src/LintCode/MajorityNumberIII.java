package LintCode;

import java.util.*;
public class MajorityNumberIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int majorityNumber(ArrayList<Integer> nums, int k) {
	    int len = nums.size();
	    if (len < k) {
	        return -1;
	    }
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int x : nums) {
	        if (map.size() < k && !map.containsKey(x)) {
	            map.put(x, 1);
	        } else if (map.containsKey(x)) {
	            map.put(x, map.get(x) + 1);
	        } else {
	            Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();
	            for (int key : map.keySet()) {
	                if (map.get(key) > 1) {
	                    tmp.put(key, map.get(key)-1);
	                }
	            }
	            map = tmp;
	        }
	    }
	    int result = 0;
	    int count = 0;
	    for (int key : map.keySet()) {
	        if (map.get(key) > count) {
	            result = key;
	            count = map.get(key);
	        }
	    }
	    return result;
	}
}
