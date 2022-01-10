package com.coding.graph.questions.cycle;

import java.util.ArrayList;
import java.util.List;
/**
 * Category: Cycle in a Graph
 * Leetcode URL :::https://leetcode.com/problems/detect-cycles-in-2d-grid/
 *
 * Approach:
 *      Step 1: First convert Grid into Graph.
 *      Step 2: convert each row,column to index by this formula row*grid.length+column
 *      Step 3: Check adjacent block in right and down side, if the values are same then add edge between them.
 *      Step 4: Once graph will be ready then you can use Cycle Detection in Undirected Graph approach.
 */
public class CycleDetectionIN2DGrid {
    public static void main(String[] args) {
        char[][] grid= new char[][]{{'c','c','c','a'},{'c','d','c','c'},{'c','c','e','c'},{'f','c','c','c'}};
        CycleDetectionIN2DGrid obj= new CycleDetectionIN2DGrid();
        System.out.println(obj.containsCycle(grid));
    }
    public boolean containsCycle(char[][] grid) {
        int [][]dimensions = new int[][]{{0,1},{1,0}};
        Graph g = new Graph(grid.length*grid[0].length);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                for(int[] dim: dimensions){
                    int x = i+dim[0];
                    int y = j+dim[1];
                    if(x<grid.length && y<grid[0].length && grid[i][j] == grid[x][y]){
                        int source = grid[0].length*i+j;
                        int destination = grid[0].length*x+y;
                        g.addEdge(source,destination);
                    }
                }
            }
        }
        boolean visited[]= new boolean[grid.length*grid[0].length];
        for(int i=0;i<g.V;i++){
            if(!visited[i]){
                boolean hasCycle = hasCycle(g,i,-1,visited);
                if(hasCycle){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasCycle(Graph g, int node, int parent, boolean visited[]){
        visited[node] = true;
        for(int nbr: g.edges[node]){
            if(!visited[nbr]){
                boolean hasCycle = hasCycle(g,nbr,node,visited);
                if(hasCycle){
                    return true;
                }
            }else{
                if(nbr != parent)
                    return true;
            }
        }
        return false;
    }
}


class Graph {
    int V;
    List<Integer>[] edges;
    Graph(int V){
        this.V=V;
        edges = new List[V];
        for(int i=0;i<V;i++){
            edges[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination){
        edges[source].add(destination);
        edges[destination].add(source);
    }
}