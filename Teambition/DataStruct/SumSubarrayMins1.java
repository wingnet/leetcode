package Teambition.DataStruct;

import java.util.LinkedList;

public class SumSubarrayMins1 {

    static class ValueCount{
        int value;
        int count;
        ValueCount(int v,int c){
            value=v;
            count=c;
        }
    }

    int model=1000000007;

    public int sumSubarrayMins(int[] A) {

        if(A==null||A.length==0)return 0;
        
        LinkedList<ValueCount> list=new LinkedList<>();
        list.addLast(new ValueCount(A[0], 1));
        int lastSum=A[0];
        long sum=lastSum;

        for(int i=1;i<A.length;i++){
            ValueCount vci=new ValueCount(A[i], 1);
            while(list.isEmpty()==false && list.getLast().value>=A[i]){
                ValueCount vc=list.pollLast();
                lastSum-=vc.value*vc.count;
                vci.count+=vc.count;
            }
            
            list.addLast(vci);
            lastSum+=vci.value*vci.count;
            sum+=lastSum;
            if(sum>model)sum-=model;
        }

        return (int)sum;
    }
}