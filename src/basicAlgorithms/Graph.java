package basicAlgorithms;

public class Graph {

	  private int[][] nodes; // all nodes; e.g. int[][] nodes = {{1,2,3}, {3,2,1,5,6}...};

	  public int[] getAdjacentNodes(int v) {
	    return nodes[v];
	  }

	  // number of vertices in a graph
	  public int vSize() {
	    return nodes.length;
	  }

	}