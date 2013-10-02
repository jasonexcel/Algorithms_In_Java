package basicAlgorithms;

import java.util.Arrays;
public class SelectionSortingDemo {
	public static void main(String[] args) {
		int[] arr = {7, 30, 20, 8, 6, 21 ,5, 3, 17, 22, 52, 366, 0, 56, 5, 8 };
		
		//selectionSort(arr);
		
		// Use the Java Class Library
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ ",");
					
		}
	}
	
	private static void selectionSort(int[] anArray) {
		for (int i = 0; i < anArray.length; i++) {
			int indexOfSmallest;
			indexOfSmallest = findIndexOfSmallest(i, anArray);
			interchange(i, indexOfSmallest, anArray);
		}
	}
	
	private static int findIndexOfSmallest(int entry, int[] anArray) {
		int minIndex = entry;
		for (int i = entry + 1; i <anArray.length; i++) {
			if (anArray[i] < anArray[minIndex]) {
				minIndex = i;
			}				
		}
		return minIndex;		
	}
	
	private static void interchange(int origin, int smallest, int[] anArray) {
		int temp = anArray[origin];
		anArray[origin] = anArray[smallest];
		anArray[smallest] = temp;
	}
}

