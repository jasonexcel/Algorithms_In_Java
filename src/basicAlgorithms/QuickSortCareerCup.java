package basicAlgorithms;


public class QuickSortCareerCup {
	
	public static void quickSort(int[] arr) {
		int left = 0;
		int right = arr.length-1;
		quickSort(arr, left, right);
	}
	
	private static void quickSort(int[] arr, int left, int right) {
			int index = partition(arr, left, right);
			if (left < index-1)
				quickSort(arr, left, index-1);
			if (index < right)
				quickSort(arr, index, right);
	}
		
	private static int partition(int[]arr, int left, int right) {
		int pivot = arr[left+(right-left)/2];
		while(left<=right) {
			while(arr[left]<pivot) {
				left++;
			}
			while(arr[right]>pivot) {
				right--;
			}
			if (left<=right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}
		
	public static void main(String[] args) {
		int[] arr = new int[] {7, 3, 9, 6, 5};
		
		quickSort(arr);
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
	
	
	public class Solution {
	    public int removeElement(int[] A, int elem) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int size = A.length;
	        if (size == 0) {
	            return 0;
	        }
	        if (size == 1 && elem == A[0]) {
	            A = null;
	            return 0;
	        }
	        else if (size == 1) {
	            return 1;
	        }
	        int newSize = size;
	        
	        for (int i = 1; i < size; i++) {
	            if(elem == A[i]) {
	                newSize--;
	                
	            }
	            else {
	                A[size-newSize-1] = A[i];
	            }
	        }
	        return newSize;
	    }
	}
}
