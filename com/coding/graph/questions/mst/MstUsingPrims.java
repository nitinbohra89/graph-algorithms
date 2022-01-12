package com.coding.graph.questions.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Category: Weighted Undirected Graph -Minimum Spanning Tree using Prim's Algorithm
 * Leetcode URL :::
 *
 * Idea: Prim's algorithm will use 2 things - 1 visited vertex array, Active edges in priority queue
 * Approach:
 *      Step 1:
 */
public class MstUsingPrims {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,2,7},{1,4,6},{4,2,9},{4,3,8},{2,3,6}};
        int nodes = 4;
        List<int[]>[] graph = createGraph(4,edges);
        System.out.println(mst(graph));
    }
    public static List<int[]>[] createGraph(int V, int edges[][]){
        List<int[]>[] graph = new List[V];
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int source = edge[0]-1;
            int destination = edge[1]-1;
            int weight = edge[2];
            graph[source].add(new int[]{weight,destination});
        }

        return graph;
    }

    //Prim's Algorithm
    public static int mst(List<int[]>[] graph){
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<int[]> queue = new PriorityQueue<>(10, (a, b) -> a[0]-b[0]);
        queue.add(new int[]{0,0});
        //visited[0]= true;
        int sum = 0;
        while(!queue.isEmpty()){
            int[] edge = queue.poll();
            int node = edge[1];
            int weight = edge[0];
            if(visited[node]){
                continue;
            }else{
                visited[node]= true;
                sum+=weight;
                for(int[] nbr: graph[node]){
                    queue.add(nbr);
                }
            }
        }
        return sum;
    }
}
