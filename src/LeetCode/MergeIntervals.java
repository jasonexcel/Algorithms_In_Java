/**
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Shaun
 * O(NlogN) time, O(1) space
 * 
 */
public class MergeIntervals {

	/**
	 * @param args
	 */

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

	public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0){
        	return intervals;
        }
        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
        	@Override
        	public int compare(Interval a, Interval b){
        		return a.start - b.start;
        	}
        });
        int pos = 0;
        res.add(intervals.get(0));
        for(int i=1; i<intervals.size(); i++){
        	Interval cur = res.get(pos);
        	Interval temp = intervals.get(i);
        	if(cur.end >= temp.start){
        		if(cur.end < temp.end){
        			cur.end = temp.end;
        		}
        	}
        	else{
        		res.add(temp);
        		pos++;
        	}
        }
        return res;        
    }
	
	//method 2, only difference is the way of implementing comparator
	public List<Interval> mergeII(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0){
        	return intervals;
        }
        List<Interval> res = new ArrayList<Interval>();
        Comparator<Interval> comp = new Comparator<Interval>() {
        	@Override
        	public int compare(Interval a, Interval b){
        		return a.start - b.start;
        	}
        };
        Collections.sort(intervals, comp);
        int pos = 0;
        res.add(intervals.get(0));
        for(int i=1; i<intervals.size(); i++){
        	Interval cur = res.get(pos);
        	Interval temp = intervals.get(i);
        	if(cur.end >= temp.start){
        		if(cur.end < temp.end){
        			cur.end = temp.end;
        		}
        	}
        	else{
        		res.add(temp);
        		pos++;
        	}
        }
        return res;        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
