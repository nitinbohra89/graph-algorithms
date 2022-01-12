package com.coding.graph.questions.topologicalsort;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Category: DAG(Directed Acyclic Graph)
 * Leetcode URL ::: https://leetcode.com/problems/all-paths-from-source-to-target/submissions/
 *
 * Approach:
 *      Step 1: First create Graph using Adjacency list.
 *      Step 2: Use DFS with Backtracking
 *      Step 3: At each step we will add the neighbor in the list and after coming out we will remove it again.
 *      Step 4: If we will find the target then will copy the whole path.
 */
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{4,3,1},{3,2,4},{3},{4},{}};
        AllPathsFromSourceToTarget obj = new AllPathsFromSourceToTarget();
        List<List<Integer>> allPaths = obj.findAllPath(graph);
        for(List<Integer> path : allPaths){
            System.out.println(path);
        }
    }

    public List<List<Integer>> findAllPath(int[][] graph){
        int source = 0, target = graph.length-1;
        List<List<Integer>> allPaths = new ArrayList<>();
        LinkedList<Integer> currentPath = new LinkedList<>();
        currentPath.add(source);
        dfsHelper(graph,source,target,currentPath,allPaths);
        return allPaths;
    }
    public void dfsHelper(int[][] graph, int currentNode, int target, LinkedList<Integer> currentPath, List<List<Integer>> allPaths){
        if(currentNode == target){
            allPaths.add(new LinkedList<>(currentPath));
            return;
        }
        for(int nbr: graph[currentNode]){
            currentPath.add(nbr);
            dfsHelper(graph,nbr,target,currentPath,allPaths);
            currentPath.removeLast();
        }
    }
}
