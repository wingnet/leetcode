package hard.array_string;

public class FirstMissingPositive1 {
    public int firstMissingPositive(int[] nums) {
        int len=nums.length;
        int N=len;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=0)nums[i]=N+1;
        }

        for (int i : nums) {
            int absI=Math.abs(i);
            if(absI<=N){
                nums[absI-1]=-Math.abs(nums[absI-1]) ;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0)return i+1;
        }
        return N+1;
    }
}