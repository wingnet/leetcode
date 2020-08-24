package Teambition.Algor;

public class SplitArray1 {
    int[] nums;
    public int splitArray(int[] nums, int m) {
        this.nums=nums;
        int max=0;
        int sum=0;
        for (int i : nums) {
            max=Math.max(max, i);
            sum+=i;
        }

        int floor=max;
        int ceiling=sum;
        while(floor<ceiling){
            int mid=floor+((ceiling-floor)>>1);
            int count=count(mid);
            if(count>m){
                floor=mid+1;
            }
            else{
                ceiling=mid;
            }

        }
        return floor;
    }

    int count(int x){
        int count=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>x){
                count++;
                sum=nums[i];
            }
            else{
                sum+=nums[i];
            }
        }

        return count;
    }


    public static void main(String[] args) {
        SplitArray1 solution=new SplitArray1();
        //solution.split(16, new int[3], 0);

        int[] nums={7,2,5,10,8};
        int m=2;
        //int[] nums={1,4,4};
        //int m=3;
        //int[] nums={5334,6299,4199,9663,8945,3566,9509,3124,6026,6250,7475,5420,9201,9501,38,5897,4411,6638,9845,161,9563,8854,3731,5564,5331,4294,3275,1972,1521,2377,3701,6462,6778,187,9778,758,550,7510,6225,8691,3666,4622,9722,8011,7247,575,5431,4777,4032,8682,5888,8047,3562,9462,6501,7855,505,4675,6973};
        //int m=9;
        System.out.println(solution.splitArray(nums, m));
    }
}