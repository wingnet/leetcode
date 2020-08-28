package hard.backtracking;

public class IsMatch {
    String s;
    public boolean isMatch(String s, String p) {
        this.s=s;
        if(p.isEmpty())return true;
        if(s.isEmpty())return false;

        String[] strs=p.split("*");
        int subIndex=getNextSub(strs, 0);

        if(subIndex==strs.length)return true;

        int pos=0;
        if(s.charAt(0)!='*'){
            if(compare(strs[0], 0)==false)return false;
            pos+=strs[0].length();
            subIndex=1;
        }

        

        else{
            int pos=indexOf(strs[subIndex], 0);
            if(pos==-1)return false;
        }

        return false;
    }

    private int getNextSub(String[] strs, int subIndex) {
        while(subIndex<strs.length && strs[subIndex].isEmpty())subIndex++;
        return subIndex;
    }

    int indexOf(String subP,int start){
        for(int i=start;i<s.length()-subP.length()+1;i++){
            if(compare(subP, i))return i;
        }
        return -1;
    }

    boolean compare(String subP,int start){
        if(start+subP.length()>s.length())return false;

        for (int i = 0; i < subP.length(); i++) {
            char ch=subP.charAt(i);
            if(ch=='?')continue;
            if(ch!=s.charAt(start+i))return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs="*123**abc*".split("\\*");
        for (String string : strs) {
            System.out.println(string);
        }
    }
}