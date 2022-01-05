package com.coding.graph.questions.dfs;

import java.util.*;

/**
 * Category: DFS(Depth First Search based
 * Leetcode URL ::: https://leetcode.com/problems/reconstruct-itinerary/
 *
 * Approach:
 *      Step 1: Build Graph with Adjacency list as LinkedList
 *      Step 2: Sort adjacency list for lexicographically sorting
 *      Step 3: Do DFS but make sure delete node from Adjacency LinkedList after using it.
 */
public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> ticket1 = List.of("JFK","SFO");
        List<String> ticket2 = List.of("JFK","ATL");
        List<String> ticket3 = List.of("SFO","ATL");
        List<String> ticket4 = List.of("ATL","JFK");
        List<String> ticket5 = List.of("ATL","SFO");

        tickets.addAll(List.of(ticket1,ticket2,ticket3,ticket4,ticket5));
        Map<String, LinkedList<String>> graph = buildItineraryGraph(tickets);

        LinkedList<String> route = new LinkedList<>();
        reconstructItinerary(graph,"JFK", route);
        System.out.println(route);
    }

    public static void reconstructItinerary(Map<String, LinkedList<String>> graph, String source, LinkedList<String> route){
        if(graph.containsKey(source)){
            LinkedList<String> destinations = graph.get(source);
            while (!destinations.isEmpty()){
                String destination = destinations.pollFirst();
                reconstructItinerary(graph,destination,route);
            }
        }
        route.offerFirst(source);
    }

    public static Map<String, LinkedList<String>>  buildItineraryGraph(List<List<String>> tickets){
        Map<String, LinkedList<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            String source = ticket.get(0);
            String destination = ticket.get(1);
            if(!graph.containsKey(source)){
                graph.put(source, new LinkedList<>());
            }
            graph.get(source).add(destination);
        }

        for(Map.Entry<String, LinkedList<String>> node : graph.entrySet()){
            Collections.sort(node.getValue());
            System.out.println(node.getKey()+"    "+ node.getValue());
        }
        return graph;
    }
}
