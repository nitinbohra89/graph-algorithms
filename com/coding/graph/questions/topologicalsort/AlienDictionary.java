package com.coding.graph.questions.topologicalsort;

import java.util.*;

/**
 * Category: DAG(Directed Acyclic Graph) -Topological Sort
 * Leetcode URL ::: https://leetcode.com/problems/alien-dictionary/
 *
 * Idea: Dictionary is order set of words , based on that we can extract ordering of alphabets by comparing alphabets of one word to another.
 * Approach:
 *      Step 1: First We will use Map for creating Graph and keeping inDegeree information because each node is like alphabet character.
 *      Step 2: After Initializing Graph and InDegree Maps with nodes, we will traverse through the dictionary.
 *      Step 3: Compare adjacent words and compare character at each index if it is same then do nothing.
 *      Step 4: If it is different then we can get the ordering of those 2 characters and will add edge and increase indegree.
 *      Step 5: After preparing Graph, we can perform topological sorting on that which will generate order of alphabets.
 */
public class AlienDictionary {
    public static void main(String[] args) {
        String[] dictionary = new String[]{"wrt","wrf","er","ett","rftt"};
        System.out.println(alienOrder(dictionary));
    }

    public static String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character,Integer> inDegree = new HashMap<>();
        //Finding all Nodes and setting up their Indegree to Zero
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.put(c,new ArrayList<>());
                inDegree.put(c,0);
            }
        }

        //Add All edges to the graph
        for(int i=1;i<words.length;i++){
            String s1 = words[i-1];
            String s2 = words[i];
            //Edge case (s1=> abc , s2 = ab => s2 should have come first in order, so order is wrong and we can return ""
            if(s1.startsWith(s2) && s1.length()>s2.length()){
                return "";
            }
            for(int idx=0;idx<Math.min(s1.length(),s2.length());idx++){
                if(s1.charAt(idx) != s2.charAt(idx)){
                    graph.get(s1.charAt(idx)).add(s2.charAt(idx));
                    inDegree.put(s2.charAt(idx),inDegree.get(s2.charAt(idx))+1);
                    break;
                }
            }
        }

        //Find all Root nodes having indegree zero and start traversal using Queue
        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character,Integer> node: inDegree.entrySet()){
            if(node.getValue() ==0){
                queue.add(node.getKey());
            }
        }
        StringBuilder sd = new StringBuilder();
        while (!queue.isEmpty()){
            char node = queue.poll();
            sd.append(node);
            for(char nbr : graph.get(node)){
                inDegree.put(nbr,inDegree.get(nbr)-1);
                if(inDegree.get(nbr) == 0){
                    queue.add(nbr);
                }
            }
        }

        if(inDegree.size()> sd.length()){
            return "";
        }
        return sd.toString();
    }
}

