
package RealInterviewQuestion;

import java.util.*;
public class SortByDictionary {
	public static void main(String[] args) {
		int[] order = {8, 3, 2, 7, 5, 1, 6};
		Integer[] input = {3, 6, 8}; // java cannot sort int[]
		final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<order.length; i++) {
			map.put(order[i], i);
		}
		final Comparator<Integer> comp = new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return map.get(a) - map.get(b);
			}
		};
		Arrays.sort(input, comp);
		for(int elem : input) {
			System.out.println(elem);
		}
	}
}
