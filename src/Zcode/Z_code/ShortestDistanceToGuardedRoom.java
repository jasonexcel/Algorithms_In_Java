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
	
	public int[][] shortestDistance(int[][] status) {
		if(status == null) {
			return null;
		}
		return status;
	}
	
	private static int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	
	public static void minDistance(int[][] R) {
		Queue<Integer> queue = new LinkedList<>();
		int m = R.length, n = R[0].length;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(R[i][j] == 2) {
					// 1-D sequence 
					queue.offer(i*n+j);
				}
			}
		}
		int OFFSET = 10;
		while(!queue.isEmpty()) {
			int val = queue.poll();
			int r = val / n;
			int c = val % n;
			for(int k=0; k<dir.length; k++) {
				int i = dir[k][0] + r;
				int j = dir[k][1] + c;
				if(i>=0 && i<m && j>=0 && j<n && R[i][j] == 1) {
					R[i][j] = R[r][c] == 2 ? OFFSET+1 : R[r][c]+1;
					queue.offer(i*n+j);
				}
			}
		}
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(R[i][j] == 2) {
					R[i][j] = 0;
				} else if(R[i][j] == 0) {
					R[i][j] = -1;
				} else {
					R[i][j] -= OFFSET;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] R = new int[][]{{1,2,1}, {1,0,1}, {1,2,1}};
		minDistance(R);
		for(int i=0; i<R.length; i++) {
			System.out.println(Arrays.toString(R[i]));
		}
	}
}
