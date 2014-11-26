/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 */
package LeetCode;

public class SearchA2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchA2DMatrix ins = new SearchA2DMatrix();
		int[][] matrix = {{1,2},{3,4}};
		//ins.searchMatrixBinary(matrix, 1);
		ins.searchMatrixBinaryII(matrix,  2);
		
	}
	//easy solution, but o(m+n) time
	public boolean searchMatrix(int[][] matrix, int target) {
        // worst case: o(m+n)
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
	
	// my solution, much harder, but logm + logn time
	public boolean searchMatrixBinary(int[][] matrix, int target){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		int row;
		if(target<matrix[0][0]){
			return false;
		}
		else if(target>matrix[matrix.length-1][0]){
			row = matrix.length-1;
		}
		else{
			row = searchRow(matrix, target, 0, matrix.length-1);
		}
		
		return searchCol(matrix[row], target, 0, matrix[0].length-1);
		
	}
	
	//{{1, 2},{3, 4}), target = 2 is an good example here
	private int searchRow(int[][] matrix, int target, int s, int e){
		if(s>e){
			return -1;
		}
		else if(s==e){
			return s;
		}
		//important here to avoid indefinite loop, mid is always the greater one 
		int mid = e - (e-s)/2;
		if(target<matrix[mid][0]){
			return searchRow(matrix, target, s, mid-1);
		}
		else if(target>matrix[mid][0]){
			// here it's mid instead of mid+1
			return searchRow(matrix, target, mid, e);
		}
		else{
			return mid;
		}
	}
	
	private boolean searchCol(int[] col, int target, int s, int e){
		if(s>e){
			return false;
		}
		int mid = e - (e-s)/2;
		if(target<col[mid]){
			return searchCol(col, target, s, mid-1);
		}
		else if(target>col[mid]){
			return searchCol(col, target, mid+1, e);
		}
		else{
			return true;
		}
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/24216235 
	//good solution
	public boolean searchMatrixBinaryII(int[][] matrix, int target) {
	    if(matrix == null || matrix.length==0 || matrix[0].length==0)
	        return false;
	    int l = 0;
	    int r = matrix.length-1;
	    while(l<=r)
	    {
	        int mid = (l+r)/2;
	        if(matrix[mid][0] == target) return true;
	        if(matrix[mid][0] > target)
	        {
	            r = mid-1;
	        }
	        else
	        {
	            l = mid+1;
	        }
	    }
	    //!!! important here, assign the lower value between l and r to row
	    int row = r;
	    if(row<0)
	        return false;
	    l = 0;
	    r = matrix[0].length-1;
	    while(l<=r)
	    {
	        int mid = (l+r)/2;
	        if(matrix[row][mid] == target) return true;
	        if(matrix[row][mid] > target)
	        {
	            r = mid-1;
	        }
	        else
	        {
	            l = mid+1;
	        }
	    }   
	    return false;
	}
}
