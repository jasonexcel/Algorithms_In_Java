package basicAlgorithms;

public class FibonacciTailRecursive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fib = TailRec(3, 1, 0);
		System.out.println(fib);
	}
	
	public static int TailRec(int number, int acc1, int acc2) {
		if (number == 0)
			return acc2;
		return TailRec(number - 1, acc1 + acc2, acc1);
		
	}

}
