package com.coding.graph.questions.dsu;

/**
 * Category: DSU(Dis-joint Set Union)
 * Leetcode URL ::: https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 *
 * Approach:
 *      Step 1: Create DSU with Rank(Optional)
 *      Step 2: Start adding edges and count all the edges if they are making cycle(their parents are same)
 *      Step 3: Count all the nodes having parent -1.(Counting all disjoint sets)
 *      Step 4: Check if (no of disjoint sets -1) <= (no of edges creating cycle)
 *      Step: If yes then return nof of disjoint sets -1
 */
public class MakeNetworkConnected {
    public static void main(String[] args) {
        int edges[][] = new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}};
        System.out.println(makeConnected(6,edges));
    }
    public static int makeConnected(int n, int[][] connections) {
        DSURank dsu = new DSURank(n);
        int extraCables =0;
        for(int[] connection : connections){
            int parent1 = dsu.find(connection[0]);
            int parent2 = dsu.find(connection[1]);
            if(parent1 == parent2){
                extraCables++;
            }else{
                dsu.union(connection[0],connection[1]);
            }
        }

        int extraComps=0;
        for(int i=0;i<n;i++){
            if(dsu.parent[i] == -1){
                extraComps++;
            }
        }
        extraComps--;
        if(extraComps <=extraCables){
            return extraComps;
        }else{
            return -1;
        }
    }
}
class DSURank {
    int V;
    int parent[];
    int rank[];
    DSURank(int V){
        this.V=V;
        this.parent = new int[V];
        this.rank = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = -1;
            rank[i] = 1;
        }
    }
    public int find(int n){
        if(parent[n] == -1){
            return n;
        }
        return  parent[n]= find(parent[n]);
    }

    public void union(int n1, int n2){
        int parent1 = find(n1);
        int parent2= find(n2);
        if(parent1 != parent2){
            if(rank[parent1] > rank[parent2]){
                rank[parent1]+=rank[parent2];
                parent[parent2] = parent1;
            }else{
                parent[parent1] = parent2;
                rank[parent2]+=rank[parent1];
            }
        }
    }
}