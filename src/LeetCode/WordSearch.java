/**
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring. 
 The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
package LeetCode;

public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Back tracking or DFS method
	public boolean exist(char[][] board, String word) {
        if(word==null || word.length()==0){
        	return true;
        }
        if(board==null||board.length==0||board[0].length==0){
        	return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
        	for(int j=0; j<board[0].length; j++){
        		if(searchLetter(board, word, 0, i, j, visited)){
        			return true;
        		}
        	}
        }
        return false;
    }
    
    private boolean searchLetter(char[][] board, String word, int index, int i, int j, boolean[][] visited){
    	if(index==word.length()){
    		return true;
    	}
    	//out of bound
    	if(i<0 || j<0 || i==board.length || j==board[0].length){
    		return false;
    	}
    	//already visited or not match
    	if(visited[i][j] == true || word.charAt(index)!=board[i][j]){
    		return false;
    	}
    	visited[i][j] = true;
    	//go to next letter in the word
    	if(searchLetter(board, word, index+1, i-1, j, visited)||
    			searchLetter(board, word, index+1, i+1, j, visited)||
    			searchLetter(board, word, index+1, i, j-1, visited)||
    			searchLetter(board, word, index+1, i, j+1, visited)){
    		//find the word in one of the direction, got return results 
    		return true;
    	}
    	visited[i][j] = false;
    	return false;
    }
}
