/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */

package LeetCode;
import java.util.HashMap;
public class ValidSudoku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isValidSudoku(char[][] board) {
    // Start typing your Java solution below
    // DO NOT write main() function
    for(int i=0; i<9; i++){
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        for(int j=0; j<9; j++) {
            if(hm.containsValue(board[i][j])) {
                return false;
            }
            else if(board[i][j] >='0' && board[i][j] <= '9') {
                hm.put(board[i][j], board[i][j]);
            } else if (board[i][j] != '.'){
                return false;
            }
        }
    }
    for(int j=0; j<9; j++){
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        for(int i=0; i<9; i++) {
            if(hm.containsValue(board[i][j])) {
                return false;
            }
            else if(board[i][j] >='0' && board[i][j] <= '9') {
                hm.put(board[i][j], board[i][j]);
            } else if (board[i][j] != '.'){
                return false;
            }
        }
    }
    
                    
    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            HashMap<Character, Character> hm = new HashMap<Character, Character>();
            for(int k=0; k<3; k++){
                for(int l=0; l<3; l++){
                    char c = board[3*i+k][3*j+l];
                    if(hm.containsValue(c)) {
                        return false;
                    }
                    else if(c >='0' && c <= '9') {
                        hm.put(c, c);
                    } else if(c != '.'){
                        return false;
                    }
                }
                
            }
            
        }
    }
    return true;    
}

}
