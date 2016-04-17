package LeetCode;

import java.util.ArrayList;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] adjList = preprocess(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        for(int i=0; i<adjList.length; i++) {
            if(!visited[i]) {
                 if(hasCycle(adjList, visited, onStack, i)) {
                     return false;
                 }
            }
        }
        return true;
    }
    
    private boolean hasCycle(ArrayList[] adjList, boolean[] visited, boolean[] onStack, int v) {
        visited[v] = true;
        onStack[v] = true;
        for(int i=0; i<adjList[v].size(); i++) {
            int vertex = (int)adjList[v].get(i);
            if(!visited[vertex]) {
                if(hasCycle(adjList, visited, onStack, vertex)) {
                    return true;
                }
            } else if(onStack[vertex]) {
                return true;
            } 
        }
        onStack[v] = false;
        return false;
    }
    private ArrayList[] preprocess(int numCourses, int[][] prerequisites) {
         ArrayList[] adjList = new ArrayList[numCourses];
            for(int i=0;i<numCourses;i++) {
                adjList[i] = new ArrayList();
            }
            for(int i=0; i<prerequisites.length; i++) {
                adjList[prerequisites[i][0]].add(prerequisites[i][1]);
            }    
       return adjList;
    }
}
