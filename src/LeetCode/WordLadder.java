package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = new String("hot");
		String end = new String("dog");
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dog");
		dict.add("dot");
		WordLadder fl = new WordLadder();
		fl.ladderLength(start, end, dict);
	}

	public int ladderLength(String start, String end, Set<String> dict) {
	    Queue<String> from = new LinkedList<String>(); // store the path       
	    HashSet<String> used = new HashSet<String>(); // stores the used words
	    from.add(start);
	    int step = 1; // step from beginning to end, if beginning = end, then set as 1
	    int curL = 1, nextL = 0; // the number of elements in current level and next level 
	    while(!from.isEmpty()){
	    	String cur = from.poll();
	    	curL--;
	    	if(cur.equals(end)){
	    		return step;
	    	}
	    	// if the variation in the dict, then add to next level and also the used set
	    	char[] charArray = cur.toCharArray();
	    	for(int i=0; i<charArray.length; i++){
	    		// base is the original char, needs to be reset after the modification
	    		char base = charArray[i];
	    		for(char letter='a'; letter<='z'; letter++){
	    			if(letter!=base){
	    				charArray[i] = letter;
	    				String str = new String(charArray);
	    				if(dict.contains(str) && !used.contains(str)){
	    					used.add(str);
	    					from.add(str);
	    					nextL++;
	    				}
	    			}	
	    		}
	    		//!important: reset the word to unmodified, otherwise, each character will finally become 'z'
	    		charArray[i] = base;
	    	}

	    	if(curL == 0){
	    		curL = nextL;
	    		nextL = 0;
	    		step++;
	    	}
	    }
	    return 0;
	}
}
