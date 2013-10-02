/**
 * 
 */
package basicAlgorithms;

/**
 * @author Xiaoyuan
 *
 */

import java.util.Scanner;
import java.lang.System;
public class Program1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] arrayList = {1.2, 3.4, 5.6};
		char character = 'a';
		//Scanner input = new Scanner(text.txt);
		/*for (double i : arrayList) {
			System.out.println("enter a number:");
			System.out.print(input.nextDouble() + " ");
		}*/
		
		for(double array:arrayList) {
			System.out.print(array+" ");
			array = 3.3;
			System.out.print(array+",");
		}
		
		double[] cards = new double[51];
		System.arraycopy(arrayList, 0, cards, 0, arrayList.length);
		cards = swap(arrayList);
	}

	 static double[] swap(double[] order) {
		double[] result = new double[order.length];
		for(int i=0, j=order.length-1; i<order.length; i++, j--) {
			//double temp = order[j];
			result[j] = order[i];
			result[i] = order[j];
		}
		return result;		
	}
}
