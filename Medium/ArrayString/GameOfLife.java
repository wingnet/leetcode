package Medium.ArrayString;

public class GameOfLife {
    int[][] board;
    int rowNum;
    int colNum;
    public void gameOfLife(int[][] board) {
        this.board=board;
        rowNum=board.length;
        colNum=board[0].length;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                update(row, col);
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col]=(board[row][col])>>1;
            }
        }
    }

    int getOldStatus(int row,int col){
        if(row<0||row>=rowNum)return 0;
        if(col<0||col>=colNum)return 0;

        return (board[row][col])&1;
    }

    void update(int row,int col){
        int oldStatus=getOldStatus(row, col);
        int liveCount=0;
        for(int i=col-1;i<=col+1;i++){
            liveCount+=getOldStatus(row-1, i);
            liveCount+=getOldStatus(row+1, i);
        }
        liveCount+=getOldStatus(row, col-1);
        liveCount+=getOldStatus(row, col+1);

        int newStatus=oldStatus;
        if(oldStatus==1){
            if(liveCount<2||liveCount>3)newStatus=0;
        }
        else{
            if(liveCount==3)newStatus=1;
        }
        board[row][col]=(newStatus<<1)+oldStatus;
    }
}