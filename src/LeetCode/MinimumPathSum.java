/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes 
 * the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
package LeetCode;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
        	return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int[][] s = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                s[i][j] = -1;
            }
        }
        return minPathSumMN(r-1, c-1, s, grid);
    }

    private int minPathSumMN(int m, int n, int[][] s, int[][]grid){
    	if(m == 0 && n == 0 ){
    		return grid[0][0];
    	}
    	else if(m == 0){
            if(s[m][n-1] != -1){
                s[m][n] = s[m][n-1] + grid[m][n];
            }
            else{
                s[m][n] = minPathSumMN(m, n-1, s, grid) + grid[m][n];
            }
    	}
    	else if(n == 0){
            if(s[m-1][n] != -1){
                s[m][n] = s[m-1][n] + grid[m][n];
            }
            else{
                s[m][n] = minPathSumMN(m-1, n, s, grid) + grid[m][n];
            }
    	}
    	else{
            if(s[m][n-1] == -1){
                 s[m][n-1] = minPathSumMN(m, n-1, s, grid);
            }
            if(s[m-1][n] == -1){
                s[m-1][n] = minPathSumMN(m-1, n, s, grid);
            }
    		int min = s[m][n-1] <= s[m-1][n] ? s[m][n-1] : s[m-1][n];
    		s[m][n] = min + grid[m][n];
    	}
        return s[m][n];
    }
    
    //http://blog.csdn.net/linhuanmars/article/details/22257673
    public int minPathSumIterative(int[][] grid) {
        if(grid == null || grid.length==0 || grid[0].length==0)
            return 0;
        int[] res = new int[grid[0].length];
        res[0] = grid[0][0];
        for(int i=1;i<grid[0].length;i++)
        {
            res[i] = res[i-1]+grid[0][i];
        }
        for(int i=1;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(j==0)
                    res[j] += grid[i][j];
                else
                    res[j] = Math.min(res[j-1], res[j])+grid[i][j];
            }
        }
        return res[grid[0].length-1];
    }
}