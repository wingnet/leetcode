package TopInterviewQuestions.Array;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result=new int[nums.length];
        int prev=1;
        for(int i=nums.length-1;i>0;i--){
            result[i]=nums[i]*prev;
            prev=result[i];
        }

        int left=1;
        for(int i=0;i<nums.length;i++){
            int right=1;
            if(i<nums.length-1)right=result[i+1];
            result[i]=left*right;
            left=left*nums[i];
        }

        return result;
    }
}