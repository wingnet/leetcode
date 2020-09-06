package contest.week203;

import java.util.ArrayList;
import java.util.List;

public class MostVisited {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] counts=new int[n+1];

        for(int i=1;i<rounds.length;i++){
            int start=rounds[i-1];
            int end=rounds[i];
            if(end>start){
                increase(counts, start, end-1);
            }
            else{
                increase(counts, start, n);
                increase(counts, 1, end-1);
            }
        }
        counts[rounds[rounds.length-1]]+=1;
        List<Integer> result=new ArrayList<>();
        int max=-1;
        for(int i=1;i<counts.length;i++){
            if(counts[i]>max){
                max=counts[i];
                result.clear();
                result.add(i);
            }
            else if(counts[i]==max){
                result.add(i);
            }
        }
        return result;
    }

    private void increase(int[] counts, int start, int end) {
        for(int j=start;j<=end;j++)counts[j]+=1;
    }

    public static void main(String[] args) {
        MostVisited solution=new MostVisited();
        // int n=4;
        // int[] rounds={1,3,1,2};
        // int n=2;
        // int[] rounds={2,1,2,1,2,1,2,1,2};
        int n=7;
        int[] rounds={1,3,5,7};
        List<Integer> result=solution.mostVisited(n, rounds);
        result.forEach(item -> System.out.println(item));
    }
}