package LeetCode;

public class RemoveDuplicatesFromSortedArray_Type_II {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int cur = 0;
        boolean twice = false;
        if(A.length < 2) {
        	return A.length;
        }
        for(int i = 1; i<A.length; i++){
        	if(A[i] != A[cur]){
        		A[++cur] = A[i];
        		// reset the flat to false
        		twice = false;
        	}
        	// repeatition
        	else if(!twice){
        		// got two same values, set the flag to true
        		twice = true;
        		// !!! 
        		A[++cur] = A[i];
        	}
        }
        return cur+1;
    }
}
