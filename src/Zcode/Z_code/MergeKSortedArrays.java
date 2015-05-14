/**
 * 
 */
package Zcode.Z_code;

/**
 * @author sjia
 *
 */
public class MergeKSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1, 2,3}, {3, 5}, {1, 4, 6}, {2,3,5, 7}};
		int[] res = new MergeKSortedArrays().sortArrays(arr);
		for(int e : res) {
			System.out.print(e + ",");
		}
	}
	public int[] sortArrays(int[][] arr) {
		if(arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
			throw new IllegalArgumentException();
		}
		int[] res = new int[arr[0].length * arr.length];
		res = sortArraysHelper(arr, 0, arr.length-1);
		return res;
	}
	
	private int[] sortArraysHelper(int[][] arr, int start, int end) {
		if(start == end) {
			return arr[start];
		}
		int mid = (start + end) / 2;
		int[] left = sortArraysHelper(arr, start, mid);
		int[] right = sortArraysHelper(arr, mid+1, end);
		return mergeTwoArrays(left, right);		
	}
	
	private int[] mergeTwoArrays(int[] left, int[] right) {
		int lIndex = 0;
		int rIndex = 0;
		int[] merged = new int[left.length + right.length];
		while(lIndex < left.length && rIndex < right.length) {
			if(left[lIndex] > right[rIndex]) {
				merged[lIndex+rIndex] = right[rIndex];
				rIndex++;
			}
			else {
				merged[lIndex+rIndex] = left[lIndex];
				lIndex++;
			}
		}
		while(lIndex < left.length) {
			merged[lIndex+rIndex] = left[lIndex];
			lIndex++;
		}
		while(rIndex < right.length) {
			merged[lIndex+rIndex] = right[rIndex];
			rIndex++;
		}
		return merged;
	}
}
