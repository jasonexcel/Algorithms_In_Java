/**
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */
package LeetCode;

/**
 * O(n^2) time, O(1) space
 *
 */
public class RotateImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public void rotate(int[][] matrix) {
        if(matrix == null){
        	return;
        }
    	int n = matrix.length;
    	for(int i=0; i<n/2; i++){
    		int start = i;
    		int end = n - i - 2; //start + end = (n-1) - 1
    		for(int j=start; j<=end; j++){
    			int temp = matrix[i][j];
    			//find the match one, very tricky
    			matrix[i][j] = matrix[n-1-j][i];
    			matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
    			matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
    			matrix[j][n-1-i] = temp;
    		}
    	}
    	return;
    }
}
