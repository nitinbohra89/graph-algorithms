package com.coding.graph.questions.bfs;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        List<String> dictionary = List.of(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(wordLadder("hit","dog", dictionary));
    }

    public static int wordLadder(String beginWord, String endWord, List<String> dictionary){
        Queue<String> queue = new LinkedList();
        Set<String> dict = new HashSet<>(dictionary);
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            System.out.println("Level::"+level);
            for(int i=0;i<size;i++){
                String word = queue.poll();
                if(word.equals(endWord)){
                    return level+1;
                }
                List<String> neighbors = neighbors(word);
                //System.out.println("Current::"+ word+"  :::"+ neighbors);
                //System.out.println("Dictionary::"+ dict);
                for (String neighbor : neighbors){
                    if(dict.contains(neighbor) && !visited.contains(neighbor)){
                        System.out.println(neighbor);
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return 0;
    }

    public static List<String> neighbors(String word){
        char[] wordArray = word.toCharArray();
        List<String> neighbors = new ArrayList<>();
        for(int i=0;i<word.length();i++){
            char temp = word.charAt(i);
            for( char c= 'a'; c<='z'; c++){
                wordArray[i] = c;
                neighbors.add(new String(wordArray));
            }
            wordArray[i] = temp;
        }
        return neighbors;
    }
}
