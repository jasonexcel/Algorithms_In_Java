/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as
 you like (ie, buy one and sell one share of the stock multiple times). 
 However, you may not engage in multiple transactions at the same time
  (ie, you must sell the stock before you buy again).*/

package LeetCode;

public class BestTimeToBuyAndSellStockII {
	// Preferred 
	// {3, 5, 7}  == (5-3) + (7-5)
	public int maxProfit(int[] prices) {
		int maxP = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				maxP += prices[i] - prices[i - 1];
			}
		}
		return maxP;
	}
	
    public int maxProfitII(int[] prices) {
        int max = 0;
        if(prices == null || prices.length < 2) {
            return max;
        }
        int buyP = prices[0];
        int sell = 1;
        while(sell < prices.length) {
            int curP = prices[sell];
            if(curP <= prices[sell-1]) {
                max += prices[sell-1] - buyP;
                buyP = curP;
                sell++;
            }

            else if(curP < buyP) {
                buyP = curP;
                sell++;
            }
            else {
                sell++;
            }
        }
        if(buyP < prices[sell-1]) {
            max += prices[sell-1] - buyP;
        }
        return max;
    }
}
