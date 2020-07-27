package TopInterviewQuestions;

public class Test {
    int binarySearch(int[] nums, int target){
        int floor=0;
        int ceiling=nums.length-1;
        while(floor<=ceiling){
            int mid=floor+(ceiling-floor)/2;
            if(nums[mid]==target)return mid;
            if(nums[mid]<target){
                floor=mid+1;
            }
            else{
                ceiling=mid-1;
            }
        }
        return -1;
    }

    int binarySearchNearestLarge(int[] nums, int target){
        if(nums[nums.length-1]<target)return -1;
        
        int floor=0;
        int ceiling=nums.length-1;
        while(floor<ceiling){
            int mid=floor+(ceiling-floor)/2;
            if(nums[mid]<target)floor=mid+1;
            else ceiling=mid;
        }
        return floor;
    }
    public static void main(String[] args){
        int[] nums={1,2,2,4,4,4,5,6};
        Test test=new Test();
        System.out.println(test.binarySearchNearestLarge(nums, 2));
        System.out.println(test.binarySearchNearestLarge(nums, 3));
        System.out.println(test.binarySearchNearestLarge(nums, 4));
        System.out.println(test.binarySearchNearestLarge(nums, 5));
    }
}