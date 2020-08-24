package Teambition.Algor;

public class CanTransform {
    static class CharIdx{
        char ch;
        int idx;
        CharIdx(char c,int i){
            ch=c;
            idx=i;
        }
    }
    public boolean canTransform(String start, String end) {
        CharIdx ci1=getNextLR(start, 0);
        CharIdx ci2=getNextLR(end, 0);
        while(ci1!=null&&ci2!=null){
            if(ci1.ch!=ci2.ch)return false;

            if(ci1.ch=='L'&&ci1.idx<ci2.idx)return false;

            if(ci1.ch=='R'&&ci1.idx>ci2.idx)return false;

            ci1=getNextLR(start, ci1.idx+1);
            ci2=getNextLR(end, ci2.idx+1);
        }
        if(ci1==null&&ci2==null)return true;
        return false;
    }

    CharIdx getNextLR(String str,int startIdx){
        for(int i=startIdx;i<str.length();i++){
            if(str.charAt(i)=='X')continue;
            return new CharIdx(str.charAt(i),i);
        }
        return null;
    }

    String removeX(String str){
        StringBuilder sb=new StringBuilder();
        for(char ch:str.toCharArray()){
            if(ch!='X')sb.append(ch);
        }
        return sb.toString();
    }
}