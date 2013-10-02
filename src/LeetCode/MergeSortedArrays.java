package LeetCode;

public class MergeSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public void merge(int A[], int m, int B[], int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        while(n>0){
	            if(m == 0){
	                A[n-1] = B[n-1];
	                n--;
	                continue;
	            }
	            if(A[m-1]>B[n-1]){
	                A[m+n-1] = A[m-1];
	                m--;
	            }
	            else{
	                A[m+n-1] = B[n-1];
	                n--;
	            }
	        }
	        return;
	    }
}
