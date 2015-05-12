package LeetCode;
import java.util.*;

public class NumberOfIslands {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// DFS
    public int numIslands(char[][] matrix) {
        if(matrix == null){
            throw new IllegalArgumentException();
        }
        if(matrix.length == 0){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int count = 0;
        boolean[][] marked = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
            	// if not marked and  it's an island
                if(!marked[i][j] && matrix[i][j] == '1'){
                    dfs(matrix, i, j, marked);
                    count++;
                }
            }
        }
        return count;
    }
    // dfs traversal
    private void dfs(char[][] matrix, int i, int j, boolean[][] marked){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length){
            return;
        }
        // already marked
        if(marked[i][j]){
            return;
        }
        // at water
        if(matrix[i][j] == '0'){
            return;
        }
        marked[i][j] = true;
        dfs(matrix, i - 1, j, marked);
        dfs(matrix, i + 1, j, marked);
        dfs(matrix, i, j - 1, marked);
        dfs(matrix, i, j + 1, marked);
    }
    
	//bfs
    public int numIslandsII(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int count = 0;
        boolean[][] marked = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!marked[i][j] && matrix[i][j] == '1'){
                    bfs(matrix, i, j, marked);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void bfs(char[][] matrix, int i, int j, boolean[][] marked){
        int m = matrix.length, n = matrix[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i * n + j);
        marked[i][j] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            int row = node / n, col = node % n;
            
            //up
            if(isValid(matrix, row - 1, col) && !marked[row - 1][col] && matrix[row - 1][col] == '1'){
                marked[row - 1][col] = true;
                queue.offer((row - 1) * n + col);
            }
            //down
            if(isValid(matrix, row + 1, col) && !marked[row + 1][col] && matrix[row + 1][col] == '1'){
                marked[row + 1][col] = true;
                queue.offer((row + 1) * n + col);
            }
            //left
            if(isValid(matrix, row, col - 1) && !marked[row][col - 1] && matrix[row][col - 1] == '1'){
                marked[row][col - 1] = true;
                queue.offer(row * n + col - 1);
            }
            //right
            if(isValid(matrix, row, col + 1) && !marked[row][col + 1] && matrix[row][col + 1] == '1'){
                marked[row][col + 1] = true;
                queue.offer(row * n + col + 1);
            }
        }
    }
    
    private boolean isValid(char[][] matrix, int i, int j){
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
