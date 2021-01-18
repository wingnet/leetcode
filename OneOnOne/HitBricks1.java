package OneOnOne;

public class HitBricks1 {
    int rowNum;
    int colNum;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[][] grid1=new int[grid.length][];
        for(int i=0;i<grid1.length;i++){
            grid1[i]=grid[i].clone();
        }

        for (int[] hit : hits) {
            int row=hit[0];
            int col=hit[1];
            grid1[row][col]=0;
        }

        int rowNum=grid.length;
        int colNum=grid[0].length;
        int ceiling=rowNum*colNum;

        UnionFind uf=new UnionFind(rowNum*colNum+1);
        for(int row=0;row<grid1.length;row++){
            for(int col=0;col<grid1.length;col++){
                if(grid1[row][col]==0)continue;
                if(row==0)uf.union(ceiling, getIndex(row, col));
                if(inRange(row+1, col)&&grid1[row+1][col]==1){
                    uf.union(getIndex(row, col), getIndex(row+1, col));
                }
                if(inRange(row, col+1)&&grid1[row][col+1]==1){
                    uf.union(getIndex(row, col), getIndex(row, col+1));
                }
            }[o]
        }
    }

    boolean inRange(int row,int col){
        return row>=0&&row<rowNum&&col>=0&&col<colNum;
    }

    int getIndex(int row,int col){
        return row*1000+col;
    }

    static class UnionFind{
        int[] parents;
        int[] sizes;

        UnionFind(int size){
            parents=new int[size];
            sizes=new int[size];

            for(int i=0;i<parents.length;i++){
                parents[i]=i;
                sizes[i]=1;
            }
        }

        void union(int i,int j){
            int rooti=find(i);
            int rootj=find(j);
            if(rooti==rootj)return;
            parents[rootj]=rooti;
            sizes[rooti]+=sizes[rootj];
        }

        int find(int i){
            while(i!=parents[i]){
                i=parents[i];
            }
            return i;
        }
    }

    public static void main(String[] args) {
        int[][] grid1={{1,0,0,0},{1,1,1,0}};
        int[][] hits1={{1,0}};

        int[][] grid2={{1,0,0,0},{1,1,0,0}};
        int[][] hits2={{1,1},{1,0}};

        HitBricks solution=new HitBricks();
        int[] result=solution.hitBricks(grid2, hits2);
        for (int i : result) {
            System.out.println(i);
        }
        
    }
}
