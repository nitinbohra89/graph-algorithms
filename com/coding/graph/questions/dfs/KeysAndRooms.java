package com.coding.graph.questions.dfs;

import java.util.*;

/**
 * Category: DFS(Depth First Search based
 * Leetcode URL ::: https://leetcode.com/problems/keys-and-rooms/
 *
 * Approach:
 *      Step 1: Start from Room zero
 *      Step 2: Collection All keys and go to their respective room
 *      Step 3: Maintain one visited Set to keep the track of all visited rooms.
 *      Step 4: Check visited room set size if all rooms are visited then return true else false
 */
public class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> zero = Arrays.asList(new Integer[]{1,3});
        List<Integer> one = Arrays.asList(new Integer[]{3,0,1});
        List<Integer> two = Arrays.asList(new Integer[]{2});
        List<Integer> three = Arrays.asList(new Integer[]{0});
        rooms.add(zero);
        rooms.add(one);
        rooms.add(two);
        rooms.add(three);
        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms){
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        visitRoom(0,rooms,visited);
        if(rooms.size() == visited.size()){
            return true;
        }
        return false;
    }

    public static  void visitRoom(int room, List<List<Integer>> rooms, Set<Integer> visited){
        for(Integer key : rooms.get(room)){
            if(!visited.contains(key)){
                visited.add(key);
                visitRoom(key,rooms,visited);
            }
        }
    }
}
