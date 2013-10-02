/**
 * 
 */
package crackingTheCodingInterveiw150;

//import java.system.Math;

/**
 * @author Xiaoyuan
 *
 */

public class CountLetters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] letterArray = generateCharacterArray(100);
		int[] countArray = new int[1000];
		for (char letter: letterArray) {
			countArray[(int)(letter - 'a')]++;
		}
		for (int count: countArray) {
			System.out.print(count+ " ");
		}

	}
	
	static char[] generateCharacterArray(int length) {
		if (length <= 0) 
			return null;
		char[] result = new char[length];
		for(char letter:result) {
		//for(int i = 0; i<result.length; i++) {
			letter = (char)('a' + Math.random()*26);
			System.out.print(letter+" ");
			//result[i] = (char)('a' + Math.random()*26);
		}
		return result;
	}

}
