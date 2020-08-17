package Tencent;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {
    int target;
    int n;
    LinkedList<Integer> path;
    HashSet<Integer> set;
    public List<Integer> grayCode(int n) {
        this.n=n;
        target=1;
        
        for(int i=0;i<n;i++)target*=2;
        
        set=new HashSet<>();
        path=new LinkedList<>();
        path.addLast(0);
        set.add(0);
        DFS();
        return path;
    }

    boolean DFS(){
        if(path.size()==target)return true;

        int[] nexts=getNexts(path.getLast());
        for(int next:nexts){
            if(!set.contains(next)){
                path.addLast(next);
                set.add(next);
                if(DFS())return true;
                set.remove(next);
                path.removeLast();
            }
        }
        return false;
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