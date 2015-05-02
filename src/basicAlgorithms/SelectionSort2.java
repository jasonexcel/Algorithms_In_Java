package basicAlgorithms;


// Standard Selection Sort
public class SelectionSort2 {
	public static void main(String[] args) {
		int[] unsortedArray = { 3, 5, 1, -5, 6 , 2, 9, 7, 3};
		sort(unsortedArray);
		
		for (int e:unsortedArray) {
			System.out.print(e + ",");
		}
	}
	
	public static void sort(int[] array) {
		int length = array.length;
		for (int i = 0; i < length-1; i++) {
			int currentMinIndex = i;
			for (int j = i+1; j < length; j++) {
				if (array[j] < array[currentMinIndex]) {
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i) {
				int temp = array[i];
				array[i] = array[currentMinIndex];
				array[currentMinIndex] = temp;
			}
		}
	}
	}
