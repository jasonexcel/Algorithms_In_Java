package LeetCode;

/*Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/
public class RemoveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3};
		System.out.println( removeElementII(A, 2));
	}
	

	public static int removeElement(int[] A, int elem) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int cur = 0;

        for(int i=0; i<A.length; i++){
        	if(A[i] != elem){
        		if(i!=cur){
        			A[cur] = A[i];        	
        		}
        	    cur++;
        	}
        }
        return cur;
    }
	
	public static int removeElementII(int[] A, int elem) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int from = 0;
        int to = 0;
        while(from < A.length) {
            if(A[from] == elem) {
                from++;
            }
            else {
                if(to != from) {
                    A[to] = A[from];
                }
                to++;
                from++;
            }
        }
        return to;
    }
}
