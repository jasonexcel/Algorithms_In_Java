package RealInterviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class PolygonCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{0, 1, 1,1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 1, 1, 0}};
		System.out.println(uniqueTriangles(arr));
		List<Integer> vertices = new ArrayList<Integer>();
		int[] count = {0};
		int[] count2 = {0};
		int n = 3;
		polygonHelper(arr, 3, vertices, count, 0);
		//polygonHelperII(arr, 3, 0, count2, 0, 0, 0);
		System.out.println(count[0]);
		System.out.println(count2[0]);
		 
	}

	public static int uniqueTriangles(int[][] arr) {
		if(arr == null || arr.length == 0 || arr[0].length == 0 || arr.length != arr[0].length) {
			return 0;
		}
		int count = 0;
		int len = arr.length;
		for(int i=0; i<len-2; i++) {
			for(int j=i+1; j<len-1; j++) {
				if(arr[i][j] == 1) {
					for(int k=j+1; k<len; k++) {
						if(arr[j][k] == 1 && arr[k][i] == 1) {
							count++;
						}
					}

				}
			}
		}
		return count;
	}
	
	private static void polygonHelper(int[][] arr, int n, List<Integer> vertices, int[] count, int curIndex) {
		int nodes = vertices.size();
		if(nodes == n && arr[vertices.get(nodes-1)][vertices.get(0)] == 1) {
			count[0]++;
			return;
		}
		
		for(int index = curIndex; index<arr.length-(n-nodes)+1; index++) {
			if(nodes == 0) {
				vertices.add(index);
				polygonHelper(arr, n, vertices, count, index+1);
				vertices.remove(vertices.size()-1);
			}
			else {
				if(arr[vertices.get(nodes-1)][index] == 1) {
					vertices.add(index);
					polygonHelper(arr, n, vertices, count, index+1);
					vertices.remove(vertices.size()-1);
				}
				
			}
		}
	}
	
	// no extra space
	// something is wrong
	/*private static void polygonHelperII(int[][] arr, int n, int nodes, int[] count, int curIndex, int lastIndex, int firstIndex) {
		if(nodes == n && arr[lastIndex][firstIndex] == 1) {
			count[0]++;
			return;
		}
		
		for(int index = curIndex; index<arr.length-(n-nodes)+1; index++) {
			if(nodes == 0) {
				firstIndex = index;
				nodes++;
				lastIndex = index;
				polygonHelperII(arr, n, nodes, count, index+1, index, firstIndex);
				nodes--;
				lastIndex = index;
				firstIndex = index;
			}
			else {
				if(arr[lastIndex][index] == 1) {
					nodes++;
					lastIndex = index;
					polygonHelperII(arr, n, nodes, count, index+1, lastIndex, firstIndex);
					nodes--;
					lastIndex = index;
					
				}
				
			}
		}
	}*/
}
