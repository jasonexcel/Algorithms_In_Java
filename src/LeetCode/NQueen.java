package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueen ins = new NQueen();
		List<String[]> results = ins.solveNQueens(1);
		System.out.println();
	}
	public List<String[]> solveNQueens(int n) {
        List<String[]> results = new ArrayList<String[]>();
        if(n > 0){
        	int[] occupiedIndices = new int[n]; //store the index of queen in each row
        	enumerate(occupiedIndices, 0, results);
        }
        return results;
    }
	
	private void enumerate(int[] oI, int row, List<String[]> results){
		if(row == oI.length){
			//find one solution
			buildResults(oI, results);			
		}
		else{
			for(int i=0; i<oI.length; i++){
				oI[row] = i; //reset the index of queen 
				if(isConsistent(oI, row)){
					// no conflict, continue to next row
					enumerate(oI, row+1, results);
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
	
	//build the results list
	private void buildResults(int[] oI, List<String[]> results){
		int size = oI.length;
		String[] res = new String[size];
		for(int r=0; r<size; r++){		
			StringBuilder sb = new StringBuilder();
			for(int c=0; c<size; c++){
				if(oI[r] == c){
					sb.append('Q');
				}
				else{
					sb.append('.');
				}
			}
			String s = sb.toString();
			res[r] = s;
		}
		results.add(res);
	}
}
