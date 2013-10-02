package basicAlgorithms;
// implement quick sort method to get partition
public class KthLargest {
	public static void sort(int[] arr, int start, int end, int index) {
		assert(end > start);
		assert(end > index);

		int p = partition(arr, start, end);
		if (p < index)
			sort(arr, p+1, end, index);
		else if (p > index)
			sort(arr, 0, p-1, index);
		else return;
	}
	
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start;
		int j = start;
		while (j< end) {
			if(arr[j]<pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++; 
				j++;
			}
			else j++;
		}
		int temp = arr[i];
		arr[i] = arr[end];
		arr[end] = temp;
		return i;	
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {7,3,9,6,5,12,34};
		int k = 1;
		int index = arr.length - k;
		sort(arr, 0, arr.length-1, index);
		System.out.println(k + "th largest = " + arr[index]);
	}
}
