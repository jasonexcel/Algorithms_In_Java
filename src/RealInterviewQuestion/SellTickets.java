package RealInterviewQuestion;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SellTickets {

	/**
	 * @param args
	 * http://107.23.37.111/article_t1/JobHunting/32952623_0_1.html
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// time-O(nlogn), space - O(n)
	public int maxProfit(int[] stations, int demand) {
		if(stations == null || stations.length == 0 || demand < 1) {
			throw new IllegalArgumentException("error");
		}
		Comparator<Integer> comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}

		};
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, comp);
		int total = 0;
		for(int ele : stations) {
			maxHeap.offer(ele);
			total += ele;
		}
		if(total < demand) {
			throw new IllegalArgumentException("error");
		}
		int cur = maxHeap.poll();
		int max = 0;
		while(demand > 0 && maxHeap.size() > 0) {
			int next = maxHeap.peek();
			if(next <= cur) {
				max += cur;
				cur--;
				demand--;
			}
			else {
				int temp = cur;
				cur = maxHeap.poll();
				max += cur;
				cur--;
				demand--;
				maxHeap.offer(temp);
			}
		}
		if(demand != 0) {
			throw new IllegalArgumentException("error");
		}
		return max;
	}
}
