package Teambition.Algor;

import java.util.Arrays;
import java.util.LinkedList;

public class SplitArray {
    int[] nums;
    int m;

    int wholeMin=Integer.MAX_VALUE;
    LinkedList<Integer> maxStack=new LinkedList<>();

    //int[][] history;
    int[][] buf;

    public int splitArray(int[] nums, int m) {
        this.nums=nums;
        this.m=m;

        //history=new int[nums.length+1][m+1];
        buf=new int[nums.length][nums.length+1];
        for (int[] is : buf) {
            Arrays.fill(is, -1);
        }

        dfs(nums.length,m);
        return wholeMin;
    }

    void dfs(int remainLen,int remainM){
        //System.out.println(""+remainLen+" : "+remainM);
        if(remainLen<remainM)return;

        //if(history[remainLen][remainM]>0)return history[remainLen][remainM];

        int numsIdx=nums.length-remainLen;

        if(remainM==1){

            push(localSum(numsIdx,remainLen));

            wholeMin=Math.min(wholeMin,maxStack.getLast());

            pop();
        }
        else{
            for(int i=1;i<=remainLen-remainM+1;i++){
                int tmp=localSum(numsIdx,i);

                if(tmp<wholeMin){
                    System.out.println("cut. "+wholeMin+" : "+tmp);
                    push(tmp);

                    dfs(remainLen-i, remainM-1);
    
                    pop();
                }

               
            }
        }
    }

    private void pop() {
        maxStack.removeLast();
    }

    private void push(int sum) {
        //System.out.println("push : "+sum);
        if(maxStack.isEmpty()){
            maxStack.addLast(sum);
        }
        else{
            if(maxStack.getLast()<sum)maxStack.addLast(sum);
            else maxStack.addLast(maxStack.getLast());
        }
        
    }

    
    private int localSum(int idxNums,int len) {
        if(buf[idxNums][len]>=0)return buf[idxNums][len];

        int sum=0;
        for(int i=idxNums;i<idxNums+len;i++){
            sum+=nums[i];
        }
        return sum;
    }

    void split(int len,int[] buf,int startIdx){
        
        int m=buf.length-startIdx;

        if(len<m)return;

        if(m==1){
            buf[startIdx]=len;
            for (int i : buf) {
                System.out.print(""+i+',');
                
            }
            System.out.println("");

        }
        else{
            for(int i=1;i<=len-m+1;i++){
                buf[startIdx]=i;
                split(len-i, buf, startIdx+1);
            }
        }
        
    }

    public static void main(String[] args) {
        SplitArray solution=new SplitArray();
        //solution.split(16, new int[3], 0);

        //int[] nums={7,2,5,10,8};
        //int m=2;
        //int[] nums={1,4,4};
        //int m=3;
        int[] nums={5334,6299,4199,9663,8945,3566,9509,3124,6026,6250,7475,5420,9201,9501,38,5897,4411,6638,9845,161,9563,8854,3731,5564,5331,4294,3275,1972,1521,2377,3701,6462,6778,187,9778,758,550,7510,6225,8691,3666,4622,9722,8011,7247,575,5431,4777,4032,8682,5888,8047,3562,9462,6501,7855,505,4675,6973};
        int m=9;
        System.out.println(solution.splitArray(nums, m));
    }
}