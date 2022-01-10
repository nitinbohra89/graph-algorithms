package com.coding.graph.questions.topologicalsort;

import java.util.*;

/**
 * Category: DAG(Directed Acyclic Graph) - Topological Sort
 * Leetcode URL ::: https://leetcode.com/problems/course-schedule-ii/
 *
 * Approach:
 *      Step 1: First create Directed Graph using Adjacency list.
 *      Step 2: Calculate inDegree for all the courses
 *      Step 3: Put all root courses for which indegree is zero.
 *      Step 4: Iterate through the queue and reduce in-degree for all neighbors of the current node.
 *      Step 5: Once the in-degree reaches to zero then add it to queue.
 *      Step 6: After poll from queue add that node to starting of the resultant linkedlist.
 */
public class CourseScheduleII {
    public static void main(String[] args) {
        CourseScheduleII obj = new CourseScheduleII();
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int[] res = obj.findOrder(4, prerequisites);
        System.out.println("Length::"+res.length);
        Arrays.stream(res).forEach(i -> System.out.print(i+"  "));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        DirectedGraph graph = new DirectedGraph(numCourses);

        int[] inDegree = new int[numCourses];

        for(int edge[] : prerequisites){
            graph.addEdge(edge[0],edge[1]);
        }

        for(int i=0;i<numCourses;i++){
            System.out.println(i+"=> "+graph.edges[i]);
            for(int edge : graph.edges[i]){
                inDegree[edge]++;
            }
        }
        // Add Root Nodes
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        //Iterate through the Queue
        while (!queue.isEmpty()){
            int node = queue.poll();
            res.addFirst(node);
            for(int edge: graph.edges[node]){
                inDegree[edge]--;
                if(inDegree[edge] == 0){
                    queue.add(edge);
                }
            }
        }
        System.out.println("Length::::"+ res.size());
        if(res.size() == numCourses){
            return res.stream().mapToInt(i->i).toArray();
        }
        return new int[0];
    }

}

class DirectedGraph{
    int V;
    List<Integer>[] edges;
    DirectedGraph(int V){
        this.V=V;
        edges = new List[V];
        for(int i =0; i<V; i++){
            edges[i] = new ArrayList<>();
        }
    }
    public void addEdge(int from, int to){
        edges[from].add(to);
    }
}
