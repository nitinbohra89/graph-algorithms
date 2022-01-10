package com.coding.graph.questions.cycle;

import com.coding.graph.core.Graph;

import java.util.HashSet;
import java.util.Set;
/**
 * Category: Cycle in a Graph
 * Leetcode URL :::
 *
 * Approach:
 *      Step 1: First create Graph using Adjacency list.
 *      Step 2: Use DFS with passing additional parent to detect the cycle.
 *      Step 3: For each neighbor of current node check if it is visited or not.
 *      Step 4: If neighbor is visited then check whether it is parent of that node or not.
 *      Step 5: If it is not parent it means that neighbor has been visited previously in DFS traversal.
 *      Step 6: Now we can say that there is a cycle in the graph.
 */
public class CycleDetectionInUndirectedGraph {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1,true);
        g.addEdge(0,2,true);
        g.addEdge(1,2,true);
        g.addEdge(0,3,true);
        g.addEdge(3,4,true);
        System.out.println(hasCycle(g));
    }

    public static boolean hasCycle(Graph g){
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<g.V;i++){
            if(!visited.contains(i)){
                boolean hasCycle = detectCycleByDFS(g,i,-1,visited);
                if(hasCycle) return hasCycle;
            }
        }
        return false;
    }

    public static boolean detectCycleByDFS(Graph g, int node, int parent, Set<Integer> visited){
        visited.add(node);
        boolean hasCycle = false;
        for(Integer neighbor : g.edges[node]){
            if(!visited.contains(neighbor)){
                hasCycle = detectCycleByDFS(g,neighbor,node,visited);
                if (hasCycle){
                    return true;
                }
            }else{
                if(neighbor != parent){
                    return  true;
                }
            }
        }
        return false;
    }
}
