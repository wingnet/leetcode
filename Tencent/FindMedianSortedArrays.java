package Tencent;
import java.util.Arrays;

class FindMedianSortedArrays{
    int[] nums1;
    int[] nums2;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        
    }

    int find(int k){

        int floor=0;
        int ceiling=k-1;

        while(floor<=ceiling){
            int mid=floor+(ceiling-floor)>>1;
            int target=nums1[mid];

            int count2=getCount(target);
            if(mid+count2==k-1)
        }

        int target=nums1[k];
        
        int count = getCount(target);

        //if(floor==0)
    }

    private int getCount(int target) {
        int floor=0;
        int ceiling=nums2.length-1;
        while(floor<ceiling){
            int mid=floor+(ceiling-floor)>>1;

            if(nums2[mid]<target)floor=mid+1;
            else ceiling=mid;
        }
        return floor;
    }
}