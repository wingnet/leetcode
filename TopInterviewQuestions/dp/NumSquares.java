package TopInterviewQuestions.dp;

import java.util.HashMap;

public class NumSquares {
    HashMap<Integer,Integer> history=new HashMap<>();
    public int numSquares(int n) {
        if(history.containsKey(n))return history.get(n);
        int sqrt= (int) Math.sqrt(n);
        if(sqrt*sqrt==n){
            history.put(n, 1);
            return 1;
        }

        int minCount=Integer.MAX_VALUE;
        for(int i=sqrt;i>=1;i--){
            int result=numSquares(n-i*i);
            minCount=Math.min(minCount,result);
        }
        history.put(n, minCount+1);
        return minCount+1;
    }

}