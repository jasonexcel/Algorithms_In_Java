/**
 * 
 */
package RealInterviewQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author sjia
 *
 */

interface Intervals {
	 
    /**
     * Adds an interval [from, to] into internal structure.
     */
    void addInterval(int from, int to);
 
 
    /**
     * Returns a total length covered by intervals.
     * If several intervals intersect, intersection should be counted only once.
     * Example:
     *
     * addInterval(3, 6)
     * addInterval(8, 9)
     * addInterval(1, 5)
     *
     * getTotalCoveredLength() -> 6
     * i.e. [1,5] and [3,6] intersect and give a total covered interval [1,6]
     * [1,6] and [8,9] don't intersect so total covered length is a sum for both intervals, that is 6.
     *
     *                   _________
     *                                               ___
     *     ____________
     *
     * 0  1    2    3    4    5   6   7    8    9    10
     *
     */
    int getTotalCoveredLength();
}

public class IntervalsCalc implements Intervals {

	List<Point> points;
	/**
	 * @param args
	 */
	public IntervalsCalc(List<Point> Points) {
		if(Points != null) {
			this.points = Points;
		}
		else {
			throw new IllegalArgumentException("error");
		}
	}
	
	@Override
	public void addInterval(int from, int to) {
		this.points.add(new Point(from, to));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Point> points = new ArrayList<Point>();
		IntervalsCalc calc = new IntervalsCalc(points);		
		calc.addInterval(1, 3);
		calc.addInterval(2, 5);
		calc.addInterval(6, 8);
		System.out.println(calc.getTotalCoveredLength());
		
	}
	
	@Override
	public int getTotalCoveredLength() {
		if(this.points == null || points.size() < 1) {
			return 0;
		}
		Comparator<Point> comp = new Comparator<Point>(){
			@Override
			public int compare(Point a, Point b) {
				return a.x - b.x;
			}
		};
		// either Comparable interface with compareTo method or create a Comparator
		//Collections.sort(points, comp);
		Collections.sort(points);
		Point last = points.get(0);
		int total = last.y - last.x;
		for(int i=1; i<points.size(); i++) {
			Point cur = points.get(i);
			if(last.y < cur.x) {
				last = cur;
				total += last.y - last.x;
			}
			else {
				total+=cur.y - last.y;
				last = new Point(last.x, cur.y);
			}
		}
		return total;
	}

}

class Point implements Comparable<Point> {
	int x;
	int y;
	
	public Point(int x, int y) {
		if(y < x) {
			throw new IllegalArgumentException("error");
		}
		else {
			this.x = x;
			this.y = y;
		}
	}
	@Override
	public int compareTo(Point secondP) {
		if(secondP != null) {
			return this.x - secondP.x;
		}
		else {
			throw new IllegalArgumentException("error");
		}
	}
}
