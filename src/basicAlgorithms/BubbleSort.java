package basicAlgorithms;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.println("Input the number of data in tha array: ");
	int n = input.nextInt();
	int[] arr = new int[n];
	for ( int i=0; i<n; i++ ) {
		int index = i + 1;
		System.out.println("Input No. " + index + "data");
		arr[i] = input.nextInt();
	}
	sort(arr);
	for ( int i=0; i<n; i++) {
		System.out.print(arr[i] + ", ");
	}  
	
	}
	
	public static void sort(int[] array) {
		for ( int i=0; i<array.length; i++) {
			for ( int j=0; j<array.length-i-1; j++) {
				if (array[j]>array[j+1])
					swap(array, j, j+1);
			}
		}
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}