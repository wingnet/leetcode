package misc.graph;

//https://leetcode-cn.com/problems/redundant-connection-ii/
//685. 冗余连接 II
public class FindRedundantDirectedConnection {
    static class UnionFind{
        int[] parents;

        int count;
        UnionFind(int n){
            parents=new int[n];

            count=n;
            for(int i=0;i<parents.length;i++){
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

                parents[rootJ]=rootI;
                count--;
                
                return true;
            }
            return false;
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        boolean[] flag=new boolean[edges.length];
        for(int[] edge:edges){
            flag[edge[1]-1]=true;
        }

        int root=0;
        for(int i=0;i<flag.length;i++){

            if(flag[i]==false){
                root=i+1;
                break;
            }
        }

        UnionFind uf=new UnionFind(edges.length);
        for(int[] edge:edges){
            if(edge[0]==root-1)uf.union(root-1, edge[1]-1);
        }

        
        for(int[] edge:edges){
            if(uf.union(edge[0]-1, edge[1]-1)==false)return edge;
        }
        return null;
    }
}
