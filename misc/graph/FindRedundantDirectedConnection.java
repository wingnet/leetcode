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
        int N=edges.length;
        int[] inwardCount=new int[N];
        int nodeWith2=-1;
        for(int[] edge:edges){
            inwardCount[edge[1]-1]+=1;
            if(inwardCount[edge[1]-1]==2){
                nodeWith2=edge[1];
                break;
            }
        }


        int[] edge1=null;
        int[] edge2=null;
        UnionFind uf=new UnionFind(N);
        for(int[] edge:edges){
            if(edge[1]!=nodeWith2){
                if(uf.union(edge[0]-1, edge[1]-1)==false){
                    return edge;
                }
            }
            else{
                if(edge1==null)edge1=edge;
                else edge2=edge;
            }
        }

        if(nodeWith2>0){
            if(uf.union(edge1[0]-1, edge1[1]-1)==false)return edge1;
            else return edge2;
        }

        return null;
    }
}
