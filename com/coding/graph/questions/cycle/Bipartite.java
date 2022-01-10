package com.coding.graph.questions.cycle;

import com.coding.graph.core.Graph;

/**
 * Category: Cycle in a Graph
 * Leetcode URL ::: https://leetcode.com/problems/possible-bipartition/
 *
 * Approach:
 *      Step 1: Create UnDirected Graph using Adjacency List
 *      Step 2: We will use Cycle Detection Method in Directed Graph
 */
public class Bipartite {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1,true);
        g.addEdge(0,2,true);
        g.addEdge(0,3,true);
        g.addEdge(1,2,true);
        g.addEdge(2,3,true);
        System.out.println(canBipartite(g));
    }

    public static boolean canBipartite(Graph g){
        int[] color = new int[g.V];
        for(int i=0;i<g.V;i++){
            if(color[i] == 0){
                color[i] = 1;
                boolean canBipart = bipartiteHelper(g,i,color,1);
                if(!canBipart)
                    return false;
            }
        }
        return true;
    }
    public static boolean bipartiteHelper(Graph g, int node, int[] visitedColor, int color){
        visitedColor[node] = color;
        for(int nbr: g.edges[node]){
            if(visitedColor[nbr] == 0){
                boolean check = bipartiteHelper(g,nbr,visitedColor,3-color);
                if(!check){
                    return false;
                }
            }else if(visitedColor[nbr] ==color){
                return false;
            }
        }
        return true;
    }
}
