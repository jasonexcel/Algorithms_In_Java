/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sjia
 * 
 */
public class SpiralMatrix {
	//easier to write
		public ArrayList<Integer> spiralOrder_CodeGanker(int[][] matrix) {
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    if(matrix == null || matrix.length==0 || matrix[0].length==0)
		        return res;
		    // !!!
		    int min = Math.min(matrix.length, matrix[0].length);
		    int levelNum = min/2;
		    for(int level=0;level<levelNum;level++)
		    {
		    	//last one not included 
		        for(int i=level;i<matrix[0].length-level-1;i++)
		        {
		            res.add(matrix[level][i]);
		        }
		        for(int i=level;i<matrix.length-level-1;i++)
		        {
		            res.add(matrix[i][matrix[0].length-1-level]);
		        }
		        for(int i=matrix[0].length-1-level;i>level;i--)
		        {
		            res.add(matrix[matrix.length-1-level][i]);
		        }
		        for(int i=matrix.length-1-level;i>level;i--)
		        {
		            res.add(matrix[i][level]);
		        }
		    }
		    if(min%2==1)
		    {
		        if(matrix.length < matrix[0].length)
		        {
		            for(int i=levelNum; i<matrix[0].length-levelNum;i++)
		            {
		            	// add last row from left to right
		                res.add(matrix[levelNum][i]);
		            }
		        }
		        else
		        {
		            for(int i=levelNum; i<matrix.length-levelNum;i++)
		            {
		            	// add last column from top to bottom
		                res.add(matrix[i][levelNum]);
		            }
		        }
		    }
		    return res;
		}
		
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		int rowStart = 0;
		int colStart = 0;
		while (rowSize > 0 && colSize > 0) {
			for (int i = colStart; i < colStart + colSize; i++) {
				res.add(matrix[rowStart][i]);
			}
			// break if only one row left, otherwise case like {[2], [3]} cannot pass
			// 
			if (rowSize == 1) {
				break;//jump out of the loop because we have visited the last row, no more element
			}
			for (int j = rowStart + 1; j < rowStart + rowSize; j++) {
				res.add(matrix[j][colStart + colSize - 1]);
			}
			// break if only one column left
			if (colSize == 1) {
				break;
			}
			for (int i = colStart + colSize - 2; i >= colStart; i--) {
				res.add(matrix[rowStart + rowSize - 1][i]);
			}
			for (int j = rowStart + rowSize - 2; j > rowStart; j--) {
				res.add(matrix[j][colStart]);
			}
			rowSize -= 2;
			colSize -= 2;
			rowStart++;
			colStart++;
		}
		return res;
	}
	
}
