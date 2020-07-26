package TopInterviewQuestions.string;

import java.util.LinkedList;
import java.util.List;

public class WordBreakII {
    
    LinkedList<LinkedList<String>> paths=new LinkedList<>();
    List<String> result=new LinkedList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {

        paths.add(new LinkedList<>());
        while(paths.isEmpty()==false){
            LinkedList<String> path=paths.pollFirst();
            int len=0;
            for(String word:path)len+=word.length();
            if(len==s.length()){

                add2Result(path);
                continue;
            }

            int pos=len;
            
            for(String word:wordDict){
                boolean fail=false;
                for(int i=0;i<word.length();i++){
                    if(pos+i>=s.length()||word.charAt(i)!=s.charAt(pos+i)){
                        fail=true;
                        break;
                    }
                }
                if(fail==false){
                    LinkedList<String> tmp=(LinkedList<String>)(path.clone());
                    tmp.addLast(word);
                    paths.add(tmp);
                }
            }
        }

        return result;
    }
    private void add2Result(LinkedList<String> path) {
        StringBuilder sb=new StringBuilder();
        for(String str:path){
            sb.append(str);
            sb.append(" ");
        }
        if(sb.length()>0)sb.deleteCharAt(sb.length()-1);
        result.add(sb.toString());
    }
}