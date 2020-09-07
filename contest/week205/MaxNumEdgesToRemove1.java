package contest.week205;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class MaxNumEdgesToRemove1 {
    int n;
    int[][] edges;
    LinkedList<Integer> history;
    int currentType;

    int[] edgeMarks;

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        this.n=n;
        this.edges=edges;
        Arrays.sort(edges,(a,b)->b[0]-a[0]);

        history=new LinkedList<>();

        edgeMarks=new int[edges.length];

        currentType=1;
        if(dfs(1)==false)return -1;

        currentType=2;
        history.clear();
        if(dfs(1)==false)return -1;

        int count=0;
        for(int i:edgeMarks){
            if(i==0)count++;
        }
        return count;
    }

    boolean dfs(int node){
        history.addLast(node);
        if(history.size()==n)return true;

        for (int i=0;i<edges.length;i++) {
            int[] is=edges[i];

            int type=0;
            int other=0;
            if(is[1]==node){
                type=is[0];
                other=is[2];
            }
            else if(is[2]==node){
                type=is[0];
                other=is[1];
            }

            if(history.contains(other))continue;

            
            if(type==3){

                edgeMarks[i]+=1;
                if(dfs(other))return true;
                
            }
            if(type==currentType){
                edgeMarks[i]+=1;
                if(dfs(other))return true;
            }
            
        }

        return false;
    }

    public static void main(String[] args) {
        MaxNumEdgesToRemove1 solution=new MaxNumEdgesToRemove1();
        int n=4;
        int[][] edges=new int[][]{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        System.out.println(solution.maxNumEdgesToRemove(n, edges));

        n=4;
        edges=new int[][]{{3,1,2},{3,2,3},{1,1,4},{2,1,4}};
        System.out.println(solution.maxNumEdgesToRemove(n, edges));

        n=4;
        edges=new int[][]{{3,2,3},{1,1,2},{2,3,4}};
        System.out.println(solution.maxNumEdgesToRemove(n, edges));

        n=2;
        edges=new int[][]{{1,1,2},{2,1,2},{3,1,2}};
        System.out.println(solution.maxNumEdgesToRemove(n, edges));
    }
}