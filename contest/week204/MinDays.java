package contest.week204;

public class MinDays {
    

    static class UnionFind{

        int[] parents;
        int count;
        UnionFind(int len){

            parents=new int[len];
            for(int i=0;i<parents.length;i++){
                parents[i]=i;
            }
            count=len;
        }

        boolean connected(int i,int j){
            return find(i)==find(j);
        }

        void union(int i,int j){
            int parentI=find(i);
            int parentJ=find(j);
            if(parentI!=parentJ){
                parents[parentJ]=parentI;
                count--;
            }
        }

        int find(int i){
            while(parents[i]!=i){
                i=parents[i];
            }
            return i;
        }
    }

    int[][] grid;
    int rowNum;
    int colNum;
    public int minDays(int[][] grid) {
        this.grid=grid;
        rowNum=grid.length;
        colNum=grid[0].length;

        int count=count();
        if(count==0||count>1)return 0;
        
        for(int row=0;row<rowNum;row++){
            for(int col=0;col<colNum;col++){
                if(grid[row][col]==1){
                    grid[row][col]=0;
                    if(count()==2)return 1;
                    grid[row][col]=1;
                }
            }
        }
        return 2;
    }

    int count(){
        UnionFind uf=new UnionFind(rowNum*colNum);
        for(int row=0;row<rowNum;row++){
            for(int col=0;col<colNum;col++){
                if(grid[row][col]==0)uf.count--;
                else{
                    if(col+1<colNum && grid[row][col+1]==1){
                        uf.union(row*colNum+col, row*colNum+col+1);
                    }
                    if(row+1<rowNum && grid[row+1][col]==1){
                        uf.union(row*colNum+col, (row+1)*colNum+col);
                    }
                }
            }
        }
        return uf.count;
    }
}