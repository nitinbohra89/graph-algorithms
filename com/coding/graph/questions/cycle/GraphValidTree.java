package com.coding.graph.questions.cycle;

import com.coding.graph.core.Graph;

/**
 * Category: Cycle in a Graph
 * Leetcode URL ::: https://leetcode.com/problems/graph-valid-tree/
 *
 * Approach:
 *      Step 1: We can use DSU data structure for that.
 *      Step 2: Start adding edges one by one.
 *      Step 3: If nodes belongs to the same parent it means these nodes have already been added in graph and this new edge will make a cycle.
 */
public class GraphValidTree {
    public static void main(String[] args) {
        GraphValidTree obj = new GraphValidTree();
        System.out.println(obj.validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}}));
    }
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int[] edge : edges){
            int parent1 = dsu.find(edge[0]);
            int parent2 = dsu.find(edge[1]);
            if(parent1 == parent2){
                return false;
            }
            dsu.union(edge[0],edge[1]);
        }
        int totalRootNodes = 0;
        for(int i=0;i<n;i++){
            if(dsu.parent[i] == -1){
                totalRootNodes++;
            }
        }
        if(totalRootNodes > 1){
            return false;
        }
        return true;
    }


    class DSU {
        int parent[];
        DSU(int V){
            parent = new int[V];
            for(int i=0;i<V;i++){
                parent[i] = -1;
            }
        }

        public int find(int n){
            if(parent[n] == -1){
                return n;
            }
            return parent[n] = find(parent[n]);
        }

        public void union(int n1, int n2){
            int parent1 = find(n1);
            int parent2 = find(n2);
            if(parent1 != parent2){
                parent[parent1] = parent2;
            }
        }
    }

}
