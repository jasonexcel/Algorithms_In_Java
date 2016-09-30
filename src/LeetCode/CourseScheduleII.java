package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Shaun on 9/25/2016.
 */
public class CourseScheduleII {
    public static void main(String[] args) {

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = preprocess(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        List<Integer> arr = new ArrayList<>();

        for(int i=0; i<adjList.length; i++) {
            if(!visited[i]) {
                if(getOrder(adjList, visited, onStack, arr, i)) {
                    return new int[0];
                }
            }
        }
        int[] res = new int[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }

    private boolean getOrder(List<Integer>[] adjList, boolean[] visited, boolean[] onStack, List<Integer> arr, int v) {
        visited[v] = true;
        onStack[v] = true;
        for(int i=0; i<adjList[v].size(); i++) {
            int vertex = adjList[v].get(i);
            if(!visited[vertex]) {
                if(getOrder(adjList, visited, onStack, arr, vertex)) {
                    return true;
                }
            } else if(onStack[vertex]) {
                return true;
            }

        }
        onStack[v] = false;
        arr.add(v);
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
