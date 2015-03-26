/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */
package LeetCode;

public class SortColors {

	/**
	 * Time: o(n); space: o(1)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortColors ins = new SortColors();
		int[] A = {1,2};
		ins.sortColors(A);
		//System.out.print(A);
	}
    public void sortColors(int[] A) {
        if(A == null || A.length == 0){
        	return;
        }
        //leftP points to where 0 should be filled, rightP points to where 2 should be filled
        int leftP = 0, rightP = A.length-1;
        int i = 0;
        while(i <= rightP){
        	if(A[i] == 0){
        		//swap A[i] with A[leftP]
        		A[i] = A[leftP]; //A[leftP] must be 1
        		A[leftP] = 0;
        		leftP++;
        		i++; //!!!since A[i] = 1, so go to next one
        	}
        	else if(A[i] == 2){  
        		//swap A[i] with A[rightP]
        		A[i] = A[rightP];
        		A[rightP] = 2;
    			rightP--; 
    			//since A[rightP] can be any value, don't move i
        	}
        	else{
            	i++;
        	}
        }
        return;
    }

    public void sortColorsCountingSort(int[] A) {
        if(A==null || A.length==0)
            return;
        int[] res = new int[A.length];
        int[] helper = new int[3];
        for(int i=0;i<A.length;i++)
        {
            helper[A[i]]++;
        }
        for(int i=1;i<3;i++)
        {
            helper[i]=helper[i]+helper[i-1];
        }
        for(int i=A.length-1;i>=0;i--)
        {
            res[helper[A[i]]-1] = A[i];
            helper[A[i]]--;
        }
        for(int i=0;i<A.length;i++)
        {
            A[i] = res[i];
        }
    }
}
