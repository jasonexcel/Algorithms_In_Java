/**
 * Given a list of tuples representing intervals, return the range these intervals 
covered. 
e.g: 
[(1,3), (2,5),(8,9)] should return 5

 */
package RealInterviewQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindRange {

	public FindRange() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Interval {
		int start;
		int end;
	}
	public static int findRange(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start > o2.start) {
					return 1;
				} else if (o1.start > o2.start) {
					return -1;
				} else if (o1.end > o2.end){
					return 1;
				} else if (o1.end > o2.end) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		int range = 0;
		int s = 0;
		int i = 0;
		while (i < intervals.size()) {
			int j = i + 1;
			int e = intervals.get(i).end;
			while (j < intervals.size() && e >= intervals.get(j).start) {
				e = Math.max(e, intervals.get(j).end);
				j++;
				
			}
			range += e - intervals.get(s).start;
			i = j;
			s = j;
		}
		return range;
	}
}
