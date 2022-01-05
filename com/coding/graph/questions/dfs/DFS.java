package com.coding.graph.questions.dfs;

import com.coding.graph.core.Graph;

import java.util.HashSet;
import java.util.Set;

public class DFS {
    public static void main(String[] args) {
        Graph g = Graph.getDefaultGraph();
        dfs(g);
    }

    public static void dfs(Graph g){
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        dfsHelper(1, visited, g);
    }
    public static void dfsHelper(int node, Set<Integer> visited, Graph g){
        System.out.println(node);
        for(Integer neighbor : g.edges[node]){
            if(!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfsHelper(neighbor, visited, g);
            }
        }
    }
}
