package com.coding.graph.questions.bfs;

import com.coding.graph.core.Graph;

import java.util.*;

public class ShortestPath {

    public static void main(String[] args) {
        Graph g = Graph.getDefaultGraph();
        shortestPath(g,4);
    }

    public static void shortestPath(Graph g, int target){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int[] parent = new int[g.V];
        int[] distance = new int[g.V];
        for(int i=0;i<g.V;i++){
            parent[i] = i;
            distance[i]=0;
        }

        queue.add(1);
        visited.add(1);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int child: g.edges[node]){
                if(!visited.contains(child)) {
                    parent[child] = node;
                    visited.add(child);
                    queue.add(child);
                }
            }
        }

        System.out.println("-------Parents-------");
        for(int i=0;i<g.V;i++){
            System.out.println(i+"   "+ parent[i]);
        }


        System.out.println("Target Parent: "+ target);
        int targetParent = target;
        while(parent[targetParent] != targetParent){
            System.out.println(targetParent);
            targetParent = parent[targetParent];
        }
        System.out.println(targetParent);
    }
}
