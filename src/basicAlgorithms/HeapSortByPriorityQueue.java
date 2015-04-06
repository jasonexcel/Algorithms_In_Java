package basicAlgorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSortByPriorityQueue {

	public HeapSortByPriorityQueue() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,4, 7, 2, 5, -3, 10, 0, 5, 72, 1};
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int element : arr) {
			minHeap.offer(element);
		}
		int[] sorted1 = new int[arr.length];
		for(int i=0; i<sorted1.length; i++) {
			sorted1[i] = minHeap.poll();
			System.out.print(" " + sorted1[i]);
		}
		System.out.println();
		Comparator<Integer> comp = new Comparator<Integer>(){
			@Override
			public int compare(Integer a1, Integer a2){
				// return the negative of the (a1 - a2)
				return -(a1 - a2);
			}
		};
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, comp);
		for(int element : arr) {
			maxHeap.offer(element);
		}
		int[] reversed1 = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			System.out.print(" " + maxHeap.peek());
			reversed1[i] = maxHeap.poll();
		}
		
	}
	
	
}
