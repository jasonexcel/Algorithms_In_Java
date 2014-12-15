package basicAlgorithms;

import java.util.Arrays;

public class MergeSort {
	/** The method for sorting the numbers */
	public static void mergeSort(int[] list) {
		if (list.length > 1) {
			
			// Merge sort the first half
			int[] firstHalf = new int[list.length / 2];
			// arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 
	        System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
	        mergeSort(firstHalf);
	        
	        // Merge sort the second half
	        int secondHalfLength = list.length - list.length / 2;
	        int[] secondHalf = new int[secondHalfLength];
	        System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
	        mergeSort(secondHalf);
	        
	        // Merge firstHalf with secondHalf
	        int[] temp = merge(firstHalf, secondHalf);
	        System.arraycopy(temp, 0, list, 0, temp.length); 
		}
    }
	
	/** Merge two sorted lists */
	private static int[] merge(int[] list1, int[] list2) {
		int[] temp = new int[list1.length + list2.length];
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp
			
		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else temp[current3++] = list2[current2++];
		} 
		while (current1 < list1.length)
			temp[current3++] = list1[current1++];
		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
		return temp;
	}
	//better detail to handle divide and conque
	private void recMergeSort(int[] list, int lBound, int rBound){
		if(lBound>=rBound){
			return;
		}
		else{
			int mid = lBound + (rBound - lBound)/2;
			recMergeSort(list, lBound, mid);
			recMergeSort(list, mid+1, rBound);
			merge(list, lBound, mid+1, rBound);
		}
	}
	
	private void merge(int[] list, int lBound, int rStart, int rBound) {
		int[] temp = new int[rBound-lBound+1];
		int current1 = lBound; // Current index in list1
		int current2 = rStart; // Current index in list2
		int current3 = 0; // Current index in temp
			
		while (current1 < rStart && current2 <=rBound) {
			if (list[current1] < list[current2])
				temp[current3++] = list[current1++];
			else temp[current3++] = list[current2++];
		} 
		while (current1 < rStart)
			temp[current3++] = list[current1++];
		while (current2 <= rBound)
			temp[current3++] = list[current2++];
		System.arraycopy(temp, 0, list, lBound, temp.length);
	}
	
	/** A test method */
	public static void main(String[] args) {	
		
		int[] list = {3, 1, 2, 5, 6, 1, -2, -8, 14, 12, 8, 3, -5};
		//mergeSort(list);
		MergeSort ins = new MergeSort();
		ins.recMergeSort(list, 0, list.length-1);
		for (int i = 0; i < list.length; i++)
		System.out.print(list[i] + ", ");
	 }
}
