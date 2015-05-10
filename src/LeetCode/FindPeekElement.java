/**
 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
package LeetCode;

public class FindPeekElement {
	// O(logN), binary search
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            // mid + 1 is acceptable
            if(nums[mid] < nums[mid+1]) {
            	// continue search in the right part
                left = mid+1;
            }
            else {
            	// search in the left part
                right = mid;
            }
        }
        return left;
    }
    // O(N)
    public int findPeakElementON(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return -1;
        }
        if(nums.length == 1) {
        	return 0;
        }
        for(int i=0; i<nums.length; i++) {
        	if(i == 0 && nums[i] > nums[i+1]) {
        		return 0;
        	}
        	if(i == nums.length-1 && nums[i-1] < nums[i]) {
        		return i;
        	}
        	if(i != 0 && i!= nums.length -1 && nums[i-1] < nums[i] && nums[i] > nums[i+1]) {
        		return i;
        	}
        }
        return -1;
    }
}
