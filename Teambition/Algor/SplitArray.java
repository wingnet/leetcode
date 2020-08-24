package Teambition.Algor;

import java.util.LinkedList;

public class SplitArray {
    int[] nums;
    int m;

    int wholeMin=Integer.MAX_VALUE;
    LinkedList<Integer> maxStack=new LinkedList<>();
    public int splitArray(int[] nums, int m) {
        this.nums=nums;
        this.m=m;

        dfs(nums.length,m);
        return wholeMin;
    }

    void dfs(int remainLen,int remainM){
        //System.out.println(""+remainLen+" : "+remainM);
        if(remainLen<remainM)return;

        int numsIdx=nums.length-remainLen;

        if(remainM==1){

            push(localSum(numsIdx,remainLen));

            wholeMin=Math.min(wholeMin,maxStack.getLast());

            pop();
        }
        else{
            for(int i=1;i<=remainLen-remainM+1;i++){

                push(localSum(numsIdx,i));

                dfs(remainLen-i, remainM-1);

                pop();
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
        int[] nums={1,4,4};
        int m=3;
        System.out.println(solution.splitArray(nums, m));
    }
}