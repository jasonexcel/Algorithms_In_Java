package basicAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import LeetCode.SymmetricTree.TreeNode;

public class Algo1 {
	public static void main(String[] args) {
		int abc = 3;
		int cba = - abc;
		System.out.println(cba);
		Algo1 a = new Algo1();
		int len = a.lengthOfLastWord("a ");
		System.out.println("len=" + len);
		String str = new String("1");
		
		int[] letters = new int[128];
		letters['a'] = 3;
		letters["bdc".charAt(1)] = 2;
		a.atoi(str);
		
		boolean t[] = new boolean[25];

		int[] a2 = {3,5};
	}
	public int lengthOfLastWord(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		int i;
        int total = s.length();
        for(i = 0; i<total; i++){
        	if(s.charAt(total-i-1) == ' '){
        		break;
        	}
        }
        return i; 
    }
	
	 public int atoi(String str) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        // invalid
	    	int val = 0;
	    	boolean hasDigit = false;
	    	boolean hasSign = false;
	    	boolean isNegative = false;
	    	for(int i=0; i<str.length(); i++){
	    		char c = str.charAt(i);
	    		if( c==' '){
	    			if(!hasDigit){
	    				continue;	
	    			}
	    			else{
	    				return val;
	    			}
	    		}
	    		if((c=='+' || c=='-')&&hasSign){
	    			return 0;
	    		}
	    		if(c=='+'){
	    			hasSign = true;
	    		}
	    		if(c=='-'){
	    			hasSign = true;
	    			isNegative = true;
	    		}
	    		if(c>='0'&&c<='9'){
	    			val = val*10 + c - '0'; //to to
	    			hasDigit = true;
	    		}
	    		if((c<'0' || c>'9')&&hasDigit){
	    			if(isNegative){
	    				val = 0 - val;
	    			}
	    			return val;    			
	    		}
	    		else{
	    			return 0;
	    		}
	    	}
	    	if(isNegative){
	    		return 0 - val;
	    	}
	    	return val;
	        //
	    }
}
