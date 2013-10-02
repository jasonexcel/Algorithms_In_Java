package LeetCode;

public class SearchA2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int i = m-1, j =0;
        while(i>=0 && j<n){
            if(matrix[i][j] < target){
                j++;
                
            }
            else if(matrix[i][j] > target){
                i--;
            }
            else{
                return true;
            }

        }
        return false;
    }
}
