package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NQueenII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueenII ins = new NQueenII();
		System.out.println(ins.totalNQueens(1));
	}
	
	public int totalNQueens(int n) {
        int count = 0;
        if(n > 0){
        	int[] occupiedIndices = new int[n]; //store the index of queen in each row
        	int[] cArr = {0};
        	enumerate(occupiedIndices, 0, cArr);
        	count = cArr[0];
        }
        return count;
    }
	
	private void enumerate(int[] oI, int row, int[] countArr){
		if(row == oI.length){
			//find one solution
			countArr[0]++;		
		}
		else{
			for(int i=0; i<oI.length; i++){
				oI[row] = i; //reset the index of queen 
				if(isConsistent(oI, row)){
					// no conflict, continue to next row
					enumerate(oI, row+1, countArr);
				}
			}
		}		
	}
	
	//check for conflicts
	private boolean isConsistent(int[] oI, int row){
		for(int i=0; i<row; i++){
			if(oI[i] == oI[row]){
				return false;
			}
			if(oI[i]-i == oI[row]-row){
				return false;
			}
			if(oI[i]+i == oI[row]+row){
				return false;
			}			
		}
		return true;
	}	
}
