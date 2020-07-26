package TopInterviewQuestions.graph;

public class NumIslands {
    char[][] mGrid;
    int numRow;
    int numCol;
    int count=0;
    public int numIslands(char[][] grid) {
        if(grid==null)return 0;
        numRow=grid.length;
        if(numRow==0)return 0;
        numCol=grid[0].length;
        if(numCol==0)return 0;

        mGrid=grid;

        for(int i=0;i<numRow;i++){
            for(int j=0;j<numCol;j++){
                if(mGrid[i][j]=='1'){
                    count++;
                    markLan(i,j);
                }
            }
        }

        return count;
    }


    private void markLan(int row,int col){
        if(row<0||row>=numRow)return;
        if(col<0||col>=numCol)return;

        if(mGrid[row][col]!='1')return;

        mGrid[row][col]='2';
        markLan(row+1,col);
        markLan(row-1,col);
        markLan(row,col+1);
        markLan(row,col-1);
    }
}
