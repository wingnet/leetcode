package Tencent;

public class MyAtoi {
    public int myAtoi(String str) {
        boolean isNagetive=false;
        int pos=0;
        while(pos<str.length()&&str.charAt(pos)==' ')pos++;
        if(pos==str.length())return 0;

        if(isLegal(str.charAt(pos))==false){
            return 0;
        }
        else if(str.charAt(pos)=='-'){
            isNagetive=true;
            pos++;
        }
        else if(str.charAt(pos)=='+'){
            pos++;
        }

        if(pos==str.length()||isNumber(str.charAt(pos))==false)return 0;

        int result=0;
        while(pos<str.length()&&isNumber(str.charAt(pos))){
            int digit=(str.charAt(pos)-'0');
            if(isNagetive==false && result>(Integer.MAX_VALUE-digit)/10){
                return Integer.MAX_VALUE;
            }
            if(isNagetive && -result<(Integer.MIN_VALUE+digit)/10){
                return Integer.MIN_VALUE;
            }
            result=result*10+digit;
            pos++;
        }
        return isNagetive?-result:result;
    }

    boolean isLegal(char ch){
        return ch=='+'||ch=='-'||(ch>='0'&&ch<='9');
    }

    boolean isNumber(char ch){
        return ch>='0'&&ch<='9';
    }

    public static void main(String[] args){
        MyAtoi solution=new MyAtoi();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
    }
}