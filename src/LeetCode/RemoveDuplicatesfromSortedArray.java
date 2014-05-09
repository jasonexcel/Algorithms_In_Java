package LeetCode;

public class RemoveDuplicatesfromSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
    	if(A.length <= 1) 
    		return A.length;
        int cur = 0;
        for(int i=1; i<A.length; i++){
        	if(A[i]!=A[cur]){
        		A[++cur] = A[i];        		
        	}
        }

        return cur+1;
    }
}
