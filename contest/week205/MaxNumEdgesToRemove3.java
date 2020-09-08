package contest.week205;

//union-find
public class MaxNumEdgesToRemove3 {
    static class UnionFind{
        int[] parents;
        int[] rank;
        int count;

        UnionFind(int n){
            parents=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parents[i]=i;
                rank[i]=1;
            }
            count=n;
        }

        int find(int i){
            while(parents[i]!=i)i=parents[i];
            return i;
        }

        boolean union(int i,int j){
            int iRoot=find(i);
            int jRoot=find(j);
            if(iRoot!=jRoot){
                if(rank[iRoot]>rank[jRoot]){
                    parents[jRoot]=iRoot;
                }
                else{
                    parents[iRoot]=jRoot;
                    if(rank[iRoot]==rank[jRoot]){
                        rank[jRoot]++;
                    }
                }
                count--;
                return true;
            }
            return false;
        }

        @Override
        protected Object clone() {
            UnionFind uf=new UnionFind(this.parents.length);
            uf.parents=this.parents.clone();
            uf.count=count;
            return uf;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind uf=new UnionFind(n);
        int sum3=0;
        for(int[] edge:edges){
            if(edge[0]==3){
                if(uf.union(edge[1]-1, edge[2]-1))sum3++;
            }
        }

        UnionFind uf1=(UnionFind)(uf.clone());
        int sum1=sum3;
        for(int[] edge:edges){
            if(edge[0]==1){
                if(uf1.union(edge[1]-1, edge[2]-1))sum1++;
            }
        }

        int sum2=sum3;
        for(int[] edge:edges){
            if(edge[0]==2){
                if(uf.union(edge[1]-1, edge[2]-1))sum2++;
            }
        }
        println(uf1.count,uf.count,sum1,sum2,sum3);

        if(uf1.count>1||uf.count>1)return -1;
        return edges.length-sum1-sum2+sum3;
    }

    void println(String...messages){
        for (String string : messages) {
            System.out.print(string+",");
        }
        System.out.println("");
    }

    void println(int...messages){
        for (int i : messages) {
            System.out.print(i+",");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MaxNumEdgesToRemove3 solution=new MaxNumEdgesToRemove3();
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