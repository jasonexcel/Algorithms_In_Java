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