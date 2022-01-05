package com.coding.graph.questions.dfs;

import com.coding.graph.core.Graph;

import java.util.*;

/**
 * Category: DFS(Depth First Search based
 * HackerRank URL ::: https://www.hackerrank.com/challenges/journey-to-the-moon/problem
 *
 * Approach:
 *      Step 1: Build a graph and identify how many sub graph(connected graphs) are getting created.
 *      Step 2: Pick up a non visited node and call DFS for checking all its neighbors and this will be considered as 1 subgraph(connected graph)
 *      Step 3: Again check if any node is not visited then again start DFS from that node.
 *      Step 4: Maintain List of nodes present in each sub graph.
 *      Step 5: Now if each country is having one astronaut then total no of pairs for n countries will be (n*(n-1))/2.
 *      Step 6: Now if any country is having more than 1 astronaut then that pair should be deducted from total no of pairs.
 */
public class AstronautPairs {
    public static void main(String[] args) {
        List<List<Integer>> astronauts = new ArrayList<>();
        List<Integer> one = Arrays.asList(new Integer[]{0,1});
        List<Integer> two = Arrays.asList(new Integer[]{2,3});
        List<Integer> three = Arrays.asList(new Integer[]{0,4});
        astronauts.add(one);
        astronauts.add(two);
        astronauts.add(three);
        System.out.println(astronautPair(5, astronauts));

    }

    public static int astronautPair(int N, List<List<Integer>> astronauts) {
        Graph g = new Graph(N);
        for(List<Integer> edge: astronauts){
            g.addEdge(edge.get(0),edge.get(1),true);
        }
        List<Integer> pairs = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<N;i++){
            if(!visited.contains(i)){
                visited.add(i);
                pairs.add(dfs(g,i,visited));
            }
        }

        int totalPairs = (N*(N-1))/2;
        for(Integer j : pairs){
            totalPairs = totalPairs - (j*(j-1))/2;
        }
        return totalPairs;
    }

    public static int dfs(Graph g, int node, Set<Integer> visited){
        int totalNodes = 1;
        for(Integer n : g.edges[node]){
            if(!visited.contains(n)) {
                visited.add(n);
                totalNodes += dfs(g, n, visited);
            }
        }
        return totalNodes;
    }
}
