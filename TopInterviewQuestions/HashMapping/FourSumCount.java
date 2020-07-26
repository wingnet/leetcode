package TopInterviewQuestions.HashMapping;


import java.util.HashMap;


public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> ab=new HashMap<>();
        for(int a:A){
            for(int b:B){
                ab.put(a+b, ab.getOrDefault(a+b, 0)+1);
            }
        }

        int result=0;
        for(int c:C){
            for(int d:D){
                if(ab.containsKey(0-c-d))result+=ab.get(0-c-d);
            }
        }
        return result;
    }
}