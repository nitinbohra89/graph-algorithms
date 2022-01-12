package com.coding.graph.questions.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Category: Weighted Undirected Graph -Minimum Spanning Tree using Kruskal's Algorithm
 * Leetcode URL ::: https://leetcode.com/problems/min-cost-to-connect-all-points/
 *
 * Idea: Use Kruskal's algorithm.
 * Approach:
 *      Step 1:
 */
public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        MinCostToConnectAllPoints obj = new MinCostToConnectAllPoints();
        System.out.println(obj.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
    }
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        for(int i =0; i<points.length;i++){
            int[] point1 = points[i];
            for(int j=i+1;j<points.length;j++){
                int[] point2 = points[j];
                int weight = Math.abs(point1[0]-point2[0]) + Math.abs(point1[1]-point2[1]);
                edges.add(new int[]{weight,i,j});
            }
        }
        Collections.sort(edges, (a, b)-> (a[0]-b[0]));
        DSU dsu = new DSU(points.length);
        int sum =0;
        for(int[] edge: edges ){
            int weight = edge[0];
            int node1 = edge[1];
            int node2 = edge[2];
            if(dsu.find(node1) != dsu.find(node2)){
                sum+=weight;
                dsu.union(node1,node2);
            }
        }
        return sum;
    }
}

class DSU {
    int parent[];
    int rank[];
    DSU(int V){
        parent = new int[V];
        rank = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = -1;
            rank[i] = 1;
        }
    }

    public int find(int i){
        if(parent[i] == -1){
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public void union(int n1,int n2){
        int parent1= find(n1);
        int parent2 = find(n2);
        if(parent1 != parent2){
            if(rank[parent1] > rank[parent2]){
                parent[parent2] = parent1;
                rank[parent1] +=rank[parent2];
            }else{
                parent[parent1] = parent2;
                rank[parent2] +=rank[parent1];
            }
        }
    }
}
