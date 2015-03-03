/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
package LeetCode;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        HashSet<Integer> s = new HashSet<Integer>();
        for(int val : num){
        	if(!s.contains(val)){
        		s.add(val);
        	}        	
        }
        int max = 0;
        for (int val : num) {
        	if(s.contains(val)){
        		int count = 1;
        		s.remove(val);
        		int i = 1;
        		while(s.contains(val + i)){
        			count++;
        			s.remove(val + i);
        			i++;
        		}
        		i = 1;
        		while(s.contains(val - i)){
        			count++;
        			s.remove(val - i);
        			i++;
        		}
        		if(count > max){
        			max = count;
        		}
        	}
        }
        return max;
    }
}