package Zcode.Z_code;
import java.util.*;
public class ShortestDistanceToGuardedRoom {

	/**
	 * @param args
	 * http://www.1point3acres.com/bbs/thread-130761-1-1.html
	 * 求每个元素到guarded room的最短距离
0: closed room
1: open room
2: guarded room

例如input
1 2 1
1 0 1
1 2 1
那么output是
1 0  1
2 -1 2
1 0  1. 
	 */
	public static void main(String[] args) {
		//int[][] R = new int[][]{{1,2,1}, {1,0,1}, {1,2,1}};
		int[][] R = {{2, 1, 0}, 
					 {0, 1, 2}, 
					 {1, 1, 1}};
		int[][] res = shortestDistance(R);
		for(int i=0; i<res.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}

	public static int[][] shortestDistance(int[][] status) {
		if(status == null) {
			return null;
		}
		int row = status.length;
		int col = status[0].length;
		int[][] res = new int[row][col];
		boolean[][] visited = new boolean[row][col];
		// !!! four direction
		int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		int depth = 0;
		int curCount = 0;
		int nextCount = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(status[i][j] == 2) {
					int index = i * col + j;					
					q.offer(index);
					curCount++;
				}
				else {
					res[i][j] = -1;
				}
			}
		}
		while(!q.isEmpty()) {
			int index = q.poll();
			int rIndex = index / col;
			int cIndex = index % col;
			if(!visited[rIndex][cIndex]) {
				if(status[rIndex][cIndex] == 0) {
					visited[rIndex][cIndex] = true;
				}
				else {
					res[rIndex][cIndex] = depth;
					visited[rIndex][cIndex] = true;
					for(int path=0; path<4; path++) {
						int neightborRowIndex = rIndex + dir[path][0];
						int neightborColIndex = cIndex + dir[path][1];
						if(neightborRowIndex >=0 && neightborRowIndex < row && neightborColIndex >=0 && neightborColIndex < col) {
							q.offer(neightborRowIndex * col + neightborColIndex);
							nextCount++;
						}
					}
				}				
			}
			curCount--;
			if(curCount == 0) {
				depth++;
				curCount = nextCount;
				nextCount = 0;
			}
		}
		return res;
	}	
}
