package basicAlgorithms;

public class AlgoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {5,3,1};
		quickSort(a, 0, a.length-1);
		System.out.println(a);
	}
	public static void quickSort(int[] arr, int s, int e){
		if(s>=e) return;
		int pivot = e;
		pivot = partitionArray(arr, s, e);
		quickSort(arr, s, pivot-1);
		quickSort(arr, pivot+1, e);
	}
	private static int partitionArray(int[] arr, int start, int end){
		int i = start, cur = start;
		while(cur<=end){
			if(arr[cur]<arr[end]){
				int temp = arr[i];
				arr[i] = arr[cur];
				arr[cur] = temp;
				i++;
				cur++;
			}
			cur++;
		}
		int temp = arr[end];
		arr[end] = arr[i];
		arr[i] = temp;
		return i;
	}
}
