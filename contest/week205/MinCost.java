package contest.week205;

import java.util.PriorityQueue;

public class MinCost {
    public int minCost(String s, int[] cost) {

        int totalCost=0;
        for(int i=0;i<s.length();){
            char ch=s.charAt(i);
            int j=i+1;
            
            int sum=cost[i];
            int max=cost[i];
            while(j<s.length()&&s.charAt(j)==ch){
                sum+=cost[j];
                max=Math.max(max, cost[j]);
                j++;
            }
            if(j-i>1){
                //System.out.println(""+sum+","+max);
                totalCost+=sum-max;
                i=j;
            }
            else i++;
        }
        return totalCost;
    }
    public static void main(String[] args) {
        MinCost solution=new MinCost();
        String s="abaac";
        int[] cost=new int[]{1,2,3,4,5};
        System.out.println(solution.minCost(s, cost));
        
        s="abc";
        cost=new int[]{1,2,3};
        System.out.println(solution.minCost(s, cost));

        s="aabaa";
        cost=new int[]{1,2,3,4,1};
        System.out.println(solution.minCost(s, cost));
    }
}