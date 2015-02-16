/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
 */
package LeetCode;

public class BestTimeToBuyAndSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// my solution, time complexity: o(n), space o(1)
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length<=1){
            return 0;
        }
        int global = 0;
        int high = prices[0];
        int low = high;
        for(int i=1; i<prices.length; i++){
            if(prices[i]>high){
                high = prices[i];
            }
            else if(prices[i]<low){
                low = prices[i];
                high = low;
            }
            global = Math.max(global, high-low);
        }
        return global;
    }
    
    public int maxProfitII(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int min = 0, maxDiff = 0;
//        int buy = 0, sell = 0;
        if(prices.length <=1) return 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<prices[min]){
                min = i;
            }
            if(prices[i]-prices[min]>maxDiff){
//                buy = min;
//                sell = i;
                maxDiff = prices[i]-prices[min];
            }
        }
        return maxDiff;        
    }

}
