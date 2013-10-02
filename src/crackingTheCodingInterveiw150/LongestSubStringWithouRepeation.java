package crackingTheCodingInterveiw150;

import java.util.*;
public class LongestSubStringWithouRepeation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "dabacm";
        int len = getSubStringLength(str);
        System.out.println(len);
	}
	
	public static int getSubStringLength( String str){
		int subStart = 0, subEnd = 0;
		int place = -1;
		int index;
		 
			
		{		
		}
		return  subEnd-subStart;
	}
	
	private static int getIndexBySearch(char c, int start, int end, String str){
		int val = -1;
		for (int index = start; index< end; index++){
			if (c == (char)str.charAt(index)){
				return val = index;
			}
		}
			
		return val;
	}

}
