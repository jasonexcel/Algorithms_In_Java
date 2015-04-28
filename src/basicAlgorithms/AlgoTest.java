package basicAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class AlgoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner sc = new Scanner(System.in);
/*		//String str = sc.nextLine();
		String str2 = sc.next();
		System.out.println(str2);*/
		
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int t = 0; t < n; t++) {
            arr[t] = sc.nextInt();
            System.out.println();
        }
        for(int elem : arr) {
        	System.out.print(elem + ", ");
        }
        

					System.console();


	}
	public ArrayList<Integer> getRow(int rowIndex) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(rowIndex < 0){
        	return null;
        }
        ArrayList<Integer> rowList = new ArrayList<Integer>();
        if(rowIndex == 0) {
        	rowList.add(1);
        }
        else{
        	for(int i = 0; i<=rowIndex; i++){
        		long comVal = 1;
        		if(i == 0){
        			comVal = 1;
        		}
        		else if(i <= rowIndex/2){
        			comVal = calcFactRange(rowIndex-i+1, rowIndex)/ calcFactRange(1, i);
        		}
        		else{
        			comVal = rowList.get(rowIndex - i);
        		}
        		rowList.add((int)comVal);
        	}
        }
        return rowList;
    }

    private long calcFactRange(int low, int high){
    	long val = 1;
    	while(low<=high){
    		val *=low;
    		low++;
    	}
    	return val;
    }
}
