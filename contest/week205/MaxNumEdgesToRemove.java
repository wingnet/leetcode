package contest.week205;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MaxNumEdgesToRemove {
    int n;
    int[][] edges;

    LinkedList<Integer> history;
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        this.n=n;
        this.edges=edges;

        history=new LinkedList<>();
        return dfs(1,0);
    }

    int dfs(int node,int edgeCount){
        if(history.size()==n)return edgeCount;

        int localMin=Integer.MAX_VALUE;
        HashMap<Integer,boolean[]> adjs=getAdjs(node);
        for(int key:adjs.keySet()){
            //if(history.contains(key))continue;

            boolean[] types=adjs.get(key);
            if(types[2]){
                history.addLast(node);
                localMin=Math.min(localMin,dfs(key,edgeCount+1));
                history.removeLast();
            }
            else if(types[0]&&types[1]){
                history.addLast(node);
                localMin=Math.min(localMin,dfs(key,edgeCount+2));
                history.removeLast();
            }
        }
        System.out.println(""+node+","+edgeCount+","+localMin);
        return localMin;
    }

    HashMap<Integer,boolean[]> getAdjs(int node){
        HashMap<Integer,boolean[]> result=new HashMap<>();
        for (int[] is : edges) {
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

            if(type>0&&history.contains(other)==false){
                boolean[] tmp;
                if(result.containsKey(other)==false){
                    tmp=new boolean[3];
                    result.put(other, tmp);
                }
                else{
                    tmp=result.get(other);
                }
                tmp[type-1]=true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxNumEdgesToRemove solution=new MaxNumEdgesToRemove();
        int n=4;
        int[][] edges=new int[][]{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        System.out.println(solution.maxNumEdgesToRemove(n, edges));
    }
}