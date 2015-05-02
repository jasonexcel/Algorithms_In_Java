package basicAlgorithms;

//on average, the algorithm takes O(n log n) comparisons to sort n items.
//In the worst case, it makes O(n2) comparisons, though this behavior is rare.
public class QuickSort {
	
	public static void quickSort(int[] list) {
     quickSort(list, 0, list.length - 1);
	}

	private static void quickSort(int arr[], int first, int last) {
		if (first >= last) return;		
		int pivot = partition(arr, first, last);
		quickSort(arr, first, pivot-1);
		quickSort(arr, pivot+1, last);
	}
	
	public static int partition(int arr[], int first, int last) {
		assert(first< last);
		int pivot = arr[last];
		int i = first; // i - keeper, keep the position where new and less then pivot value should be placed 
		int j = first; // j - runner
		while (j<last) {
			if (arr[j]<pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				//i move to next value which is not less than flag 
				i++;
				j++;
			}
			else j++;
		}
		int temp = arr[i];
		arr[i] = arr[last];
		arr[last] = temp;
		return i;	
	}
	
	/** A test method */
	public static void main(String[] args) {
	int[] list = {7,3,9,6, -2, 58};
	    quickSort(list);
	for (int i = 0; i < list.length; i++)
	      System.out.print(list[i] + " ");
	  }
}
			
			