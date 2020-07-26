package TopInterviewQuestions.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class WordBreak1 {
    HashMap<Integer,HashSet<Integer>> posHash=new HashMap<>();
    int len;
    boolean[] marked;
    public boolean wordBreak(String s, List<String> wordDict) {
        len=s.length();
        marked=new boolean[len];

        boolean hasEnd=false;
        for(String word:wordDict){
            int index;
            int start=0;
            while((index=s.indexOf(word,start))>=0){
                int endPlus1=index+word.length();
                if(endPlus1==len)hasEnd=true;

                if(posHash.containsKey(index)){
                    posHash.get(index).add(endPlus1);
                }
                else{
                    HashSet<Integer> set=new HashSet<>();
                    set.add(endPlus1);
                    posHash.put(index, set);
                }
                start++;
            }
        }

        //posHash.keySet().forEach(item->System.out.println("key:"+item));
        if(hasEnd==false)return false;

        return DFS(0);
    }

    boolean DFS(int pos){
        if(marked[pos])return false;
        if(pos==len)return true;
        if(posHash.containsKey(pos)==false)return false;
        HashSet<Integer> set=posHash.get(pos);
        for(int i:set){
            if(DFS(i))return true;
        }
        return false;
    }

    public static void main(String[] args){
        String[] tmp={"leet","code"};
        
        WordBreak1 solution=new WordBreak1();
        System.out.println(solution.wordBreak("leetcode", Arrays.asList(tmp)));
    }
}