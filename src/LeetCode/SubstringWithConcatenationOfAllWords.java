/**
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once
 *  and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 * 
 * L might have duplicate strings, 
 * Strings in L have fixed length;
 * Two pointer, Hashmap
 * Time complexity: O(S.length() * L.length)
 * 
 * http://blog.csdn.net/u013027996/article/details/24795107
 */
package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author sjia
 *
 */
public class SubstringWithConcatenationOfAllWords {
	
	public static void main(String[] args){
		SubstringWithConcatenationOfAllWords ins = new SubstringWithConcatenationOfAllWords();
		String s = "aaa";
		String[] L = {"a","b"};
		ArrayList<Integer> results = ins.findSubstring(s,  L);
		System.out.println(results);
	}
	//two pointer: one is the "index" -- the start point of the substring
	// another is the "j" -- the current position
	public  ArrayList<Integer> findSubstring(String S, String[] L) { 
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(S==null||L==null||S.length()==0||L.length==0)
           return res;
        int wordLen = L[0].length();//same length for each word in dictionary
        
        //put given dictionary into hashmap with each word's count
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(String word: L){
            if(!dict.containsKey(word))
               dict.put(word, 1);
            else
               dict.put(word, dict.get(word) + 1);
        }
        
        //determine the start index of scan
        /*
         *  bar|foo|the|foo|bar|man
			ba|rfo|oth|efo|oba|rma|n
			b|arf|oot|hef|oob|arm|an
			*/	
        for(int i = 0; i < wordLen; i++){
            int count = 0; // count the length of valid words 
            int index = i;//index of each valid result's start point 
            HashMap<String, Integer> curdict = new HashMap<String, Integer>();
            //till the first letter of last word 
            for(int j = i; j <= S.length() - wordLen; j += wordLen){
                String curWord = S.substring(j, j + wordLen);
                //check each word to tell if it exists in given dictionary
                if(!dict.containsKey(curWord)){
                    curdict.clear();
                    count = 0;
                    index = j + wordLen;
                }
                else{
                	if(!curdict.containsKey(curWord)){
                		curdict.put(curWord, 1);
                	}
                	else if(curdict.get(curWord) < dict.get(curWord)){
                		curdict.put(curWord, curdict.get(curWord) + 1);
                	}
                	else{
                		//current word count reach the limit
                		//need to find the first existence since index
                		while(curdict.get(curWord) == dict.get(curWord)){
                			String temp = S.substring(index, index + wordLen);
                            curdict.put(temp, curdict.get(temp)-1);
                            count--; //decrease count by 1
                            index+=wordLen;
                		}
                		curdict.put(curWord,  curdict.get(curWord)+1);
                	}
                	//current count increase by 1 on all conditions above
                	count++;
                    
                    
                    //find a solution, put into res and move index point to just next word! 
                    //and update current dictionary as well as count num
                    if(count == L.length){
                        res.add(index);
                        String temp = S.substring(index, index + wordLen);
                        curdict.put(temp, curdict.get(temp)-1);
                        index = index + wordLen;
                        count--;
                    }
                }
            }//end for j
        }//end for i
        return res;
    }
}
