package basicAlgorithms;

import java.util.Scanner;

public class FactorialCal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input a positive integer");
		int value = scanner.nextInt();
		// change the method!
		int result = FactorialCalTailRecursive(value, 1);
		System.out.println(result);
	}
	// Recursive method
	public static int FactorialCalRecursive(int val) {
		if (val == 0)
			return 1;
		return FactorialCalRecursive(val-1) * val;
	}
	// Tail recursive method
	public static int FactorialCalTailRecursive(int val, int acc) {
		if (val == 0) 
			return acc;
		return FactorialCalTailRecursive(val - 1, acc * val);
	}
	// Iterative method
	public static int FactorialCalIterative(int val) {
		int result = 1;

		for (int i = 0; i < val; i++) {
			result = result * (i + 1);
		}
		return result;
	}

}
