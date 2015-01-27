/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
 */
package LeetCode;

/**
 * @author Shaun
 *
 */
public class SudokuSolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void solveSudoku(char[][] board) {
	    if(board == null || board.length != 9 || board[0].length !=9)
	        return;
	    helper(board,0,0);
	}
	private boolean helper(char[][] board, int i, int j)
	{
	    if(j>=9){
	    	//go to next line
	        return helper(board,i+1,0);
	    }

	    if(i==9)
	    {
	    	//find the only solution
	        return true;
	    }
	    if(board[i][j]=='.')
	    {
	        for(int k=1;k<=9;k++)
	        {
	        	// try number k
	            board[i][j] = (char)(k+'0'); 
	            if(isValid(board,i,j))
	            {
	                if(helper(board,i,j+1)){
	                	return true;
	                }	                    
	            }
	            
	        }
	        //!!! reset this position
	        board[i][j] = '.';
	    }
	    else
	    {
	    	//current position is not empty, go to next column
	        return helper(board,i,j+1);
	    }
	    return false;
	}
	private boolean isValid(char[][] board, int i, int j)
	{
	    for(int k=0;k<9;k++)
	    {
	        if(k!=j && board[i][k]==board[i][j])
	            return false;
	    }
	    for(int k=0;k<9;k++)
	    {
	        if(k!=i && board[k][j]==board[i][j])
	            return false;
	    }        
	    for(int row = i/3*3; row<i/3*3+3; row++)
	    {
	        for(int col=j/3*3; col<j/3*3+3; col++)
	        {
	            if((row!=i || col!=j) && board[row][col]==board[i][j])
	                return false;
	        }
	    }
	    return true;
	}
}
