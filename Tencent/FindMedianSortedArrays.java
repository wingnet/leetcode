package Tencent;


class FindMedianSortedArrays{

    static class Results{
        int idx1;
        int count1;
        int idx2;
        int count2;
        
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len=nums1.length+nums2.length;
        int k=(len+1)/2;
        
        int[] arr1=nums1;
        int[] arr2=nums2;

        if(arr1.length==0||arr2.length==0){
            if(arr2.length==0){
               arr1=nums2;
               arr2=nums1; 
            }
            if(len%2==1)return arr2[k-1];
                else return (arr2[k-1]+arr2[k])/2.0;
        }
        

        Results results=find(k,arr1,arr2);
        if(results==null){
            arr1=nums2;
            arr2=nums1;
            results=find(k,arr1,arr2);

        }
        int first=arr1[results.idx1];
        if(len%2==1)return first;

        if(results.idx1+results.idx2+results.count1+results.count2>=k+1){
            return first;
        }
        
        int second;
        if(results.idx2<arr2.length){
            if(results.idx1+results.count1>=arr1.length){
                second=arr2[results.idx2+results.count2];
            }
            else{
                second=Math.min(arr2[results.idx2+results.count2]
                    ,arr1[results.idx1+results.count1]);
            }
        }
        else{
            second=arr1[results.idx1+results.count1];
        }
        

        return (first+second)/2.0;
    }

    Results find(int k,int[] arr1,int[] arr2){

        int floor=0;
        int ceiling=Math.min(k-1,arr1.length-1);

        while(floor<=ceiling){
            int mid=floor+((ceiling-floor)>>1);
            int midNum=arr1[mid];
            int numCount1=getNumCount(arr1, mid);
            int num1stIdx=get1stIndex(arr1, mid);

            int numCountTotal=numCount1;

            int idx2=getIndex(arr2, midNum);
            if(idx2>=0&&arr2[idx2]==midNum){
                int numCount2=getNumCount(arr2, idx2);
                numCountTotal+=numCount2;
            }
            idx2=idx2==-1?arr2.length:idx2;

            int countSmaller=num1stIdx+idx2;
            if(k>countSmaller && k<=countSmaller+numCountTotal){
                Results result=new Results();
                result.idx1=num1stIdx;
                result.count1=numCount1;
                result.idx2=idx2;
                result.count2=numCountTotal-numCount1;
                return result;
            }
            else if(k<=countSmaller){
                ceiling=num1stIdx-1;
            }
            else{
                floor=num1stIdx+numCount1;
            }

        }

        return null;
    }

    int getNumCount(int[] arr,int idx){
        int num=arr[idx];
        int count=1;
        for(int i=idx+1;i<arr.length;i++){
            if(arr[i]==num)count++;
            else break;
        }
        for(int i=idx-1;i>=0;i--){
            if(arr[i]==num)count++;
            else break;
        }
        return count;
    }

    int get1stIndex(int[] arr,int idx){
        int num=arr[idx];

        for(int i=idx-1;i>=0;i--){
            if(arr[i]==num)idx=i;
            else break;
        }
        return idx;
    }

    private int getIndex(int[] nums,int target) {
        if(nums[nums.length-1]<target)return -1;

        int floor=0;
        int ceiling=nums.length-1;
        while(floor<ceiling){
            int mid=floor+((ceiling-floor)>>1);

            if(nums[mid]<target)floor=mid+1;
            else ceiling=mid;
        }
        return floor;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays solution=new FindMedianSortedArrays();
        int[] nums1={1,3,5,7,9};
        int[] nums2={2,4,6,8,10};
        //System.out.println(solution.getIndex(nums1, 1));
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));

        nums1=new int[]{1,2};
        nums2=new int[]{1,2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));

        nums1=new int[]{1};
        nums2=new int[]{1,2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));

        nums1=new int[]{1,2,3};
        nums2=new int[]{};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}