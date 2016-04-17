package basicAlgorithms;

import java.util.Arrays;

public class Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 5,1, 3, 2,-1};
		countingSort(arr, -2, 5);
		for(int e : arr) {
			System.out.print(e+ ", ");
		}
	}

/**
 * 
 * @param arr: Array needed to be sorted
 * @param low: lower bound of the possible values
 * @param high: upper bound of the possible values
 */
	public static void countingSort(int[] arr, int low, int high)
	{
		// this will hold all possible values, from low to high
	    int[] counts = new int[high - low + 1]; 
	    for (int x : arr)
	        counts[x - low]++; // - low so the lowest possible value is always 0

	    int current = 0; // current index in a
	    for (int i = 0; i < counts.length; i++)
	    {
	        Arrays.fill(arr, current, current + counts[i], i + low); // fills counts[i] elements of value i + low in current
	        current += counts[i]; // leap forward by counts[i] steps
	    }
	}
}
