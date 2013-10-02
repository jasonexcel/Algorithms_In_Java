package basicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Algo1 {
	public static void main(String[] args) {
	   System.out.println("input size of array: ");

	   
	   int count = 0; 
	   int i; 
	   for (i=0;i<10;++i) {
		   int newCount = count++;
		   count = newCount;
	   }
	System.out.println(count);
	}
}