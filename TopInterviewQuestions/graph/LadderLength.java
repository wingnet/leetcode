package TopInterviewQuestions.graph;

import java.util.HashSet;
import java.util.List;

public class LadderLength {
    String endWord;
    List<String> wordList;

    HashSet<String> minPath;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        this.endWord=endWord;
        this.wordList=wordList;
        this.minPath=new HashSet<>();

        BFS(beginWord,new HashSet<>());
        return minPath.size();
    }

    private int getDiffCount(String word, String str) {
        int diffCount=0;
        for(int j=0;j<str.length();j++){
            diffCount+=str.charAt(j)==word.charAt(j)?0:1;
        }
        return diffCount;
    }

    private void BFS(String word, HashSet<String> path){
        if(word.equals(endWord)){
            path.add(word);
            if(minPath.size()==0||path.size()<minPath.size()){
                minPath=path;
            }
            return;
        }

        for(String str:wordList){

            if(path.contains(str))continue;

            if(getDiffCount(str,word)==1){
                HashSet<String> newPath=(HashSet<String>)path.clone();
                newPath.add(word);
                BFS(str,newPath);
            }
        }
    }
}
