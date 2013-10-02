/**
 * @author Shaun Jia
 * CTCI 1.3 Given two strings, write a method to decide if one is a permutation of the other.
 */
package crackingTheCodingInterveiw150;

import java.util.*;
public class DetermineTwoPermutationStringsApp {
    public static void main(String[] args){
    	Scanner scanner1 = new Scanner(System.in);
    	Scanner scanner2 = new Scanner(System.in);
    	String str1 = scanner1.nextLine();
    	String str2 = scanner2.nextLine();
    	DetermineTwoPermutationStrings determination = new DetermineTwoPermutationStrings();
    	determination.SetStrings(str1, str2);
    	if(determination.isPermutation())
    		System.out.println("Two strings are permutation strings.");
    	else
    		System.out.println("Not permutation strings.");
    	scanner1.close();
    	scanner2.close();
    	return;    	
    }
}

class DetermineTwoPermutationStrings {
	public String string1;
	public String string2;
	public void SetStrings(String str1, String str2){
		string1 = str1;
		string2 = str2;
	}
	public boolean isPermutation(){
	    if (string1.length() != string2.length())
	    	return false;
	    int[] charCount1 = new int[256];
	    int[] charCount2 = new int[256];
	    charCount1 = countEachCharacter(string1);
	    charCount2 = countEachCharacter(string2);
	    for(int index=0; index<=255; index++)
	    	if (charCount1[index] != charCount2[index])
	    		return false;
	    return true;
	    	
	}
	
	private int[] countEachCharacter(String str){
		int[] charCount = new int[256];
		for(int item : charCount)
			item = 0;
		for(int index=0; index<str.length(); ++index){
			charCount[str.charAt(index)]++;			
		}
		return charCount;
	}
}