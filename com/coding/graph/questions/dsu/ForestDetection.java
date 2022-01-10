package com.coding.graph.questions.dsu;

public class ForestDetection {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{0,2},{3,4},{4,5}};
        System.out.println(isForest(6, edges));
    }

    public static boolean isForest(int trees, int[][] edges){
        DSUGraph dsu = new DSUGraph(trees);
        for(int[] edge: edges){
            int parent1 = dsu.find(edge[0]);
            int parent2 = dsu.find(edge[1]);
            if(parent1==parent2){
                return false;
            }else{
                dsu.union(edge[0],edge[1]);
            }
        }
        return true;
    }
}
