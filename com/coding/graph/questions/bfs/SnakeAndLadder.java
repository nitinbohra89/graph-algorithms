package com.coding.graph.questions.bfs;

import com.coding.graph.core.Graph;

import java.util.HashMap;
import java.util.Map;

public class SnakeAndLadder {
    public static void main(String[] args) {
        Map<Integer,Integer> snakes = new HashMap<>();
        snakes.put(17,4);snakes.put(20,6);snakes.put(34,12);snakes.put(24,16);snakes.put(32,30);
        Map<Integer,Integer> ladders = new HashMap<>();
        ladders.put(2,15);ladders.put(5,7);ladders.put(9,27);ladders.put(18,29);ladders.put(25,35);

        Graph g = createGraph(36,snakes, ladders);
        g.printGraph();
        ShortestPath.shortestPath(g,36);
    }

    public static Graph createGraph(int n, Map<Integer,Integer> snakes, Map<Integer,Integer> ladders){
        Graph g = new Graph(n+1);
        for(int i = 1; i<n; i++){
            for(int dice=1;dice<=6;dice++){
                int key = i+dice;
                if(ladders.containsKey(key)){
                    g.addEdge(i,ladders.get(key),false);
                }else if(snakes.containsKey(key)){
                    g.addEdge(i,snakes.get(key),false);
                }else{
                    if(key<= n)
                        g.addEdge(i,key,false);
                }
            }
        }
        return g;
    }
}
