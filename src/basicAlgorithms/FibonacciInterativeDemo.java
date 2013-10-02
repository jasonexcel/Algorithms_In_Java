package basicAlgorithms;
import java.util.Scanner;
public class FibonacciInterativeDemo {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter a nonnegative number for fibonacci value");
		int inputNumber = keyboard.nextInt();
		System.out.println("Fib(" + inputNumber + ") = "+ fibValue(inputNumber));
	}
	private static int fibValue(int number) {
		switch (number) {
		case 0:	return 0;
		case 1: return 1;
		default: 
			int valueA = 1, valueB = 0, sum = 0;
			for (int i=0; i<number-1; i++) {
				// A = f(n-1), B = f(n-2)
				// Step 1. Sum A and B; Step2. Set f(n-2) the value of f(n-1) 
				// Step 3. Set f(n-1) the value of f(n)
				sum = valueA + valueB;
				valueB = valueA;
				valueA = sum;	
			}
			return sum;
		}
	}
}

