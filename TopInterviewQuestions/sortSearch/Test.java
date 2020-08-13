package TopInterviewQuestions.sortSearch;

public class Test {

    int FastSelect(int[] nums,int k){

        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int index=partition(nums, left, right);
            if(index+1==k)return nums[index];
            else if(index+1<k){
                left=index+1;
            }
            else{
                right=index-1;
            }
        }
        
        return 0;
    }

    private int partition(int[] nums, int left, int right) {
        if(left==right)return left;

        int pivot=nums[left];
        
        while(left<right){
            while(left<right && nums[right]>=pivot)right--;
            
            nums[left]=nums[right];

            while(left<right && nums[left]<=pivot)left++;
            
            nums[right]=nums[left];
        }
        nums[left]=pivot;
        return left;
    }

    public static void main(String[] args) {
        Test test=new Test();
        int[] arr={3,2,1,4,6,5,7,9,8};
        System.out.println(test.FastSelect(arr, 1));
        System.out.println(test.FastSelect(arr, 3));
    }
}