package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = preprocess(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses]; // mimic stack to record courses in current traversal
        for(int i=0; i<adjList.length; i++) {
            if(hasCycle(adjList, visited, onStack, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(List<Integer>[] adjList, boolean[] visited, boolean[] onStack, int v) {
        if(!visited[v]) {
            visited[v] = true;
            onStack[v] = true;
            for(int i=0; i<adjList[v].size(); i++) {
                int vertex = adjList[v].get(i);
                if(!visited[vertex]) {
                    if(hasCycle(adjList, visited, onStack, vertex)) {
                        return true;
                    }
                } else if(onStack[vertex]) {
                    return true;
                }
            }
        }
        onStack[v] = false; //remove v from stack
        return false;
    }
    private List<Integer>[] preprocess(int numCourses, int[][] prerequisites) {
         List<Integer>[] adjList = new ArrayList[numCourses];
            for(int i=0;i<numCourses;i++) {
                adjList[i] = new ArrayList();
            }
            for(int i=0; i<prerequisites.length; i++) {
                adjList[prerequisites[i][0]].add(prerequisites[i][1]);
            }    
       return adjList;
    }
}
