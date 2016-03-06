package basicAlgorithms;

/**
 * 
 * @author Shaun
 *Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class WiggleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 2, 1, 5, 4, 9, 0, 3};
		new WiggleSort().sort(arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	public void sort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		for(int i = 0; i < arr.length - 1; i++) {
			if( i % 2 == 0) {
				if(arr[i] > arr[i+1]) {
					swap(i, i+1, arr);
				}
			} else {
				if(arr[i] < arr[i+1]) {
					swap(i, i+1, arr);
				}
			}
		}
	}
	
	private void swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;		
	}
}
