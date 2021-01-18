package OneOnOne;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;

public class RemoveStones1 {

    int count;
    int[] parents;

    void union(int parent,int j){
        if(find(parent)==find(j))return;

        parents[find(j)] =find(parent);
        count--;
    }

    int find(int index){
        while(parents[index]!=index){
            index=parents[index];
        }
        return index;
    }

    public int removeStones(int[][] stones) {
        parents=new int[stones.length];
        count=stones.length;

        for (int i = 0; i < parents.length; i++) {
            parents[i]=i;
        }

        connect(stones,0);
        connect(stones, 1);
       
        return stones.length-count;
    }

    private void connect(int[][] stones,int coordIndex) {
        Hashtable<Integer,Integer> buf=new Hashtable<>();
        for(int i=0;i<stones.length;i++){
            int coord=stones[i][coordIndex];
            if(buf.containsKey(coord) ){
                union(buf.get(coord), i);
            }
            else{
                buf.put(coord, i);
            }
        }
    }

    public static void main(String[] args) {

        int[][] stones1={{0,0}};
        int[][] stones2={{0,0},{0,2},{1,1},{2,0},{2,2}};
        int[][] stones3={{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        int[][] stones4={{0,0},{0,1},{1,0},{1,1},{2,1},{2,2},{3,2},{3,3},{3,4},{4,3},{4,4}};
        int[][] stones5={{0,0},{0,1},{1,0},{1,1}};
        int[][] stones6={{5,9},{9,0},{0,0},{7,0},{4,3},{8,5},{5,8},{1,1},{0,6},{7,5},{1,6},{1,9},{9,4},{2,8},{1,3},{4,2},{2,5},{4,1},{0,2},{6,5}};
        int[][] stones7={{0,1},{1,0},{1,1}};

        LinkedList<int[][]> tests=new LinkedList<>();
        
        tests.add(stones1);
        tests.add(stones2);
        tests.add(stones3);
        tests.add(stones4);
        tests.add(stones5);
        tests.add(stones6);
        
        tests.add(stones7);

        for(int[][] test : tests){
            RemoveStones1 solution=new RemoveStones1();
            System.out.println(solution.removeStones(test));
        }
        
    }
}
