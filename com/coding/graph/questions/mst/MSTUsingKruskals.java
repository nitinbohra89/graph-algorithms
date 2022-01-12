package com.coding.graph.questions.mst;

import java.util.*;

/**
 * Category: Weighted Undirected Graph -Minimum Spanning Tree using Kruskal's Algorithm
 * Leetcode URL :::
 *
 * Idea: Prim's algorithm will use 2 things - 1
 * Approach:
 *      Step 1:
 */
public class MSTUsingKruskals {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,2,7},{1,4,6},{4,2,9},{4,3,8},{2,3,6}};
        int nodes = 4;
        MSTUsingKruskals obj = new MSTUsingKruskals();
        System.out.println(obj.mst(4, edges));
    }

    //Kruskal's Algorithm
    public int mst(int V, int[][] edges){
        DSU dsu = new DSU(V);
        Arrays.sort(edges, (o1, o2) -> o1[2]-o2[2]);
        int sum=0;
        for(int[] edge: edges){
            int source = edge[0]-1;
            int destination = edge[1]-1;
            int weight = edge[2];
            if(dsu.find(source) !=dsu.find(destination)){
                sum +=weight;
                dsu.union(source,destination);
            }
        }
        return sum;
    }


    class DSU {
        int parent[];
        int rank[];
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = -1;
                rank[i]= 1;
            }
        }
        public int find(int n){
            if(parent[n] == -1){
                return n;
            }
            return parent[n] = find(parent[n]);
        }
        public void union(int x, int y){
            int parent1 = find(x);
            int parent2 = find(y);
            if(parent1 != parent2){
                if(rank[parent1] >rank[parent2]){
                    parent[parent2] = parent1;
                    rank[parent1]+=rank[parent2];
                }else{
                    parent[parent1] = parent2;
                    rank[parent2] +=rank[parent1];
                }
            }
        }
    }
}
