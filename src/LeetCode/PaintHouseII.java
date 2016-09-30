package LeetCode;

/**
 * Created by Shaun on 9/25/2016.
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int row = costs.length;
        int col = costs[0].length;
        int preMin1 = 0;
        int preMin2 = 0;
        int preColorMin1 = -1;

        for(int i = 0; i < row; i++) {
            int curMin1 = Integer.MAX_VALUE, curMin2 = curMin1, curColorMin1 = -1;

            for(int j = 0; j < col; j++) {
                // If same color as j - 1, we can only extend from 2nd min of j - 1
                int cost = costs[i][j] + (j == preColorMin1 ? preMin2 : preMin1);

                // Update m1 m2 if cost is smaller than any of them
                if(cost < curMin1) {
                    curMin2 = curMin1; curMin1 = cost; curColorMin1 = j;
                } else if(cost < curMin2) {
                    curMin2 = cost;
                }
            }
            // curMin1, curMin2 found, assign them to preMin1, preMin2
            preMin1 = curMin1; preColorMin1 = curColorMin1; preMin2 = curMin2;
        }
        return preMin1;
    }
}
