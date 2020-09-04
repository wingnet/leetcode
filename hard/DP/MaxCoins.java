package hard.DP;

public class MaxCoins {
    int[] nums;
    int[][] buf;
    public int maxCoins(int[] nums) {
        if(nums.length==0)return 0;

        this.nums=nums;
        buf=new int[nums.length][nums.length];
        for (int[] i : buf) {
            for(int j=0;j<i.length;j++)i[j]=-1;
        }

        return dfs(-1,nums.length);
    }

    int get(int i){
        if(i<0||i>=nums.length)return 1;
        return nums[i];
    }

    int dfs(int left,int right){
        if(right-left<2)return 0;

        if(buf[left+1][right-1]>-1)return buf[left+1][right-1];

        int localMax=-1;
        for(int i=left+1;i<right;i++){
            localMax=Math.max(localMax,get(left)*get(i)*get(right)+dfs(left,i)+dfs(i,right));
        }

        buf[left+1][right-1]=localMax;
        return localMax;
    }

    public static void main(String[] args) {
        MaxCoins solution=new MaxCoins();
        int[] nums={3,1,5,8};
        System.out.println(solution.maxCoins(nums));
    }
}