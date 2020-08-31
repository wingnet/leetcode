package hard.DP;

public class MaxProfit {
    int[][] dp;
    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;

        dp=new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]=0;

        int minIdx=0;

        for(int i=1;i<prices.length;i++){
            int cur=prices[i];
            if(prices[minIdx]<cur){
                int localMax=Integer.MIN_VALUE;
                for(int j=minIdx;j<i;j++){

                    int dpValue = getNearestDP(j);
                    int gain=cur-prices[j];
                    localMax=Math.max(localMax, dpValue+gain);
                }
                
                if(localMax<=dp[i-1][0]){
                    dp[i][0]=dp[i-1][0];
                    dp[i][1]=0;
                }
                else{
                    dp[i][0]=localMax;
                    dp[i][1]=1;
                }
            }
            else {
                dp[i][0]=dp[i-1][0];
                dp[i][1]=0;
                minIdx=i;
            }

        }

        return dp[prices.length-1][0];
    }

    private int getNearestDP(int j) {

        if(j-1<0)return 0;
        if(dp[j-1][1]==0)return dp[j-1][0];
        if(j-2>=0)return dp[j-2][0];
        return 0;
    }

    public static void main(String[] args) {
        MaxProfit solution=new MaxProfit();
        int[] prices={1,2,3,0,2};
        System.out.println(solution.maxProfit(prices));
    }
}