package TopInterviewQuestions;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

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

    void testTreemap(){
        TreeMap<Double,Integer> map=new TreeMap<>();
        map.put(1.0, 10);
        map.put(1.5,15);
        map.put(2.0,20);
        map.put(2.5,25);
        
        SortedMap<Double,Integer> tmp= map.subMap(1.1, 2.1);
        //SortedMap<Double,Integer> tmp=map.
        for(Entry<Double,Integer> entry:tmp.entrySet()){
            System.out.println("key : "+entry.getKey()+"  value : "+entry.getValue());
        }
    }

    public static void main(String[] args){
        int[] nums={1,2,2,4,4,4,5,6};
        Test test=new Test();
        // System.out.println(test.binarySearchNearestLarge(nums, 2));
        // System.out.println(test.binarySearchNearestLarge(nums, 3));
        // System.out.println(test.binarySearchNearestLarge(nums, 4));
        // System.out.println(test.binarySearchNearestLarge(nums, 5));

        test.testTreemap();
    }
}