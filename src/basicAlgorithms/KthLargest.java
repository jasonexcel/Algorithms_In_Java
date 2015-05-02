package basicAlgorithms;
// implement quick sort method to get partition
// O(N) time, stack space
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
		int res = start;
		int pivotal = arr[end];
		for(int i=start; i<end; i++) {
			if(arr[i] < pivotal) {
				int temp = arr[i];
				arr[i] = arr[res];
				arr[res] = temp;
				res++;
			}
		}
		// !!! swap the pivotal(last element) with the partition point result
		if(res != end) {
			arr[end] = arr[res];
			arr[res] = pivotal;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[] {7,3,9,6,5,34,12};
		int k = 5;
		int index = arr.length - k;
		sort(arr, 0, arr.length-1, index);
		System.out.println(k + "th largest = " + arr[index]);
	}
}
