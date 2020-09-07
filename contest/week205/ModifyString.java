package contest.week205;

public class ModifyString {
    public String modifyString(String s) {
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;){
            if(chars[i]!='?'){
                i++;
                continue;
            }

            char leftCh='0';
            char rightCh='0';
            if(i-1>=0)leftCh=chars[i-1];
            int right=i+1;
            while(right<chars.length&&chars[right]=='?')right++;
            if(right<chars.length)rightCh=chars[right];

            int flagIdx=0;

            for(int j=i;j<right;j++){
                if((char)('a'+flagIdx)==leftCh)flagIdx++;
                if((char)('a'+flagIdx)==rightCh)flagIdx++;
                chars[j]=(char)('a'+flagIdx);
                flagIdx++;
            }

            i=right;
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        ModifyString solution=new ModifyString();
        String s="?zs";
        System.out.println(solution.modifyString(s));
        s="ubv?w";
        System.out.println(solution.modifyString(s));
        s="j?qg??b";
        System.out.println(solution.modifyString(s));
        s="??yw?ipkj?";
        System.out.println(solution.modifyString(s));
    }
}