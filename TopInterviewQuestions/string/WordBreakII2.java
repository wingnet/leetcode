package TopInterviewQuestions.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordBreakII2 {
    LinkedList<LinkedList<Integer>> paths=new LinkedList<>();
    List<String> result=new LinkedList<>();
    List<String> wordDict;
    HashMap<Integer, HashSet<Integer>> posMatchs=new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict=wordDict;
        paths.add(new LinkedList<>());
        while(paths.isEmpty()==false){
            System.out.println(paths.size());
            LinkedList<Integer> path=paths.pollLast();
            int len=getPathLength(path);
            if(len==s.length()){

                add2Result(path);
                continue;
            }

            int pos=len;

            if(posMatchs.containsKey(pos)){
                HashSet<Integer> set=posMatchs.get(pos);
                addPaths(path, set);
            }
            else{
                HashSet<Integer> set=new HashSet<>();
                for(int j=0;j<wordDict.size();j++){
                    String word=wordDict.get(j);
                    boolean fail=false;
                    for(int i=0;i<word.length();i++){
                        if(pos+i>=s.length()||word.charAt(i)!=s.charAt(pos+i)){
                            fail=true;
                            break;
                        }
                    }
                    if(fail==false){
                        set.add(j);
                    }
                }
                //System.out.println("check at "+pos);
                posMatchs.put(pos, set);
                addPaths(path, set);
                
            }
            
        }

        return result;
    }
    private int getPathLength(LinkedList<Integer> path) {
        int len=0;
        for(int index:path)len+=wordDict.get(index).length();
        return len;
    }
    private void addPaths(LinkedList<Integer> path, HashSet<Integer> set) {
        int len=getPathLength(path);
        
        HashSet<Integer> toRemove=new HashSet<>();
        for(int index:set){
            int newLen=len+wordDict.get(index).length();
            if(posMatchs.containsKey(newLen)&& posMatchs.get(newLen).isEmpty()){
                toRemove.add(index);
            }
            else{
                LinkedList<Integer> tmp=(LinkedList<Integer>)(path.clone());
                tmp.addLast(index);
                paths.add(tmp);
            }
            
        }
        for(int i:toRemove)set.remove(i);
    }
    private void add2Result(LinkedList<Integer> path) {
        StringBuilder sb=new StringBuilder();
        for(int index:path){
            String str=wordDict.get(index);
            sb.append(str);
            sb.append(" ");
        }
        if(sb.length()>0)sb.deleteCharAt(sb.length()-1);
        result.add(sb.toString());
    }

    public static void main(String[] args){
        WordBreakII2 solution=new WordBreakII2();
        String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String[] words={"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> wordDict=Arrays.asList(words);
        List<String> result=solution.wordBreak(s, wordDict);
        System.out.println("result.size() : "+result.size());
    }
}