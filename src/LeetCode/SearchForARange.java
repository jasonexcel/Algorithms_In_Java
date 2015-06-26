/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
package LeetCode;

/**
 * 
 *
 */
public class SearchForARange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchForARange ins = new SearchForARange();
		int[] A = {2, 2};
		int target = 2;
		int[] res = ins.searchRange(A, target);
		System.out.println(Integer.toString(res[0]) + "-" + Integer.toString(res[1]));
	}
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1, -1};
        if(A == null || A.length == 0){
        	return res;
        }
        //search for left bound
        searchLeft(A, target, 0, A.length-1, res);
        //no target found, return res
        if(res[0] == -1){
        	return res;
        }
        //search for right bound
        searchRight(A, target, 0, A.length-1, res);
        return res;
    }
    
    private void searchLeft(int[] arr, int target, int start, int end, int[] res){
    	if(start > end || target < arr[start] || target > arr[end]){
    		return;
    	}
    	int mid = start + (end - start)/2;
    	if(arr[mid] == target){
    		res[0] = mid; //assign the value first
    	}
    	//!!!even if values are equal, still find it in the left partition
    	if(arr[mid] >= target){
    		searchLeft(arr, target, start, mid-1, res);
    	}
    	else{
    		searchLeft(arr, target, mid+1, end, res);
    	}
    }
    
    private void searchRight(int[] arr, int target, int start, int end, int[] res){
    	if(start > end || target < arr[start] || target > arr[end]){
    		return;
    	}
    	int mid = start + (end - start)/2;
    	if(arr[mid] == target){
    		res[1] = mid;
    	}
    	if(arr[mid] > target){
    		searchRight(arr, target, start, mid-1, res);
    	}
    	//even if values are equal, still find it in the right partition
    	else{
    		searchRight(arr, target, mid+1, end, res);
    	}
    }
    
    //http://blog.csdn.net/linhuanmars/article/details/20593391
    public int[] searchRangeIterative(int[] A, int target) {
        int[] res = {-1,-1};
        if(A==null || A.length==0)
        {
            return res;
        }
        int ll = 0; // final left index
        int lr = A.length-1; // assistance index
        while(ll<=lr)
        {
            int m = (ll+lr)/2;
            if(A[m]<target)
            {
                ll = m+1;
            }
            else
            {
                lr = m-1;
            }
        }
        int rl = 0;
        int rr = A.length-1;
        while(rl<=rr)
        {
            int m = (rl+rr)/2;
            if(A[m]<=target)
            {
                rl = m+1;
            }
            else
            {
                rr = m-1;
            }
        }
        //!!! if there is value, ll shouldn't be greater than rr
        if(ll<=rr)
        {
            res[0] = ll;
            res[1] = rr;
        }
        return res;
    }
}
