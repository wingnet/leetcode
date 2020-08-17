package Tencent;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        if(x<10)return true;
        if(x%10==0)return false;

        int tmp=0;
        while(x!=0){
            if(tmp==x)return true;
            if(tmp==x/10)return true;
            tmp=tmp*10+x%10;
            x=x/10;
        }
        return false;
    }
}