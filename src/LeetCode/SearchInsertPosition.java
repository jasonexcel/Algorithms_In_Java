/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */

package LeetCode;

public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] A = {1,3};
		System.out.println( searchInsert(A, 2));
	}
	public static int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int a = 0, b = A.length -1;
        while(a<=b) {
            int mid = (a+b)/2;
            //int mid = a + (b - a)/2;
            if(A[mid] > target) {
                b = mid-1;
                continue;
            }
            else if(A[mid] < target) {
                a = mid+1;
                continue;
            }
            else{
                return mid;
            }
        }
        // not found
        // a is at the position with value just larger than the target
        // b is at the position with value just less than the target
        return a;//!!!
    }
	
	public int searchInsertRecursively(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
     	int len = A.length;
     	return searchInsertRange(A, target, 0, len-1);

    }

    private int searchInsertRange(int[] A, int target, int start, int end){
    	if(start==end){
            if(A[start] < target){
    			return start + 1;
    		}
    		else{
    			return start;
    		}
    	}
    	int mid = start/2 + end/2;
    	if(A[mid] == target){
    		return mid;
    	}
    	else if(A[mid] < target){    		
    		return searchInsertRange(A, target, mid+1, end);//minimize the range to avoid dead cycle
    	}
    	else{
    		return searchInsertRange(A, target, start, mid);
    	}
    }
	

}
