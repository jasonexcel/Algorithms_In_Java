package Zcode.Z_code;

import java.util.Stack;

public class StockMaxProfits {

	/**
	 * @param args
	 * https://www.hackerrank.com/challenges/stockmax
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 5, 2, 8, 7, 6, 1, 12, 22, 3, 41, 3, 7};
		System.out.println(calProfit(arr));
		System.out.println(calProfitSJ(arr));
	}
	// O(N)
	public static long calProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        Stack<Integer> highes = new Stack<Integer>();
        int localHigh = prices[len-1];
        for (int i=len-2; i>=0; i--) {
            if (prices[i] < prices[i+1] && prices[i+1] >= localHigh) {
                highes.push(i+1);
                localHigh = prices[i+1];
            }
        }
        if (highes.isEmpty()) {
            return 0;
        }
        int index = 0, high = highes.pop();
        long profit = 0;
        while (index < len) {
            while (index < high) {
                profit += prices[high] - prices[index];
                index++;
            }
            index = high+1;
            if (highes.isEmpty()) {
                break;
            } else {
                high = highes.pop();
            }
        }
        return profit;
    }

	//bad
	public static long calProfitSJ(int[] prices) {
		if(prices == null || prices.length < 2) {
			return 0;
		}
		long max = 0;
		return helper(prices, 0);
	}
	
	private static long helper(int[] prices, int start) {
		if(start >= prices.length) {
			return 0;
		}
		int highestIndex = start;
		for(int i=start+1; i<prices.length; i++) {
			if(prices[i] > prices[highestIndex]) {
				highestIndex = i;
			}
		}
		long profit = 0;
		int hightest = prices[highestIndex];
		for(int j=start; j<highestIndex; j++) {
			profit +=  hightest - prices[j];
		}
		return profit + helper(prices, highestIndex+1);
	}
	
}
