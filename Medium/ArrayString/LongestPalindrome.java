package Medium.ArrayString;

public class LongestPalindrome {
    char[] chars;
    public String longestPalindrome(String s) {
        chars=s.toCharArray();
        String maxStr="";
        for(int i=0;i<chars.length;i++){
            int tmp=expand(i, i);
            if(tmp>maxStr.length())maxStr=s.substring(i-tmp/2, i+tmp/2+1);
            tmp=expand(i, i+1);
            if(tmp>maxStr.length())maxStr=s.substring(i-tmp/2+1, i+tmp/2+1);
        }
        return maxStr;
    }

    int expand(int left, int right){
        while(left>=0&&right<chars.length&&chars[left]==chars[right]){
            left--;
            right++;
        }
        return right-left-1;
    }
}