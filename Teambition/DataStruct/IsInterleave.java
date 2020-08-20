package Teambition.DataStruct;

public class IsInterleave {
    String s1;
    String s2;
    String s3;
    int len1;
    int len2;
    int len3;
    boolean[][] history;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        len1=s1.length();
        len2=s2.length();
        len3=s3.length();
        history=new boolean[len1+1][len2+1];

        if(len1+len2!=len3)return false;

        return DFS(0,0);
    }

    boolean isEqual(String str1,int start1,String str2,int start2){
        for(;start1<str1.length();start1++){
            if(str1.charAt(start1)!=str2.charAt(start2))return false;
            start2++;
        }
        return true;
    }

    boolean DFS(int pos1,int pos2){
        //System.out.println(""+pos1+" : "+pos2);
        int pos3=pos1+pos2;
        if(pos1==len1 && pos2==len2)return true;

        if(history[pos1][pos2])return false;
        history[pos1][pos2]=true;
        

        char ch3=s3.charAt(pos3);

        if(pos1<len1 && s1.charAt(pos1)==ch3&&DFS(pos1+1,pos2)){
            return true;
        }
        else if(pos2<len2 && s2.charAt(pos2)==ch3&&DFS(pos1,pos2+1)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        IsInterleave solution=new IsInterleave();
        String s1="aabcc";
        String s2="dbbca";
        String s3="aadbbcbcac";

        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}