/**
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */
package LeetCode;

/**
 * @author sjia
 *
 */
public class UniquePathsII {
	
	// my recursive solution with cache method
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
        int[][] cache = new int[m][n];
        for(int i=0; i<cache.length; i++){
        	for(int j=0; j<cache[0].length; j++){
        		cache[i][j] = -1;
        	}
        }
        return uniquePathsHelper(m, n, cache, obstacleGrid);
    }
    private int uniquePathsHelper(int i, int j, int[][] cache, int[][] grid){
        if(i<1 || j<1){
        	return 0;
        }
    	if(cache[i-1][j-1] != -1) {
        	return cache[i-1][j-1];
        }
        if(grid[i-1][j-1]==1){
        	cache[i-1][j-1] = 0;
        	return 0;
        }
        if(i == 1 && j == 1){
        	cache[i-1][j-1] = 1;
        	return 1;
        }

        cache[i-1][j-1] = uniquePathsHelper(i-1,j, cache, grid) + uniquePathsHelper(i,j-1, cache, grid);
        return cache[i-1][j-1];
    }
    
    //normal DP, O(m*n) time complexity, O(m*n) space complexity
    public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
    	if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
    		return 0;
    	}
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	int[][] res = new int[m+1][n+1];
    	res[0][1]= 1;
    	for(int i=1; i<=m; i++){
    		for(int j=1; j<=n; j++){
    			if(obstacleGrid[i-1][j-1] == 1){
    				res[i][j] = 0;
    			}
    			else{
    				res[i][j] = res[i][j-1] + res[i-1][j];
    			}
    		}
    	}
    	return res[m][n];
    }
    //space-saving DP
    public int uniquePathsWithObstaclesDPII(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length==0 || obstacleGrid[0].length==0)
            return 0;
        int[] res = new int[obstacleGrid[0].length];
        res[0] = 1;
        for(int i=0;i<obstacleGrid.length;i++)
        {
        	//here j starting from 0
            for(int j=0;j<obstacleGrid[0].length;j++)
            {
                if(obstacleGrid[i][j]==1)
                {
                    res[j]=0;
                }
                else
                {
                	//!smart here
                    if(j>0)
                        res[j] += res[j-1];
                }
            }
        }
        return res[obstacleGrid[0].length-1];
    }
    
}
