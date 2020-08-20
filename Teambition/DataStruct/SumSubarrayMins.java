package Teambition.DataStruct;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SumSubarrayMins {
    static class valueIdx{
        int value;
        int idx;
        valueIdx(int v,int i){
            value=v;
            idx=i;
        }
    }
    long sum=0;
    int[] A;
    int model=1000000007;
    PriorityQueue<valueIdx> pq=new PriorityQueue<valueIdx>((valueIdx x,valueIdx y)->{
        return x.value-y.value;
    });
    public int sumSubarrayMins(int[] A) {
        this.A=A;
        
        // for (int i = 0; i < A.length; i++) {
        //     pq.add(new valueIdx(A[i], i));
        // }
        // while(pq.isEmpty()==false){

        // }
        split(0,A.length-1);
        return (int)sum;
    }

    void split(int start,int end){
        if(start>end)return;

        int minIdx=start;
        int minValue=A[start];
        for(int i=start+1;i<=end;i++){
            if(A[i]<minValue){
                minValue=A[i];
                minIdx=i;
            }
        }

        int tmp=(minIdx-start+1)*(end-minIdx+1);
        add(((long)tmp)*((long)minValue));

        split(start,minIdx-1);
        split(minIdx+1,end);
    }

    void add(long value){
        value=value%model;
        if(sum>=model-value)sum=sum-model+value;
        else sum+=value;
    }
}