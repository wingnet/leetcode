package Temp;

import java.util.LinkedList;
import java.util.List;

public class GrayCode {
    int target;
    int n;
    public List<Integer> grayCode(int n) {
        this.n=n;
        target=1;
        for(int i=0;i<n;i++)target*=2;
        
    }

    boolean DFS(LinkedList<Integer> path){
        if(path.size()==target)return true;

        int[] nexts=getNexts(path.getLast());
        for(int next:nexts){
            if(false){
                path.addLast(next);
                if(DFS(path)==true)return true;
                path.removeLast();
            }
        }
    }

    int[] getNexts(int num){
        int tmp=1;
        int[] result=new int[n];

        for(int i=0;i<n;i++){
            result[i]=num^tmp;
            tmp=tmp<<1;
        }
        return result;
    }
}