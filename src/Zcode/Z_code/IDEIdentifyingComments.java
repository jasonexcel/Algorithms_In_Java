package Zcode.Z_code;
import java.util.*;
public class IDEIdentifyingComments {

	/**
	 * @param args
	 * https://www.hackerrank.com/challenges/ide-identifying-comments
	 */
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		String str;
		while(s.hasNext()){
			 str=s.nextLine();
			 for(int i=0; i<str.length()-1; i++){
				if(str.charAt(i)=='/' && str.charAt(i+1)=='/') {
					int j=i;
					while(j<str.length() && str.charAt(j)!='\n'){
							System.out.print(str.charAt(j));
							j++;
						}
					System.out.println();
				}
				else if(str.charAt(i)=='/' && str.charAt(i+1)=='*'){
					System.out.println(str.substring(i));
					// if first line doesn't contain */
                    if(!str.contains("*/")) {
                        str = s.nextLine();
                        while(!str.contains("*/")) {
                        	//print all lines until find */
						   System.out.println(str.trim());
					   	   str = s.nextLine();
					    }
                        //print the line containing */
                        System.out.println(str.trim());
                    }				
				}
			}
		}			
	}
	

}
