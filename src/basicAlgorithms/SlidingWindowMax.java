package basicAlgorithms;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {
	/*  
	  * Given an array of numbers and a sliding window, find out the maximal  
	  * number within the window as its moving.  
	  * @param nums the array of numbers.  
	  * @param window the size of the sliding window.  
	  * @return an array of window maximals, i.e. B[i] is the maximal of A[i, i+w).  
	  */  
	public static void main(String[] args) {
		SlidingWindowMax ins = new SlidingWindowMax();
		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		int window = 1;
		int[] max = ins.windowMax(nums, window);
		for(int e : max) {
			System.out.print(e+ " ");
		}
	}
	
	
	 public int[] windowMax(int[] nums, int window) {  
	   int w = (nums.length < window) ? nums.length : window;  
	   // A deque allows insertion/deletion on both ends.  
	   // Maintain the first as the index of maximal of the window  
	   // and elements after it are all smaller and came later than the first.  
	   Deque<Integer> que = new ArrayDeque<Integer>();  
	   
	   // initialize window  
	   int i=0;  
	   while (i<w) {  
	     while (!que.isEmpty() && nums[que.getLast()] <= nums[i]) {  
	       que.removeLast();  
	     }  
	     que.addLast(i); 
	     i++;
	   }  
	   
	   // sliding window  
	   int[] max = new int[nums.length - w + 1];  
	   //max[i-w] = nums[que.getFirst()];  
	   max[0] = nums[que.getFirst()];  
	   while (i<nums.length) {  
	     // add new element  
	     while (!que.isEmpty() && nums[que.getLast()] <= nums[i]) {  
	       que.removeLast();  
	     }  
	     que.addLast(i);  
	     // remove old element if still in que  
	     if (!que.isEmpty() && i-w >= que.getFirst()) {  
	       que.removeFirst();  
	     }  
	     // get maximal  
	     ++i;  
	     max[i-w] = nums[que.getFirst()];  
	   }  
	   
	   return max;  
	 } 
}
