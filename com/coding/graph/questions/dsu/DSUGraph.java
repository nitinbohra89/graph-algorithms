package com.coding.graph.questions.dsu;

public class DSUGraph {
    int V;
    int[] parent;
    DSUGraph(int V){
        this.V=V;
        this.parent = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = -1;
        }
    }

    public int find(int node){
        if(parent[node] == -1){
            return node;
        }
        return find(parent[node]);
    }

    public void union(int node1, int node2){
        int parent1 = find(node1);
        int parent2 = find(node2);
        if(parent1 !=parent2){
            parent[parent1] = parent2;
        }
    }
}
