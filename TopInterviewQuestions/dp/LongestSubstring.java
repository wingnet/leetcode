package TopInterviewQuestions.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {
    String s;
    int k;
    public int longestSubstring(String s, int k) {

        if(k==1)return s.length();

        this.s=s;
        this.k=k;
        
        int sucLen=0;
        for(int i=0;i<s.length();i++){
            int startLen=Math.max(k, sucLen);
            int len=search(i, startLen);
            sucLen=Math.max(sucLen, len);
        }

        return sucLen;
    }

    static class Counter{
        int k;
        int[] counter=new int[26];
        int failCounter=0;

        Counter(int k){
            this.k=k;
        }
        
        void add(char ch){
            int index=ch-'a';
            counter[index]+=1;
            if(counter[index]==1)failCounter++;
            else if(counter[index]==k)failCounter--;
        }

        void remove(char ch){
            int index=ch-'a';
            counter[index]-=1;
            if(counter[index]==k-1)failCounter++;
            else if(counter[index]==0)failCounter--;
        }
    }

    boolean hasInLen(int len){
        Counter counter=new Counter(k);
        for(int i=0;i<len;i++){
            counter.add(s.charAt(i));
        }
        if(counter.failCounter==0)return true;
        for(int i=len;i<s.length();i++){
            counter.remove(s.charAt(i-len));
            counter.add(s.charAt(i));
            if(counter.failCounter==0)return true;
        }
        return false;
    }

    int search(int startIndex,int startLen){

        if(startIndex+startLen>s.length())return 0;

        int successLen=0;
        Counter counter=new Counter(k);
        for(int i=startIndex;i<startIndex+startLen;i++){
            counter.add(s.charAt(i));
        }
        if(counter.failCounter==0)successLen=startLen;

        for(int i=startIndex+startLen;i<s.length();i++){
            counter.add(s.charAt(i));
            if(counter.failCounter==0){
                successLen=i-startIndex+1;
            }
        }
        return successLen;
    }

    public static void main(String[] args){
        LongestSubstring solution=new LongestSubstring();
        int result=solution.longestSubstring("weitong", 2);
        System.out.println(result);
    }
}