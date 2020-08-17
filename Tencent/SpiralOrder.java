package Tencent;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        if(matrix.length==0)return result;
        int rows=matrix.length;
        int cols=matrix[0].length;
        if(cols==0)return result;

        int left=0;
        int right=cols-1;
        int top=0;
        int bottom=rows-1;

        while(right>=left && bottom>=top){
            int row=top;
            int col=left;
            
            for(;col<=right;col++){
                result.add(matrix[row][col]);
            }

            if(bottom-top>0){
                col=right;
                row=top+1;

                for(;row<=bottom;row++){
                    result.add(matrix[row][col]);
                }
            }
            

            if(right-left>0 &&bottom-top>0){
                row=bottom;
                col=right-1;
    
                for(; col>=left;col--){
                    result.add(matrix[row][col]);
                }

                col=left;
                row=bottom-1;
    
                for(;row>=top+1;row--){
                    result.add(matrix[row][col]);
                }
            }
            

            top++;
            bottom--;
            left++;
            right--;
        }

        return result;
    }
}