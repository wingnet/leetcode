package hard.tree_graph;

public class Solve {
    char[][] board;
    int rowNum;
    int colNum;
    public void solve(char[][] board) {
        if(board.length==0||board[0].length==0)return;

        this.board=board;
        rowNum=board.length;
        colNum=board[0].length;

        for (int row = 0; row < rowNum; row++) {
            dfs(row, 0, 'B');
            dfs(row,colNum-1,'B');
        }

        for(int col=1;col<colNum-1;col++){
            dfs(0,col,'B');
            dfs(rowNum-1,col,'B');
        }

        for(int row=0;row<rowNum;row++){
            for(int col=0;col<colNum;col++){
                char cur=board[row][col];
                if(cur=='B'){
                    board[row][col]='O';
                }
                else if(cur=='O'){
                    board[row][col]='X';
                }
            }
        }

    }

    void dfs(int row,int col,char color){
        if(row<0||row>=rowNum)return;
        if(col<0||col>=colNum)return;
        
        if(board[row][col]=='O'){
            board[row][col]=color;
            dfs(row-1, col, color);
            dfs(row+1, col, color);
            dfs(row, col-1, color);
            dfs(row, col+1, color);
        }

        
    }
}