package basicAlgorithms;

public class DFSDirectedCycle {

    private boolean marked[];
    private boolean onStack[];
    private int s;
    private Graph g;
    private boolean hasCycle;

    public DFSDirectedCycle(Graph g, int s) {
        this.g = g;
        this.s = s;
        marked = new boolean[g.vSize()];
        onStack = new boolean[g.vSize()];
        findCycle(g,s);
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public void findCycle(Graph g, int v) {

        marked[v] = true;
        onStack[v] = true;

        for (int w : g.getAdjacentNodes(v)) {
            if(!marked[w]) {
                findCycle(g,w);
            } else if (onStack[w]) {
                hasCycle = true;
                return;
            }
        }

        onStack[v] = false;
    }
}