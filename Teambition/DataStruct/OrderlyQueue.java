package Teambition.DataStruct;

import java.util.Arrays;
import java.util.HashSet;

public class OrderlyQueue {
    
    public String orderlyQueue(String S, int K) {
        if(K==1){
            String minStr;
            minStr=S;
            for (int i = 0; i < S.length()-1; i++) {
                String tmp=S.substring(1)+S.substring(0,1);
                if(tmp.compareTo(minStr)<0)minStr=tmp;
                S=tmp;
            }
            return minStr;
        }
        else{
            char[] chars=S.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        System.out.println("133".compareTo("133"));
    }
}