package Temp;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {

        int[][] result=new int[n][];
        for(int i=0;i<n;i++)result[i]=new int[n];

        int left=0;
        int right=n-1;
        int top=0;
        int bottom=n-1;

        int count=1;
        while(count<=n*n){
            int row=top;
            int col=left;
            for(;col<=right;col++){
                result[row][col]=count;
                count++;
            }

            if(count>n*n)break;
            row=top+1;
            col=right;
            for(;row<=bottom;row++){
                result[row][col]=count;
                count++;
            }


            row=bottom;
            col=right-1;
            for(;col>=left;col--){
                result[row][col]=count;
                count++;
            }


            row=bottom-1;
            col=left;
            for(;row>=top+1;row--){
                result[row][col]=count;
                count++;
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return result;
    }

    public static void main(String[] args){
        GenerateMatrix solution=new GenerateMatrix();
        solution.generateMatrix(3);
    }
}