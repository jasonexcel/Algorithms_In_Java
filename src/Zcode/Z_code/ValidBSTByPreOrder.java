package Zcode.Z_code;

import java.util.*;
public class ValidBSTByPreOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 12, 7, 16, 25};
		//List<Integer> minMax = new ArrayList<Integer>();
		ValidBSTByPreOrder ins = new ValidBSTByPreOrder();
		if(ins.isValidPreorder(arr)) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		if(ins.isPreOrderBST(arr)) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
	// my solution
	public boolean isValidPreorder(int[] arr) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		int[] index = {0};
		validationByPreorder(arr, index, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
		return index[0] == arr.length;
	}
	
	private void validationByPreorder(int[] arr, int[] index, long min, long max) {
		if(index[0] == arr.length){
			return;
		}
		int curVal = arr[index[0]];
		if(curVal > min && curVal < max) {
			index[0]++;
			validationByPreorder(arr, index, min, curVal);
			validationByPreorder(arr, index, curVal, max);
		}
	}
	
	//
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
