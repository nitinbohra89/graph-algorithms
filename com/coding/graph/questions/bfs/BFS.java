package com.coding.graph.questions.bfs;

import com.coding.graph.core.Graph;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        Graph g = Graph.getDefaultGraph();
        g.printGraph();
        bfs(g);
    }

    public static void bfs(Graph g){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(1);
        visited.add(1);
        while (!queue.isEmpty()){
            int node = queue.poll();
            System.out.println(node);
            for(int n : g.edges[node]){
                if(!visited.contains(n)){
                    queue.add(n);
                    visited.add(n);
                }
            }
        }
    }
}
