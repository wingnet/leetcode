package TopInterviewQuestions.dp;

import java.util.HashMap;

public class LongestIncreasingPath {
    int[][] matrix;
    int rowCount;
    int colCount;
    HashMap<Integer,Integer> history=new HashMap<>();
    int maxLen=0;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix=matrix;
        rowCount=matrix.length;
        if(rowCount==0)return 0;
        colCount=matrix[0].length;
        if(colCount==0)return 0;

        for(int row=0;row<rowCount;row++){
            for(int col=0;col<colCount;col++){
                DFS(row,col,0,Integer.MIN_VALUE);
            }
        }
        return maxLen;
    }

    int DFS(int row,int col,int prevLen,int prev){
        if(row<0||row>=rowCount)return 0;
        if(col<0||col>=colCount)return 0;

        if(matrix[row][col]<=prev)return 0;

        int key=row*colCount+col;
        if(history.containsKey(key)){
            int tmp=history.get(key);
            maxLen=Math.max(maxLen, prevLen+tmp);
            return tmp;
        }

        int current=matrix[row][col];
        int localMax=0;
        localMax=Math.max(localMax,DFS(row+1,col,prevLen+1,current));
        localMax=Math.max(localMax,DFS(row-1,col,prevLen+1,current));
        localMax=Math.max(localMax,DFS(row,col+1,prevLen+1,current));
        localMax=Math.max(localMax,DFS(row,col-1,prevLen+1,current));
        history.put(key,localMax+1);
        maxLen=Math.max(maxLen, prevLen+localMax+1);
        System.out.println(""+row+" : "+col+" "+(localMax+1));
        return localMax+1;
    }

    public static void main(String[] args){
        LongestIncreasingPath solution=new LongestIncreasingPath();
        int[][] matrix={{7,8,9},{9,7,6},{7,2,3}};
        System.out.println(solution.longestIncreasingPath(matrix));
    }
}