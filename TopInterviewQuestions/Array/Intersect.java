package TopInterviewQuestions.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums1){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        List<Integer> tmp=new ArrayList<>();
        for(int i:nums2){
            if(map.containsKey(i)){
                tmp.add(i);
                map.put(i,map.get(i)-1);
                if(map.get(i)==0)map.remove(i);
            }
        }

        int[] result=new int[tmp.size()];
        for(int i=0;i<result.length;i++){
            result[i]=tmp.get(i);
        }

        return result;
    }
}