package LintCode;

import java.util.*;
public class MajorityNumberIII {

	/**
	 * @param args
	 * Medium Majority Number III

Given an array of integers and a number k, the majority number is the number that occurs
 more than 1/k of the size of the array.

Find it.

Example
Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.

Note
There is only one majority number in the array.

Challenge
O(n) time and O(k) extra space
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityNumberIII ins = new MajorityNumberIII();
		List<Integer> l = new ArrayList<Integer>();
		l.add(3);
		l.add(1);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(3);
		l.add(5);
		System.out.println(ins.majorityNumber(l, 3));
	}
	public int majorityNumber(List<Integer> nums, int k) {
		if(nums.size() < k) {
			return -1;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int e : nums) {
			if(map.containsKey(e)) {
				map.put(e,  map.get(e) + 1);
			}
			else if(map.size() < k) {
				map.put(e, 1);
			}
			else {
				Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
				for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
					// !!! must greater than 1
					if(entry.getValue() > 1) {
						temp.put(entry.getKey(), entry.getValue() - 1);
					}
				}
				map = temp;
			}
		}
		
		int res = 0;
		int count = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > count) {
				count = entry.getValue();
				res = entry.getKey();
			}
		}
		return res;
	}
	
	public int majorityNumberTwo(ArrayList<Integer> nums, int k) {
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
