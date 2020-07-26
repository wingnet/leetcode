package TopInterviewQuestions.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LadderLength1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> buf=new LinkedList<>();

        buf.addLast(beginWord);

        int pathLen=1;

        while(buf.isEmpty()==false){
            int layerSize=buf.size();
            for(int i=0;i<layerSize;i++){
                String seed=buf.pollFirst();

                if(seed.equals(endWord)){
                    return pathLen;
                }

                List<String> tmpList=new ArrayList<>();
                for(String str:wordList){
                    if(getDiffCount(seed,str)==1){
                        buf.addLast(str);
                    }
                    else {
                        tmpList.add(str);
                    }
                }
                wordList=tmpList;
            }

            pathLen++;
        }

        return 0;
    }

    private int getDiffCount(String word, String str) {
        int diffCount=0;
        for(int j=0;j<str.length();j++){
            diffCount+=str.charAt(j)==word.charAt(j)?0:1;
        }
        return diffCount;
    }
}
