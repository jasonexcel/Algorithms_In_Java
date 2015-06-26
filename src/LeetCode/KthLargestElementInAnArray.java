package LeetCode;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

	/**
	 * @param args
	 * 
	 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 1};
		int k = 1;
		KthLargestElementInAnArray ins = new KthLargestElementInAnArray();
		System.out.println(ins.findKthLargest(arr, k));
	}
	 public int findKthLargest(int[] nums, int k) {
	        if(nums == null || nums.length == 0) {
	            return -1;
	        }
	     	int targetIndex = nums.length - k;
	     	return quickSelect(nums, 0, nums.length-1, targetIndex);
	    }

	 private int quickSelect(int[] nums, int left, int right, int targetIndex) {
	    	if(left == right) {
	    		return nums[left];
	    	}
	    	else {
	    		int pivotal = nums[right];
	    		int partition = left;
	    		for(int i=left; i<right; i++) {
	    			if(nums[i] < pivotal) {
	    				int temp = nums[partition];
	    				nums[partition] = nums[i];
	    				nums[i] = temp;
	    				partition++;
	    			}
	    		}
	    		int temp = nums[partition];
	    		nums[partition] = nums[right];
	    		nums[right] = temp;
	    		if(targetIndex == partition) {
	    			return nums[partition];
	    		}
	    		else if(targetIndex < partition) {
	    			return quickSelect(nums, left, partition-1, targetIndex);
	    		}
	    		else {
	    			return quickSelect(nums, partition+1, right, targetIndex);
	    		}
	    	}
	    }
	 // time: nlogn, space: o(k)
	 public int findKthLargestByHeapSizeK(int[] nums, int k) {
	      if(nums == null || nums.length == 0) {
		            return -1;
		     }
			 PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
			 for(int elem : nums) {
				 if(minHeap.size() == k) {
				     if(minHeap.peek() < elem) {
				         minHeap.poll();
				         minHeap.offer(elem);
				     }
				 }
				 else{
				     minHeap.offer(elem);
				 }
			 }
			 return minHeap.peek();
	    }
	 
	 public int findKthLargestByHeap(int[] nums, int k) {
		 if(nums == null || nums.length == 0) {
	            return -1;
	     }
		 PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k+1);
		 for(int elem : nums) {
			 minHeap.offer(elem);
			 if(minHeap.size() > k) {
				 minHeap.poll();
			 }			 
		 }
		 return minHeap.peek();
	 }
}
