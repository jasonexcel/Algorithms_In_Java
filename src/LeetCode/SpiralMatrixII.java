/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
package LeetCode;

/**
 * @author sjia
 * time: O(n*n), space: O(n*n)
 */
public class SpiralMatrixII {
	//better solution
	public int[][] generateMatrixCodeGanker(int n) {
	    if(n<0)
	        return null;
	    int[][] res = new int[n][n];
	    int levelNum = n/2;
	    int num = 1;
	    for(int l=0;l<levelNum;l++)
	    {
	        for(int i=l;i<n-l;i++)
	        {
	            res[l][i] = num++;
	        }
	        for(int i=l+1;i<n-l;i++)
	        {
	            res[i][n-1-l] = num++;
	        }
	        for(int i=n-2-l;i>=l;i--)
	        {
	            res[n-1-l][i] = num++;
	        }
	        for(int i=n-2-l;i>l;i--)
	        {
	            res[i][l] = num++;
	        }
	    }
	    if(n%2==1)
	    {
	        res[levelNum][levelNum] = num;
	    }
	    return res;
	}
	
    public int[][] generateMatrix(int n) {
        if(n<=0){
       		return new int[][]{};
        }
        int[][] res = new int[n][n];
        int row = 0;
        while(n>0){
        	generateRound(res, row, n);
        	n-=2;
        	row++;
        }
        return res;
    }

    private void generateRound(int[][] mat, int row, int size){
    	int pre;
    	if(row==0){
    		pre = 0;
    	}
    	else{
    		pre = mat[row][row-1];
    	}
    	for(int i=row; i<row+size; i++){
    		mat[row][i] = ++pre;
    	}
    	for(int j=row+1; j<row+size; j++){
    		mat[j][row+size-1] = ++pre;
    	}
    	for(int i=row+size-2; i>=row; i--){
    		mat[row+size-1][i] = ++pre;
    	}
    	for(int j=row+size-2; j>row; j--){
    		mat[j][row] = ++pre;
    	}
    }
}
