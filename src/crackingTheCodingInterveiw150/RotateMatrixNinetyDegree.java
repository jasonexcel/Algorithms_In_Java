package crackingTheCodingInterveiw150;
//ctci 1.6 write a method to rotate the matrix in 90 degrees
public class RotateMatrixNinetyDegree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		//int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
		int size = 5;		
		//RotateNinetyDegree(arr, size);
		RotateByLayer(arr, size);

        for(int r=0; r<size; r++)
        {
        	for(int c=0; c<size; c++)
        		System.out.print(arr[r][c]+",");
            System.out.print('\n');
        }
	}
	//block method
	public static void RotateNinetyDegree(int[][] array, int n){
		int column = 0, row = 0;
		int temp;
		// dismiss the center row if n is odd
		for(row=0; row<n/2; row++){
			// consider the center column if n is odd
			for(column=0; column<n/2.0; column++){
				// save top
				temp = array[row][column];
				// 
				array[row][column] = array[n-1-column][row];
				array[n-1-column][row] = array[n-1-row][n-column-1];
				array[n-1-row][n-column-1] = array[column][n-1-row];
				array[column][n-1-row] = temp;
			}
		}
		return;
	}
	//layer method
	public static void RotateByLayer(int[][] array, int n){
		for(int layer=0;layer<n/2;layer++){
			int first = layer;
			int last = n-1-layer;
			for(int i=first;i<last;i++){
				int offset = i - first;
				//save top
				int temp = array[first][i];
				array[first][i] = array[last-offset][first];
				array[last-offset][first] = array[last][last-offset];
				array[last][last-offset] = array[i][last];
				array[i][last] = temp;
			}
		}
	}

}
