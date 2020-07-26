package TopInterviewQuestions.string;

import java.util.List;

public class WordBreak2 {
    String s;
    List<String> wordDict;
    boolean[] marked;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s=s;
        this.wordDict=wordDict;
        this.marked=new boolean[s.length()];

        return DFS(0);
    }

    boolean DFS(int pos){
        if(pos==s.length())return true;
        if(marked[pos])return false;
        marked[pos]=true;
        
        for(String word:wordDict){
            if(pos+word.length()>s.length())continue;

            boolean fail=false;
            for(int i=0;i<word.length();i++){
                if(word.charAt(i)!=s.charAt(pos+i)){
                    fail=true;
                    break;
                }
            }
            if(fail==false){
                if(DFS(pos+word.length()))return true;
            }
        }
        return false;
    }
}