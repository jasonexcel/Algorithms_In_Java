/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	// Definition for an interval.
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			res.add(newInterval);
			return res;
		}
		int i = 0;
		// first part until the prev interval of the newInterval' start
		// the current interval' end must be less than the start of newInterval
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			res.add(intervals.get(i));
			i++;
		}
		if (i < intervals.size()) {
			// find the next interval's start
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
		}
		
		// find the next interval's end
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			i++;
		}
		res.add(newInterval);
		while (i < intervals.size()) {
			res.add(intervals.get(i));
			i++;
		}
		return res;
	}

	// my bad solution
	public List<Interval> insertX(List<Interval> intervals, Interval newInterval) {
		if (newInterval == null) {
			return intervals;
		}
		if (intervals == null) {
			intervals.add(newInterval);
			return intervals;
		}
		int[] arr = new int[intervals.size() * 2];
		for (int i = 0; i < intervals.size(); i++) {
			arr[2 * i] = intervals.get(i).start;
			arr[2 * i + 1] = intervals.get(i).end;
		}
		int posS = binarySearch(arr, newInterval.start, 0, arr.length - 1);

		int posE = binarySearch(arr, newInterval.end, posS, arr.length - 1);
		List<Interval> res = new ArrayList<Interval>();

		if (posS % 2 == 0) {
			for (int i = 0; i < posS / 2; i++) {
				res.add(intervals.get(i));
			}
			if (posE == posS) {
				res.add(newInterval);
				for (int i = posS / 2; i < intervals.size(); i++) {
					res.add(intervals.get(i));
				}
			} else if (posE % 2 == 0) {
				if (newInterval.end == intervals.get(posE / 2).start) {
					Interval temp = new Interval(newInterval.start,
							intervals.get(posE / 2).end);
					res.add(temp);
					for (int i = posE / 2 + 1; i < intervals.size(); i++) {
						res.add(intervals.get(i));
					}
				} else {
					res.add(newInterval);
					for (int i = posE / 2; i < intervals.size(); i++) {
						res.add(intervals.get(i));
					}
				}
			} else {
				Interval temp = new Interval(newInterval.start,
						intervals.get(posE / 2).end);
				res.add(temp);
				for (int i = posE / 2 + 1; i < intervals.size(); i++) {
					res.add(intervals.get(i));
				}
			}
		} else {
			for (int i = 0; i < posS / 2; i++) {
				res.add(intervals.get(i));
			}
			int start = intervals.get(posS / 2).start;
			int end;
			if (posE % 2 == 1) {
				end = intervals.get(posE / 2).end;
				Interval temp = new Interval(start, end);
				res.add(temp);

			} else {
				if (newInterval.end == intervals.get(posE / 2).start) {
					end = intervals.get(posE / 2).end;
					res.add(new Interval(start, end));
				} else {
					end = newInterval.end;
					res.add(new Interval(start, end));
					res.add(intervals.get(posE / 2));
				}
			}
			for (int i = posE / 2 + 1; i < intervals.size(); i++) {
				res.add(intervals.get(i));
			}
		}
		return res;
	}

	private int binarySearch(int[] intervals, int ins, int sIndex, int eIndex) {
		int st = sIndex, en = eIndex;
		while (st <= en) {
			int mid = st + (en - st) / 2;
			if (intervals[mid] == ins) {
				return mid;
			} else if (intervals[mid] < ins) {
				st = mid + 1;
			} else {
				en = mid - 1;
			}
		}
		return en + 1;
	}

}
