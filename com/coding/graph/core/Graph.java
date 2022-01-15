package com.coding.graph.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Category: Graph(Directed/Undirected)
 *
 * Approach:
 *      Step 1: Graph with Adjacency List
 *      Step 2: If graph is directed then pass biDir -> True
 *      Step 3: If graph is undirected then pass biDir -> False
 */
public class Graph {
    public int V;
    public List<Integer>[] edges;
    public Graph(int V){
        this.V =V;
        this.edges = new List[V];
        for(int i=0;i<edges.length;i++){
            edges[i] = new ArrayList();
        }
    }
    public void addEdge(int source, int destination, boolean biDir){
        if(biDir){
            edges[source].add(destination);
            edges[destination].add(source);
        }else{
            edges[source].add(destination);
        }
    }

    public void printGraph(){
        for(int i=0;i<V;i++){
            System.out.print(i+"  => ");
            for(int j : edges[i]){
                System.out.print(j+"   ");
            }
            System.out.println();
        }
    }



    public static Graph getDefaultGraph(){
        Graph g = new Graph(7);
        g.addEdge(1,2,true);
        g.addEdge(1,0,true);
        g.addEdge(0,4,true);
        g.addEdge(2,3,true);
        g.addEdge(3,4,true);
        g.addEdge(3,5,true);
        g.addEdge(4,5,true);
        g.addEdge(5,6,true);
        return g;
    }
}
