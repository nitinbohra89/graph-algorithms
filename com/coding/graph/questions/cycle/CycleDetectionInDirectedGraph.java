package com.coding.graph.questions.cycle;

import com.coding.graph.core.Graph;

import java.util.HashSet;
import java.util.Set;
/**
 * Category: Cycle in a Graph
 * Leetcode URL :::
 *
 * Approach:
 *      Step 1: Create Directed Graph using Adjacency List
 *      Step 2: We will use DFS algorithm with addition Stack which will keep track of the whole path
 *      Step 3: Each time we will set node in stack before going to it's neighbor and after traversal again we will reset stack.
 *      Step 4: It is directed graph so no need to check about the parent.
 *      Step 5: For each neighbor, we will check whether it has been visited previously or not.
 *      Step 6: If neighbor is in stack then we will return true.
 */
public class CycleDetectionInDirectedGraph {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0,1,false);
        g.addEdge(1,2,false);
        g.addEdge(2,3,false);
        g.addEdge(3,0,false);
        g.addEdge(0,4,false);
        g.addEdge(0,5,false);
        g.addEdge(5,4,false);
        System.out.println(hasCycle(g));
    }

    public static boolean hasCycle(Graph g){
        Set<Integer> visited = new HashSet<>();
        boolean[] stack = new boolean[g.V];
        for(int i=0;i<g.V;i++){
            if(!visited.contains(i)){
                boolean hasCycle = detectCycleByDFS(g,i,stack,visited);
                if(hasCycle) return hasCycle;
            }
        }
        return false;
    }

    public static boolean detectCycleByDFS(Graph g, int node, boolean stack[], Set<Integer> visited){
        visited.add(node);
        stack[node] = true;
        for(Integer neighbor : g.edges[node]){
            if(stack[neighbor]){
                return true;
            }
            if(!visited.contains(neighbor)){
                boolean hasCycle = detectCycleByDFS(g,neighbor,stack,visited);
                if (hasCycle){
                    return true;
                }
            }
        }
        stack[node] = false;
        return false;
    }
}
