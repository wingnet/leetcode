package contest.week204;

public class Test {

    int[] nums;
    void dfs(int rootIdx,int left,int right){
        System.out.println(nums[rootIdx]);

        for(int i=rootIdx+1;i<nums.length;i++){
            if(nums[i]>left && nums[i]<nums[rootIdx]){
                dfs(i, left, nums[rootIdx]);
                break;
            }
        }
        for(int i=rootIdx+1;i<nums.length;i++){
            if(nums[i]<right && nums[i]>nums[rootIdx]){
                dfs(i, nums[rootIdx],right);
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums={9,4,2,1,3,6,5,7,8,14,11,10,12,13,16,15,17,18};
        Test solution=new Test();
        solution.nums=nums;
        solution.dfs(0,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}