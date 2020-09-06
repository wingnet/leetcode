package contest.week203;

import java.util.ArrayList;

public class FindLatestStep {
    public int findLatestStep(int[] arr, int m) {
        int n=arr.length;
        int[] chars=new int[n];

        int lastStep=-1;
        int mCount=0;

        for (int j=0;j<arr.length;j++) {
            int i=arr[j];
            

            int left=i-2;
            int leftLen=left>=0?chars[left]:0;

            int right=i;
            int rightLen=right<n?chars[right]:0;

            int len=leftLen+rightLen+1;
            chars[i-1]=len;
            if(left>=0){
                chars[left-leftLen+1]=len;
            }
            if(right<n){
                chars[right+rightLen-1]=len;
            }

            if(len==m){
                mCount++;
            }
            
            if(leftLen==m)mCount--;
            if(rightLen==m)mCount--;

            if(mCount>0)lastStep=j+1;
        }

        return lastStep;
    }

    public static void main(String[] args) {
        FindLatestStep solution=new FindLatestStep();
        // int[] arr={3,5,1,2,4};
        // int m=1;
        // int[] arr={3,1,5,4,2};
        // int m=2;
        // int[] arr={1};
        // int m=1;
        int[] arr={2,1};
        int m=2;
        System.out.println(solution.findLatestStep(arr, m));
    }
}