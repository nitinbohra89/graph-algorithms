package com.coding.graph.questions.dfs;

/**
 * Category: DFS(Depth First Search based
 * Leetcode URL ::: https://leetcode.com/problems/max-area-of-island/
 *
 * Approach:
 *      Step 1: Traverse Grid Row by row.
 *      Step 2: If node value is 1 then use DFS and check all 4 dimensions Left, right, up down
 *      Step 3: If Dimension is valid and value is 1 then call DFS on that dimension after setting value to 0
 *      Step 4: For each value 1 call DFS for all its neighbors and sum the returned values.
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int totalArea = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j] == 1){
                    int tempArea = totalArea(i,j,grid);
                    totalArea = Math.max(tempArea, totalArea);
                }
            }
        }
        return totalArea;
    }

    public static int totalArea(int row, int column, int[][] grid){
        int totalArea = 1;
        grid[row][column] = 0;
        int[][] dimensions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] dimension : dimensions){
            int x = row+dimension[0];
            int y= column+dimension[1];
            if(x>=0&& y>=0 && x<grid.length && y<grid[0].length && grid[x][y] == 1){
                totalArea+= totalArea(x,y,grid);
            }
        }
        return totalArea;
    }
}
