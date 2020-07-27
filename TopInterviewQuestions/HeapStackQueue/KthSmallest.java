package TopInterviewQuestions.HeapStackQueue;

public class KthSmallest {
    int[][] matrix;
    int numRow;
    int numCol;
    public int kthSmallest(int[][] matrix, int k) {
        this.matrix=matrix;
        numRow=matrix.length;
        numCol=matrix[0].length;
        
        int floor=matrix[0][0];
        int ceiling=matrix[numRow-1][numCol-1];

        while(floor<ceiling){
            int mid=floor+(ceiling-floor)/2;

            int count=count(mid);
            if(count<k){
                floor=mid+1;
            }
            else{
                ceiling=mid;
            }
        }

        return floor;
    }

    int count(int num){
        int count=0;
        int row=matrix.length-1;
        int col=0;
        while(row>=0 && col<numCol){
            int current=matrix[row][col];
            if(current<=num){
                count+=row+1;
                col+=1;
            }
            else{
                row-=1;
            }
        }
        return count;
    }
}