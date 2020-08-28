package hard.backtracking;

public class IsMatch {
    String s;
    boolean tailMatch;
    public boolean isMatch(String s, String p) {
        this.s=s;
        if(p.isEmpty()){
            if(s.isEmpty())return true;
            else return false;
        }


        if(p.charAt(p.length()-1)!='*')tailMatch=true;

        String[] strs=p.split("\\*");

        int subIndex=0;
        int pos=0;

        if(p.charAt(0)!='*'){
            if(compare(strs[0], 0)==false)return false;
            if(strs.length==1){
                if(tailMatch){
                    if(strs[0].length()==s.length())return true;
                    else return false;
                }
                else return true;
            }
            pos+=strs[0].length();
            subIndex=1;
        }

        while(subIndex<strs.length){
            subIndex=getNextSub(strs, subIndex);
            if(subIndex==strs.length)return true;

            String subP=strs[subIndex];
            if(subIndex==strs.length-1){
                if(tailMatch){
                    if(pos>s.length()-subP.length())return false;
                    if(compare(subP, s.length()-subP.length()))return true;
                    else return false;
                }
                else {
                    pos=indexOf(subP, pos);
                    if(pos==-1)return false;
                    else return true;
                }
            }
            else{
                pos=indexOf(subP, pos);
                if(pos==-1)return false;

                pos+=strs[subIndex].length();

                subIndex++;
            }

        }

        return true;
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
        // String[] strs="*123**abc*".split("\\*");
        // for (String string : strs) {
        //     System.out.println(string);
        // }

        IsMatch solutoin=new IsMatch();
        // String s="adceb";
        // String p="*a*b";

        // String s="cb";
        // String p="?a";

        // String s="aa";
        // String p="*";

        // String s="aa";
        // String p="aa";

        // String s="acdcb";
        // String p="a*c?b";

        String s="mississippi";
        String p="m??*ss*?i*pi";
        System.out.println(solutoin.isMatch(s, p));
    }
}