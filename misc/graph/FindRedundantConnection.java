package misc.graph;

//https://leetcode-cn.com/problems/redundant-connection/
//684. 冗余连接
public class FindRedundantConnection{
    static class UnionFind{
        int[] parents;
        int[] rank;
        int count;

        UnionFind(int n){
            parents=new int[n];
            rank=new int[n];
            count=n;
            for(int i=0;i<n;i++){
                parents[i]=i;
            }
        }

        int find(int i){
            while(i!=parents[i])i=parents[i];
            return i;
        }

        boolean union(int i,int j){
            int rootI=find(i);
            int rootJ=find(j);
            if(rootI!=rootJ){
                if(rank[rootI]>rank[rootJ]){
                    parents[rootJ]=rootI;
                    count--;
                }
                else{
                    parents[rootI]=rootJ;
                    count--;
                    if(rank[rootI]==rank[rootJ]){
                        rank[rootJ]+=1;
                    }
                }
                return true;
            }
            return false;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf=new UnionFind(edges.length);

        for(int[] edge:edges){
            if(uf.union(edge[0]-1, edge[1]-1)==false){
                return edge;
            }
        }
        return null;
    }
}