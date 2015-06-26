package basicAlgorithms;
import java.util.Arrays;
import java.util.Scanner;

public class FibonacciRecursiveDemo {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a integer to get the Fibonacci value of it");
		int inputNumber = keyboard.nextInt();
		
		int[] result = new int[inputNumber+1];
		Arrays.fill(result, -1);
		fibValueCache(inputNumber, result);
		//System.out.println("Fib(" + inputNumber + ") = " + fibValue(inputNumber));
		System.out.println("Fib(" + inputNumber + ") = " + result[inputNumber]);
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
	
	private static void fibValueCache(int number, int[] result) {
		if ( number < 0) {
			System.out.println("Error, negative number entered!");
			return;
		}
		else if	(number == 0) result[0] = 1;
		else if (number == 1) result[1] = 1;
		else if(result[number] == -1) {
			fibValueCache(number-1, result);
			fibValueCache(number-2, result);
			result[number] = result[number-2] + result[number-1];
		}
	}

}
