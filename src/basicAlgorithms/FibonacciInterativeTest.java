package basicAlgorithms;
import java.util.*;
public class FibonacciInterativeTest {

		public static void main(String[] args){
			Scanner scanner = new Scanner(System.in);
			int val = 0;
			try{
				 val = scanner.nextInt();
			}
			catch (Exception e){
				System.out.println("Error " + e);
			}
			scanner.close();
			System.out.println("value = " + Fib(val));
		}

	public static int Fib(int number) {
		if (number < 0){
		    return -1;
		}
		else if (number == 0){
		    return 0;
		}
		else if (number == 1){
		    return 1;
		}
	    else {
	    	int valueOne = 0;
	    	int valueTwo = 1;
	    	int value = 0;
	    	int index = 1;
	        do {
	            value =  valueOne + valueTwo;
	            valueOne = valueTwo;
	            valueTwo = value;
	            index++;
	        } while(index < number);
	        return value;
	    }
	}

}
