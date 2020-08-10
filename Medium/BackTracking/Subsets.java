package Medium.BackTracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    List<List<Integer>> lists;
    public List<List<Integer>> subsets(int[] nums) {

        lists=new LinkedList<>();
        lists.add(new LinkedList<>());
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        LinkedList<Integer> inStack=new LinkedList<>();
        DFS(set,inStack);

        return lists;
    }

    void DFS(HashSet<Integer> set,LinkedList<Integer> inStack){

        Integer[] arr=new Integer[set.size()];
        set.toArray(arr);

        for(int i:arr){
            inStack.add(i);
            lists.add((LinkedList<Integer>)(inStack.clone()));
            set.remove(i);
            DFS(set,inStack);
            //set.add(i);
            inStack.removeLast();
        }
        for(int i:arr)set.add(i);
    }
}