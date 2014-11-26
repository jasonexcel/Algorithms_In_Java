/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
package LeetCode;
import java.util.ArrayList;

/**
 * @author sjia
 *
 */
public class SetMatrixZeroes {
	//my solution: o(m*n) time complexity, o(m+n) space , not good enough
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return;
        }
        ArrayList<Integer> rowZeros = new ArrayList<Integer>();
        ArrayList<Integer> colZeros = new ArrayList<Integer>();
        for(int i=0; i<matrix.length; i++){
        	for(int j=0; j<matrix[0].length; j++){
        		if(matrix[i][j] == 0){
        			//not good here, can be optimized. any where, it's not the best solution
        			rowZeros.add(i);
        			colZeros.add(j);
        		}
        	}
        }
        for(int i=0; i<rowZeros.size(); i++){
        	for(int j=0; j<matrix[0].length; j++){
        		matrix[rowZeros.get(i)][j] = 0;
        	}
        }
        for(int i=0; i<matrix.length; i++){
        	for(int j=0; j<colZeros.size(); j++){
        		matrix[i][colZeros.get(j)] = 0;
        	}
        }
        return;
    }
    
    //better solution: o(m*n) time complexity, o(1) space complexity
    public void setZeroes_Better(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return;
        //store first row and column info, if true, the whole row/column needs to be set zeros
        boolean rowFlag = false;
        boolean colFlag = false;
        for(int i=0;i<matrix.length;i++)
        {
            if(matrix[i][0]==0)
            {
                colFlag = true;
                break;
            }
        }
        for(int i=0;i<matrix[0].length;i++)
        {
            if(matrix[0][i]==0)
            {
                rowFlag = true;
                break;
            }
        }      
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j] = 0;
            }
        }
        if(colFlag)
        {
            for(int i=0;i<matrix.length;i++)
            {
                matrix[i][0] = 0;
            }
        }
        if(rowFlag)
        {
            for(int i=0;i<matrix[0].length;i++)
            {
                matrix[0][i] = 0;
            }
        }
    }
}