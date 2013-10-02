/**
 * @author Shaun Jia
 * CTCI 1.8 Assume you have a method isSubstring which checks if one word is a substring of another. 
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to
 * isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
 */
package crackingTheCodingInterveiw150;

import java.util.Scanner;

public class CareerCup1_8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//         Scanner scanner1 = new Scanner(System.in);
//         Scanner scanner2 = new Scanner(System.in);
//         String s1 = scanner1.nextLine();
//         String s2 = scanner2.nextLine();
         //         if(isRotation(s1, s2))
		String s1 = "big";
		String s2 = "bibgbigb";
         if(isSubstring(s1, s2))
        	 System.out.println("true");
         else
        	 System.out.println("false");
	}
	
	public static boolean isRotation(String s1, String s2){
		int len = s1.length();
		String s = s1 + s1;
		if(len == s2.length()&& len>0 && isSubstring(s2, s))
			return true;
		return false;
	}
	
	public static boolean isSubstring(String sub, String str){
		int start = 0;
		int i = 0;
		if(sub.length()>0 && str.length()>=sub.length()){
			while(start<str.length()&&i<sub.length()){
				if(sub.charAt(i) != str.charAt(start)){
					start++;
					//initialize the i
					i = 0;
				}
				else{
					i++;
					start++;
				}
			}
			if(i==sub.length())
				return true;
		}
		return false;	

	}

}
