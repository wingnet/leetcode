package hard.DP;

public class MaxCoins {
    int[] nums;

    public int maxCoins(int[] nums) {
        this.nums=nums;

    }

    int get(int i){
        if(i<0||i>=nums.length)return 1;
        return nums[i];
    }

    int dfs(int left,int right){
        if(right<left)return 0;
        int localMax=-1;
        for(int i=left;i<=right;i++){
            localMax=Math.max(localMax,get(i-1)*get(i)*get(i+1)+dfs(left,i-1)+dfs(i+1,right));
        }

        return localMax;
    }
}