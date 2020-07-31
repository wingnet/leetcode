package TopInterviewQuestions.dp;

import java.util.HashSet;

public class LongestSubstring1 {
    int maxLen=0;
    String s;
    int k;
    public int longestSubstring(String s, int k) {
        if(k==1)return s.length();

        this.s=s;
        this.k=k;
        maxLen=k-1;
        check(s);
        return maxLen==k-1?0:maxLen;
    }

    static class Counter{
        int k;
        int[] counter=new int[26];
        HashSet<Character> failChars=new HashSet<>();

        Counter(int k){
            this.k=k;
        }
        
        void add(char ch){
            int index=ch-'a';
            counter[index]+=1;
            if(counter[index]==1)failChars.add(ch);
            else if(counter[index]==k)failChars.remove(ch);
        }

    }
    void check(String str){
        if(str.length()<=maxLen)return;
        Counter counter=new Counter(k);
        for(char ch:str.toCharArray())counter.add(ch);
        if(counter.failChars.isEmpty()){
            maxLen=Math.max(maxLen, str.length());
            return;
        }

        for(int i=0;i<str.length();i++){
            if(counter.failChars.contains(str.charAt(i)))continue;
            int j=i+1;
            for(;j<str.length();j++){
                if(counter.failChars.contains(str.charAt(j))){
                    String sub=str.substring(i, j);
                    check(sub);
                    i=j;
                    break;
                }
            }
            if(j==str.length()){
                String sub=str.substring(i);
                check(sub);
                break;
            }
        }
    }
}