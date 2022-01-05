package com.coding.graph.questions.bfs;

import java.util.*;

/**
 * Category: BFS(Breadth First Search based
 * Leetcode URL ::: https://leetcode.com/problems/word-ladder/
 *
 * Approach:
 *      Step 1: Write a function to generate all possible variation of a character with a-z.
 *      Step 2: So from a word we can go to all the words which are having differnce of one character.
 *      Step 3: Now put starting word in queue.
 *      Step 4: take word from queue, generate all possible variations of that word after chaging one character.
 *      Step 5: Check if any variation word is part of the given dictionary or not. If it is the part then add that to the queue.
 *      Step 6: If we found the lastWord then return the level.
 */
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
