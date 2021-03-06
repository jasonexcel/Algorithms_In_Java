/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * You may assume that A has enough space (size that is greater or equal to m + n) 
 * to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 */
package LeetCode;

public class MergeSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//my solution
	// starting from the end
    public void merge(int A[], int m, int B[], int n) {
        if(A == null || B == null || B.length == 0) {
            return;
        }
        int a = m-1, b = n-1;
        while(a>=0 && b>=0) {
            if(A[a] > B[b]) {
                A[a+b+1] = A[a];
                a--;
            }
            else {
                A[a+b+1] = B[b];
                b--;
            }
        }
        while(b>=0) {
            A[b] = B[b];
            b--;
        }
        return;
    }
    
	 public void mergeII(int A[], int m, int B[], int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        while(n>0){
	        	//A is all copied, copy B to the head of A
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
