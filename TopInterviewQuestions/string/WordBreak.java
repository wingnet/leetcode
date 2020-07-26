package TopInterviewQuestions.string;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    List<String> wordDict;
    public boolean wordBreak(String s, List<String> wordDict) {
        List<String> tmp=new ArrayList<>();
        for(String word:wordDict){
            if(s.indexOf(word)>=0)tmp.add(word);
        }
        this.wordDict=tmp;
        System.out.println("wordDict : "+wordDict.size()+" tmp:"+this.wordDict.size());

        List<String> lefts=new ArrayList<>();
        lefts.add(s);
        return DFS(lefts);
    }

    boolean DFS(List<String> lefts){
        if(lefts.isEmpty())return true;

        for(String word:wordDict){
            boolean found=false;
            List<String> tmp=new ArrayList<>();
            for(String str:lefts){
                int pos;
                if(!found && (pos=str.indexOf(word))>=0){
                    
                    found=true;

                    String prev=str.substring(0,pos);
                    String next=str.substring(pos+word.length());
                    if(prev.length()>0)tmp.add(prev);
                    if(next.length()>0)tmp.add(next);

                }
                else{
                    tmp.add(str);
                }
            }
            if(found){
                if(DFS(tmp))return true;
            }
        }
        return false;
    }
}