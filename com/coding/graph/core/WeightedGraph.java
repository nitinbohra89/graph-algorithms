package com.coding.graph.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Category: Weighted Graph(Directed)
 *
 * Approach:
 *      Step 1: Graph with Adjacency List
 */
public class WeightedGraph {
    public int V;
    public List<Integer[]>[] edges;
    public WeightedGraph(int V) {
        this.V= V;
         edges = new List[V];
         for(int i =0 ;i<V;i++){
             edges[i] = new ArrayList<>();
         }
    }
    public void addEdge(int source, int destination, int weight){
        edges[source].add(new Integer[]{destination, weight});
    }

    public void addAllEdges(int[][] allEdges){
        for(int[] edge : allEdges){
            edges[edge[0]].add(new Integer[]{edge[1], edge[2]});
        }
    }
}
