package Teambition.Algor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindRotateSteps {
    HashMap<Character, List<Integer>> map = new HashMap<>();
    String ring;
    String key;
    int[][] history;
    public int findRotateSteps(String ring, String key) {

        this.ring=ring;
        this.key=key;

        history=new int[ring.length()+1][key.length()+1];
        for (int[] is : history) {
            Arrays.fill(is, -1);
        }

        

        for (int i = 0; i < ring.length(); i++) {
            char ch=ring.charAt(i);
            if(map.containsKey(ch)){
                map.get(ch).add(i);
            }
            else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(ch, list);
            }
        }

        return  DFS(0, 0, 0);
    }

    int DFS(int ringIdx,int keyIdx,int len){
        if(keyIdx==key.length()){
            return 0;
        }
        if(history[ringIdx][keyIdx]>=0){
            int tmp=history[ringIdx][keyIdx];
            return tmp;
        }

        List<Integer> charIdxes=map.get(key.charAt(keyIdx));

        int localMin=Integer.MAX_VALUE;
        for(int idx:charIdxes){
            int dis=getDistance(ringIdx, idx);
            int tmp=DFS(idx, keyIdx+1, len+dis+1);
            localMin=Math.min(localMin,tmp+dis+1);
        }
        history[ringIdx][keyIdx]=localMin;
        return localMin;
    }

    int getDistance(int ringIdx,int idx){
        int tmp=Math.abs(ringIdx-idx);
        return Math.min(tmp,ring.length()-tmp);
    }

    public static void main(String[] args) {
        FindRotateSteps solution=new FindRotateSteps();
        // String ring="godding";
        // String key="gd";
        String ring="caotmcaataijjxi";
        String key="oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx";
        System.out.println(solution.findRotateSteps(ring, key));
    }
}