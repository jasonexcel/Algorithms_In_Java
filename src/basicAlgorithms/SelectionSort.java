package basicAlgorithms;

import java.util.Scanner;

public class SelectionSort implements Comparable{

	public static void main(String[] args) {
		/*
		Scanner input = new Scanner(System.in);
		System.out.println("input number: ");
		int n = input.nextInt();
		int[] arr = new int[n];
		
		int index;
		for (int i=0; i<n; i++) {
			index = i + 1;
			System.out.println("input data no. " + index);
			arr[i] = input.nextInt();
		}
		*/
		Comparable[] arr = {5, 7, 3, 2, 10};
		sort(arr);
		//SelectionSort2.sort(arr);
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
	
	public static void sort(Comparable[] array) {
		int index = 0; 
		for (int i=index++; i<array.length-1; i++) {
			int low = i;
			for (int j=i+1; j<array.length; j++) {
				if (array[j].compareTo(array[low])<0) 
					low = j;
			}
			Comparable temp = array[i];
			array[i] = array[low];
			array[low] = temp;
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
		