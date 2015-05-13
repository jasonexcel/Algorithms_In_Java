package basicAlgorithms;

/**
 * quickselect is a selection algorithm to find the kth smallest element
 *  in an unordered list. It is related to the quicksort sorting algorithm
 *  
 *  Worst case performance	O(n^2)
Best case performance	O(n)
Average case performance	O(n)
 * @author sjia
 *
 */
public class FindKthSmallestByQuickSelect {
	public static void main(String []args){
	      int a[]={2,20,3,7,9,1,17,18,0,14};
	      int k=5;
	      System.out.println(findKthElement(a, 0, a.length-1, k-1));
	      
	   }
	
	public static int findKthElement(int[] a, int start, int end, int k) {
		if(a[start] == a[end]) {
			return a[start];
		}
		int pivotalIndex = partition(a, start, end);
		if(pivotalIndex < k) {
			return findKthElement(a, pivotalIndex+1, end, k);
		}
		else if(pivotalIndex > k) {
			return findKthElement(a, start, pivotalIndex-1, k);
		}
		return a[pivotalIndex];
	}
	
	private static int partition(int[] a, int start, int end) {
		int pivotal = a[end];
		int pIndex = start;
		for(int i = start; i<end; i++) {
			if(a[i] < pivotal) {
				if(a[pIndex] != a[i]) {
					int temp = a[i];
					a[i] = a[pIndex];
					a[pIndex] = temp;
				}
				pIndex++;
			}
		}
		int temp = a[end];
		a[end] = a[pIndex];
		a[pIndex] = temp;
		return pIndex;
	}
}
