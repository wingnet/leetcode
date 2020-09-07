package contest.week205;

import java.util.Arrays;


public class NumTriplets {
    public int numTriplets(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        return count(nums1,nums2)+count(nums2,nums1);
    }

    int count(int[] arr1,int[] arr2){
        int count=0;
        for (int num : arr1) {
            long square=num*num;
            int i=0;
            int j=arr2.length-1;
            while(i<j){
                long tmp=arr2[i]*arr2[j];
                if(tmp==square){
                    //System.out.println(""+num+" "+arr2[i]+"*"+arr2[j]);
                    if(arr2[i]==arr2[j]){
                        int sameCount=j-i+1;
                        int C=sameCount*(sameCount-1)/2;
                        count+=C;
                        break;
                    }
                    else{
                        int right=j-1;
                        while(arr2[right]==arr2[j])right--;
                        int left=i+1;
                        while(arr2[left]==arr2[i])left++;

                        count+=(j-right)*(left-i);
                        i=left;
                        j=right;
                    }
                    
                }
                else if(tmp<square)i++;
                else j--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        NumTriplets solution=new NumTriplets();
        int[] nums1={7,4};
        int[] nums2={5,2,8,9};
        //  System.out.println(solution.numTriplets(nums1, nums2));

        // nums1=new int[]{1,1};
        // nums2=new int[]{1,1,1};
        // System.out.println(solution.numTriplets(nums1, nums2));

        // nums1=new int[]{7,7,8,3};
        // nums2=new int[]{1,2,9,7};
        // System.out.println(solution.numTriplets(nums1, nums2));

        // nums1=new int[]{4,7,9,11,23};
        // nums2=new int[]{3,5,1024,12,18};
        // System.out.println(solution.numTriplets(nums1, nums2));

        // nums1=new int[]{3,1,2,2};
        // nums2=new int[]{1,3,4,4};
        // System.out.println(solution.numTriplets(nums1, nums2));

        nums1=new int[]{43024,99908};
        nums2=new int[]{1864};
        System.out.println(solution.numTriplets(nums1, nums2));
    }
}