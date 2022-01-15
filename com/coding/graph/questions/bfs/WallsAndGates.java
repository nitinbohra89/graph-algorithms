package com.coding.graph.questions.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Category: Cycle in a Graph
 * Leetcode URL :::https://leetcode.com/problems/walls-and-gates/
 *
 * Approach:
 *      Step 1: We can use BFS for this and can traverse level by level.
 *      Step 2: For each Gate consider that as root node and distance as 0.
 *      Step 3: Check neighbors in all 4 directions - left, right, top, bottom
 *      Step 4: If the value of all these neighbors is not 0 and not -1 then
 *      Step 5: Check if it's value is > level then update value as level and add it to the Queue again.
 */
public class WallsAndGates {

    public static void main(String[] args) {
        int rooms[][] = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        WallsAndGates obj = new WallsAndGates();
        obj.wallsAndGates(rooms);
    }
    public void wallsAndGates(int[][] rooms) {
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j] == 0){
                    bfs(rooms,i,j);
                }
            }
        }
    }
    public void bfs(int[][] rooms , int row, int column){
        Queue<Pair[]> queue = new LinkedList<>();
        queue.add(new Pair[]{new Pair(row,column), new Pair(-1,-1)});
        int level =-1;
        int dimensions[][] = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair[] nodeData = queue.poll();
                Pair node = nodeData[0];
                Pair parent = nodeData[1];
                // System.out.println("x::"+ node.getKey()+"   y::"+node.getValue()+"  level::"+level);
                rooms[node.getKey()][node.getValue()] = level;
                for(int[] dimension: dimensions){
                    int x = node.getKey()+dimension[0];
                    int y = node.getValue()+dimension[1];
                    if(x>=0 && y>=0 && x<rooms.length && y< rooms[0].length){
                        if(rooms[x][y] == 0 || rooms[x][y] == -1 || (x == parent.getKey() && y == parent.getValue())){
                            continue;
                        }else{
                            if(rooms[x][y] > level){
                                rooms[x][y] = Math.min(rooms[x][y], level);
                                queue.add(new Pair[]{new Pair(x,y), node});
                            }

                        }
                    }
                }
            }
        }
    }

    public class Pair {
        private int key;
        private int value;
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
        // standard getters and setters
        public int getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }
    }
}
