package contest.week203;

import java.util.Arrays;

public class MaxCoins {
    int[] piles;
    public int maxCoins(int[] piles) {
        this.piles=piles;
        Arrays.sort(piles);
        int n=piles.length/3;

        int sum=0;
        for(int i=0;i<n;i++){
            int idx=3*n-1-(i*2+1);
            sum+=piles[idx];
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxCoins solution=new MaxCoins();
         int[] piles={2,4,1,2,7,8};
        //int[] piles={9,8,7,6,5,1,2,3,4};
        System.out.println(solution.maxCoins(piles));
    }
}