package contest.week205;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem4 {
    int n;
    int[][] edges;
    int[][] buf;
    List<Integer> history;
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        this.n=n;
        this.edges=edges;

        buf=new int[n][3];
        for(int i=0;i<edges.length;i++){
            int[] tmp=edges[i];
            int type=tmp[0];
            int node1=tmp[1];
            int node2=tmp[2];
            buf[node1-1][type-1]=node2-1;
            buf[node2-1][type-1]=node1-1;
        }
    }

    int dfs(int node,int edgeCount){
        int localMin=Integer.MAX_VALUE;
        HashMap<Integer,boolean[]> adjs=getAdjs(node);
        for(int key:adjs.keySet()){
            if(history.contains(key))continue;

            boolean[] types=adjs.get(key);
            if(types[2]){
                history.add(node);
                localMin=Math.min(localMin,dfs(key,edgeCount+1));
                history.remove(node);
            }
            else if(types[0]&&types[1]){
                history.add(node);
                localMin=Math.min(localMin,dfs(key,edgeCount+2));
                history.remove(node);
            }
        }
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

            if(type>0){
                boolean[] tmp;
                if(result.containsKey(other)){
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

}