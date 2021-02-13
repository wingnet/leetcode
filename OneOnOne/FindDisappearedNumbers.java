package OneOnOne;

import java.util.LinkedList;
import java.util.List;

public class FindDisappearedNumbers {
    //原地hash
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i=0;i<nums.length;i++){
            int current=nums[i];

            if(current<0)continue;
            
            while(nums[current-1]>0){
                int nextValue=nums[current-1];
                nums[current-1]=-nextValue;
                current=nextValue;
            }
        }

        LinkedList<Integer> result=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)result.add(i+1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] tc={4,3,2,7,8,2,3,1};
        FindDisappearedNumbers solution=new FindDisappearedNumbers();
        System.out.println(solution.findDisappearedNumbers(tc));
    }
}
