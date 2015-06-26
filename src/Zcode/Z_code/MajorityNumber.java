package Zcode.Z_code;

import java.util.HashMap;
import java.util.*;
import java.util.Map;

/**
 * 
 * @author sjia
 * Given an array of Integers, there is exactly one Integer that occurs more than or equals to 1/3 of the size of the array. 
 * For example, [1, 2, 3, 1, 5, 7, 7, 1, 5] will return 1. 
 * Find that Integer. The average time complexity should be O(n) and the space complexity should be O(1).
 *
 */

public class MajorityNumber {
	
	public static void main(String[] args) {
		int[] num = {1,2,3,4,1,2,3,4,1};//{1, 2, 3, 1, 5, 7, 7, 1, 5};
		List<Integer> list = new ArrayList<Integer>();
		for(int e : num) {
			list.add(e);
		}
		System.out.println(majorityNumber(list));
		System.out.println(findMajorityNumber(num));
	}
	
	public static int majorityNumber(List<Integer> nums) {
		if(nums.size() < 3) {
			return -1;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int e : nums) {
			if(map.containsKey(e)) {
				map.put(e,  map.get(e) + 1);
			}
			else if(map.size() < 3) {
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
	
	// quick select 0, n/3, 2*n/3 
	public static int findMajorityNumber(int[] a) {
		if(a.length < 3) {
			return -1;
		}
		int[][] candidacies = new int[3][2];
		candidacies[0][0] = findKthElement(a, 0, a.length - 1, 0);
		candidacies[1][0] = findKthElement(a, 0, a.length - 1, a.length / 3);
		candidacies[2][0] = findKthElement(a, 0, a.length - 1, a.length * 2 /3);
		for(int ele : a) {
			if (ele == candidacies[0][0]) {
				candidacies[0][1]++;
			}
			else if(ele == candidacies[1][0]) {
				candidacies[1][1]++;
			}
			else if(ele == candidacies[2][0]) {
				candidacies[2][1]++;
			}
		}
		int res;
		int count;
		if(candidacies[0][1] < candidacies[1][1]) {
			res = candidacies[1][0];
			count = candidacies[1][1];
		}
		else {
			res = candidacies[0][0];
			count = candidacies[0][1];
		}
		if(candidacies[2][1] < count) {
			return res;
		}
		else return candidacies[2][0];
	}
	// k 0-based
	public static int findKthElement(int[] a, int start, int end, int k) {
		if(a[start] == a[end]) {
			return a[start];
		}
		int pivotalIndex = partition(a, start, end);
		if(pivotalIndex < k) {
			return findKthElement(a, pivotalIndex+1, end, k);
		}
		else if(pivotalIndex > k) {
			return findKthElement(a, start, pivotalIndex-1, k);
		}
		return a[pivotalIndex];
	}
	
	private static int partition(int[] a, int start, int end) {
		int pivotal = a[end];
		int pIndex = start;
		for(int i = start; i<end; i++) {
			if(a[i] < pivotal) {
				if(a[pIndex] != a[i]) {
					int temp = a[i];
					a[i] = a[pIndex];
					a[pIndex] = temp;
				}
				pIndex++;
			}
		}
		int temp = a[end];
		a[end] = a[pIndex];
		a[pIndex] = temp;
		return pIndex;
	}
}
