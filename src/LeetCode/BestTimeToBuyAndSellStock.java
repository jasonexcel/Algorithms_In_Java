package LeetCode;

public class BestTimeToBuyAndSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxProfit(int[] prices) {
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
