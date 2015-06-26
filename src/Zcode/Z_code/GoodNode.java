package Zcode.Z_code;

/**
 * http://www.careercup.com/question?id=5840928073842688
 * union-find problem 
 * 另外还需考虑4 4 3 2 1为输入的情况，输出应该是1.
 */
import java.util.*;


public class GoodNode {
	/*public static int find(int[] parent, int x) {
        if(x == 0) return 0;
        if(parent[x] == -1 || parent[x] == x) {
            return x;
        }
        return find(parent, parent[x]);
    }
    
    public static void union(int[] parent, int x, int y) {
        int xp = find(parent, x);
        int yp = find(parent, y);
        parent[xp] = yp;
    }
    
    public static int minChanges(int[] A) {
        int n = A.length;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for(int i=0; i<n; i++) {
            union(parent, i, A[i]);
        }
        int cnt = 0;
        for(int i=1; i<n; i++) {
            if(find(parent, i) == i)
                cnt++;
        }
        return cnt;
    }*/
    
	
    public static void main(String args[] ) throws Exception {
    	int[] connection = {4, 3, 2, 1};
    	WeightedQuickUnionFind unionFind = new WeightedQuickUnionFind(connection.length);
    	for(int i=0; i<connection.length; i++) {
    		unionFind.union(i, connection[i]-1);
    	}
    	System.out.println(unionFind.components - 1);
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int[] A = new int[n];
//        for(int i=0; i<n; i++) {
//            A[i] = s.nextInt()-1;
//        }
//        s.close();
        //System.out.println(minChanges(A));
    }
}

class WeightedQuickUnionFind {
	int[] parent;
	int[] size;
	int components;
	
	public WeightedQuickUnionFind(int N) {
		this.parent = new int[N];
		for(int i=0; i<N; i++) {
			// root itself
			parent[i] = i;
		}
		this.size = new int[N];
		Arrays.fill(size, 1);
		components = N;
	}
	// find root
	public int find(int num) {
		while(parent[num] != num) {
			num = parent[num];
		}
		return num;
	}
	
	public void union(int numA, int numB) {
		int rootA = find(numA);
		int rootB = find(numB);
		if(rootA != rootB) {
			if(size[rootA] > size[rootB]) {
				parent[rootB] = rootA;
				size[rootA] += size[rootB];
			}
			else {
				parent[rootA] = rootB;
				size[rootB] += size[rootA];
			}
			components--;			
		}
	}
}

