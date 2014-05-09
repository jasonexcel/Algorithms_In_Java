package crackingTheCodingInterveiw150;
///Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
public class CC1_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat={{3,2,0},{2,0,7},{4,2,1},{2,7,8}};
		
	    print(mat);	
        setMatrix(mat);
        print(mat);
	}
	
	public static void setMatrix(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		for(int r=0; r<matrix.length; r++)
			for(int c=0; c<matrix[0].length; c++){
				if(matrix[r][c] == 0){
					row[r] = true;
				    column[c] = true;
				}

			}
		for(int r=0; r<matrix.length; r++)
			for(int c=0; c<matrix[0].length; c++){
				if(row[r]||column[c]){
					matrix[r][c] = 0;
				}
			}
		return;
	}

	public static void print(int[][] arr){
		for(int r=0; r<arr.length; r++){
				for(int c=0; c<arr[0].length; c++){
					System.out.print(arr[r][c]+" ");
				}
				System.out.println();
		}
	}
}
