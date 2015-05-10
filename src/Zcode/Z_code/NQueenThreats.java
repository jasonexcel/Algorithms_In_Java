package Zcode.Z_code;

import java.util.*;
public class NQueenThreats {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {0, 3, 2, 1, 4};
		System.out.println(threatsMax(input));
	}
	public static int threatsMax(int[] input) {
		if(input == null || input.length == 0) {
			return 0;
		}
		// 0 - first cord, 1 - third cord, 2 - second cord, 3 - fourth cord
		int[][] threats = new int[4][input.length];
		for(int i=0; i<input.length; i++) {
			for(int j=i+1; j<input.length; j++) {				
				if(input[i]+i == input[j]+j) {
					//threat is from first cord
					if(threats[0][i] == 0) {
						threats[0][i]++;
					}
					
					// third cord for j
					if(threats[1][j] == 0) {
						threats[1][j]++;
					}										
				}
				if(input[i]-i == input[j]-j) {
					// from second cord
					if(threats[2][i] == 0) {
						threats[2][i]++;	
					}
					// from fourth cord
					if(threats[3][j] == 0) {
						threats[3][j]++;
					}					
				}				
			}
			int total = 0;
			for(int k=0; k<4; k++) {
				total += threats[k][i];
				if(total == 4) {
					return 4;
				}
			}
		}
		
		int totalThreats = 0;
		int max = 0;
		for(int i=0; i<input.length; i++) {
			totalThreats = 0;
			for(int j=0; j<4; j++) {
				totalThreats += threats[j][i];
			}
			max = Math.max(totalThreats, max);
		}
		return max;
	}
}
