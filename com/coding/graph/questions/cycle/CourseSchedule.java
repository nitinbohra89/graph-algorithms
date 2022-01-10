package com.coding.graph.questions.cycle;

import com.coding.graph.core.Graph;
/**
 * Category: Cycle in a Graph
 * Leetcode URL ::: https://leetcode.com/problems/course-schedule/
 *
 * Approach:
 *      Step 1: Create Directed Graph using Adjacency List
 *      Step 2: We will use Cycle Detection Method in Directed Graph
 */
public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0},{0,1}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);
        for(int[] pre: prerequisites){
            g.addEdge(pre[0],pre[1],false);
        }
        boolean hasCycle = CycleDetectionInDirectedGraph.hasCycle(g);
        if(hasCycle){
            return false;
        }else{
            return true;
        }

    }
}
