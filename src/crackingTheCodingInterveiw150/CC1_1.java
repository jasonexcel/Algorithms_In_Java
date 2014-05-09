/**
 * 
 */
package crackingTheCodingInterveiw150;

import java.util.*;


/**
 * @author Shaun Jia
 * CTCI 1.1 implement an algorithm to determine if a string has unique characters
 */
public class CC1_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        String str = input.next();
        CC1_1 model = new CC1_1();
        
        //if(model.isUniqueCharacters(str))
        if(model.isUniqueCharactersByBitShift(str))	
        	System.out.println("Is unique Characters");
        else
        	System.out.println(str +" "+ "does not meet unique characters ");
        input.close();
        return;
	}
	
	protected  boolean isUniqueCharacters(String str){
		boolean[] isDuplicated = new boolean[256];
		if (str.length()> 256)
			return false;
		for (int i = 0; i< str.length(); i++){
			char charInString = str.charAt(i);
			if(isDuplicated[charInString])
				return false;
			isDuplicated[charInString] = true;			
		}
		return true;
	}
	
	// only work for lower chase letter string
	protected boolean isUniqueCharactersByBitShift (String str){
		int checker = 0;
		if(str.length()>256)
			return false;
		for (int i=0; i<str.length(); ++i) {
			int charInString = str.charAt(i) - 'a';
			if ((checker & (1<<charInString))>0)
				return false;
			// set flag for charInString in checker
			checker |= 1<<charInString;
		}
		return true;
	}

}
