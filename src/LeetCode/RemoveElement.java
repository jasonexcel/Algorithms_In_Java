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
		int[] A = {};
		System.out.println( removeElement(A, 2));
	}
	

	    public static int removeElement(int[] A, int elem) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	    	 int size = A.length;
	         int j = 0;
	     for (int i = 0; i < size; i++)
	     {
	         if (A[i] != elem)
	         {

	             A[j]=A[i]; 
	                         j++;
	         }
	     }
	     return j;
	     }


}
