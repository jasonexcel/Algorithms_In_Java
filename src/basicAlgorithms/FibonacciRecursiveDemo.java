package basicAlgorithms;
import java.util.Scanner;

public class FibonacciRecursiveDemo {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a integer to get the Fibonacci value of it");
		int inputNumber = keyboard.nextInt();
		
		System.out.println("Fib(" + inputNumber + ") = " + fibValue(inputNumber));
	}
	
	private static long fibValue(int number) {
		if ( number < 0) {
			System.out.println("Error, negative number entered!");
			return 0;
		}
		else if	(number == 0) return 1;
		else if (number == 1) return 1;
		else return fibValue(number - 1) + fibValue(number - 2);
	}

}
