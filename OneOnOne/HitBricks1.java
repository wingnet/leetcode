package OneOnOne;

public class HitBricks1 {
    int rowNum;
    int colNum;
    int[][] grid1;
    UnionFind uf;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] result=new int[hits.length];

        rowNum=grid.length;
        colNum=grid[0].length;

        grid1=new int[rowNum][colNum];
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++)
                grid1[i][j]=grid[i][j];
        }

        for (int[] hit : hits) {
            int row=hit[0];
            int col=hit[1];
            grid1[row][col]=0;
        }

        
        int ceiling=rowNum*colNum;

        uf=new UnionFind(rowNum*colNum+1);
        for(int row=0;row<rowNum;row++){
            for(int col=0;col<colNum;col++){
                if(grid1[row][col]==0)continue;
                if(row==0)uf.union(ceiling, getIndex(row, col));
                union(row, col, row+1, col);
                union(row, col, row, col+1);
            }
        }

        for(int i=hits.length-1;i>=0;i--){
            int row=hits[i][0];
            int col=hits[i][1];

            if(grid[row][col]==0)continue;

            int prevSize=uf.getSize(ceiling);
            if(row==0)uf.union(ceiling, getIndex(row, col));

            union(row, col, row-1, col);
            union(row, col, row+1, col);
            union(row, col, row, col-1);
            union(row, col, row, col+1);

            result[i]=Math.max(0, uf.getSize(ceiling)-prevSize-1);

            grid1[row][col]=1;
        }
        return result;
    }

    void union(int row,int col,int row1,int col1){
        if(inRange(row1, col1)==false)return;
        if(grid1[row1][col1]==0)return;
        uf.union(getIndex(row, col), getIndex(row1, col1));
    }

    boolean inRange(int row,int col){
        return row>=0&&row<rowNum&&col>=0&&col<colNum;
    }

    int getIndex(int row,int col){
        return row*colNum+col;
    }

    static class UnionFind{
        int ceiling;
        int[] parents;
        int[] sizes;
        int count;

        UnionFind(int size){
            parents=new int[size];
            sizes=new int[size];
            ceiling=size-1;
            count=size;

            for(int i=0;i<parents.length;i++){
                parents[i]=i;
                sizes[i]=1;
            }
        }

        int getSize(int root){
            return sizes[root];
        }

        void union(int i,int j){
            int rooti=find(i);
            int rootj=find(j);
            if(rooti==rootj)return;
            if(rooti==ceiling){
                parents[rootj]=rooti;
                sizes[rooti]+=sizes[rootj];
            }
            else {
                parents[rooti]=rootj;
                sizes[rootj]+=sizes[rooti];
            }
            count--;
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

        int[][] grid3={{1},{1},{1},{1},{1}};
        
        int[][] hits3={{3,0},{4,0},{1,0},{2,0},{0,0}};

        HitBricks1 solution=new HitBricks1();
        int[] result=solution.hitBricks(grid3, hits3);
        for (int i : result) {
            System.out.println(i);
        }
        
    }
}
