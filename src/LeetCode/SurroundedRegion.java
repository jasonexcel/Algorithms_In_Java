/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 */
package LeetCode;

import java.util.LinkedList;

/**
 * http://blog.csdn.net/linhuanmars/article/details/22904855
 * time: o(m*n); space: the queue - o(m+n)
 *
 */
public class SurroundedRegion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void solve(char[][] board) {
	    if(board==null || board.length<=1 || board[0].length<=1)
	        return;
	    //use flood fill method at edge rows and columns
	    //first and last rows
	    for(int i=0;i<board[0].length;i++)
	    {
	        fill(board,0,i); //flood fill starting from pos(0, i)
	        fill(board,board.length-1,i);
	    }
	    //first and last column
	    for(int i=0;i<board.length;i++)
	    {
	        fill(board,i,0);
	        fill(board,i,board[0].length-1);
	    }
	    //replace
	    for(int i=0;i<board.length;i++)
	    {
	        for(int j=0;j<board[0].length;j++)
	        {
	            if(board[i][j]=='O')
	                board[i][j]='X';
	            else if(board[i][j]=='#')
	                board[i][j]='O';                
	        }
	    }
	}
	private void fill(char[][] board, int i, int j)
	{
	    if(board[i][j]!='O')
	        return;
	    board[i][j] = '#';
	    LinkedList<Integer> queue = new LinkedList<Integer>();
	    //encode the coordination of the position
	    int code = i*board[0].length+j;
	    queue.offer(code);
	    //BFS method to replace all "flood fill" 'o' 
	    while(!queue.isEmpty())
	    {
	        code = queue.poll();
	        int row = code/board[0].length;
	        int col = code%board[0].length;
	        //up
	        if(row>0 && board[row-1][col]=='O')
	        {
	            queue.offer((row-1)*board[0].length+col);
	            board[row-1][col]='#';
	        }
	        //down
	        if(row<board.length-1 && board[row+1][col]=='O')
	        {
	            queue.offer((row+1)*board[0].length+col);
	            board[row+1][col]='#';
	        }
	        //left
	        if(col>0 && board[row][col-1]=='O')
	        {
	            queue.offer(row*board[0].length+col-1);
	            board[row][col-1]='#';
	        }
	        //right
	        if(col<board[0].length-1 && board[row][col+1]=='O')
	        {
	            queue.offer(row*board[0].length+col+1);
	            board[row][col+1]='#';
	        }            
	    }
	}
}
