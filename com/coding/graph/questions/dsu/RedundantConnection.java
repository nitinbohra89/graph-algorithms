package com.coding.graph.questions.dsu;


/**
 * Category: DSU(Dis-Joint Set Union)
 * Leetcode URL ::: https://leetcode.com/problems/redundant-connection/submissions/
 *
 * Approach:
 *      Step 1: Create DSU
 *      Step 2: Detect whether edge is creating cycle or not.
 *      Step 3: Add Edges one by one in DSU.
 *      Step 4: Before adding check their parents for both nodes, if parent is same then this new edge will create cycle.
 *
 */
public class RedundantConnection {
    public static void main(String[] args) {
        int edges[][] = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] res = findRedundantConnection(edges);
        System.out.println(res[0]+"   "+res[1]);
    }
    public static int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        int[] res = new int[2];
        for(int[] edge : edges){
            int parent1 = dsu.find(edge[0]-1);
            int parent2 = dsu.find(edge[1]-1);
            if(parent1 == parent2){
                res[0]=edge[0];
                res[1]=edge[1];
            }else{
                dsu.union(edge[0]-1,edge[1]-1);
            }
        }
        return res;
    }
}

class DSU {
    int V;
    int[] parent;
    DSU(int V){
        this.V= V;
        parent = new int[V];
        for(int i=0;i<V;i++){
            parent[i]=-1;
        }
    }

    public int find(int node){
        if(parent[node] == -1){
            return node;
        }
        return find(parent[node]);
    }

    public void union(int node1, int node2){
        int parent1= find(node1);
        int parent2= find(node2);
        if(parent1 !=parent2){
            parent[parent1] = parent2;
        }
    }
}