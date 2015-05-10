package Zcode.Z_code;

import java.util.*;
public class ValidBSTByPreOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3};
		//List<Integer> minMax = new ArrayList<Integer>();
		
		if(helper(arr, 0, arr.length-1)) {
			System.out.println("Yes");
		}
	}
	// preferred
	int pos;
	public boolean isPreOrderBST(int[] array) {
	    if (array == null || array.length == 0) {
	            return false;
	    }
	    pos = 0;
	    findPreOrder(array, array[0],Integer.MIN_VALUE, Integer.MAX_VALUE);
	    return pos == array.length;
	}

	private void findPreOrder(int[] array, int key, int min, int max) {
	    if (pos == array.length) {
	            return;
	    }
	    if (key > min && key < max) {
	        pos++;
	        if (pos < array.length) {
	            findPreOrder(array, array[pos], min, key);
	            findPreOrder(array, array[pos], key, max);
	        }
	    }

	}
	
	
	// O(N^2) time
	private static boolean helper(int[] arr, int s, int e) {
		if(s > e) {
			return true;
		}
		if(e >= arr.length) {
			return true;
		}
		int rVal = arr[s];
		int leftE;
		int i;
		for(i=s+1; i<=e; i++) {
			if(rVal < arr[i]) {				
				break;
			}
		}
		leftE = i-1;
		for(int j = leftE+1; j<=e; j++) {
			if(rVal > arr[j]) {
				return false;
			}
		}
		return helper(arr, s+1, leftE) && helper(arr, leftE+1, s);
		
	}
}
