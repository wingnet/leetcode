package OneOnOne;

import java.util.HashSet;
import java.util.LinkedList;

public class HitBricks{
    int[][] grid;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        this.grid=grid;

        int[] result=new int[hits.length];
        for(int i=0;i<hits.length;i++){
            int[] hit=hits[i];
            int row=hit[0];
            int col=hit[1];
            if(grid[row][col]==0)continue;
            grid[row][col]=0;
            int count=0;
            count+= oneDirect( row-1, col);
            count+= oneDirect( row+1, col);
            count+= oneDirect( row, col-1);
            count+= oneDirect( row, col+1);
            result[i]=count;
        }

        return result;
    }
    private int oneDirect(int row, int col) {
        his=new HashSet<>();
        if(dfs(row,col)==false){
            for(int i:his){
                int rowTmp=i/1000;
                int colTmp=i % 1000;
                grid[rowTmp][colTmp]=0;
            }
            return his.size();
        }
        return 0;
    }

    HashSet<Integer> his;

    boolean dfs(int row,int col){
        if(row<0||row>=grid.length)return false;
        if(col<0||col>=grid[0].length)return false;

        if(grid[row][col]==0)return false;
        if(his.contains(row*1000+col))return false;

        
        if(row==0)return true;

        his.add(row*1000+col);

        if(dfs(row-1,col))return true;
        if(dfs(row+1,col))return true;
        if(dfs(row,col-1))return true;
        if(dfs(row,col+1))return true;
        
        return false;
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