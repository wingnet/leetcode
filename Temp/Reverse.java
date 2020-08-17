package Temp;

public class Reverse {
    public int reverse(int x) {
        int tmp=0;
        while(x!=0){
            int digit=x%10;
            if(tmp>0&&tmp>(Integer.MAX_VALUE-digit)/10)return 0;
            if(tmp<0&&tmp<(Integer.MIN_VALUE-digit)/10)return 0;
            tmp=tmp*10+digit;
            x=x/10;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(-13/10);
        System.out.println(-13%10);
    }
}