package TopInterviewQuestions.dp;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        List<Integer> maxs=new ArrayList<>();

        if(nums==null||nums.length==0)return 0;

        for(int i=0;i<nums.length;i++){
            int number=nums[i];

            //getIndex(maxs,number);
            getIndexByBS(maxs,number);
        }

        return maxs.size();
    }

    private void getIndex(List<Integer> maxs,int target){
        for(int i=0;i<maxs.size();i++){
            if(target<maxs.get(i)){
                maxs.set(i,target);
                return;
            }
            else if(target==maxs.get(i)){
                return;
            }
        }

        maxs.add(target);
    }

    private void getIndexByBS(List<Integer> maxs,int target){
        int floor=0;
        int ceiling=maxs.size()-1;

        while (floor<=ceiling){
            int mid=floor+(ceiling-floor)/2;

            int numberMid=maxs.get(mid);
            if(numberMid<target){
                floor=mid+1;
            }
            else if(numberMid>target){
                if(mid==0){
                    maxs.set(0,target);
                    return;
                }
                else {
                    int numberLast=maxs.get(mid - 1);
                    if ( numberLast< target) {
                        maxs.set(mid,target);
                        return;
                    }
                    else if(numberLast>target){
                        ceiling=mid-1;
                    }
                    else return;
                }
            }
            else {
                return;
            }
        }

        maxs.add(target);

    }

    private void getTrain(List<Integer> maxs,int target){
        int floor=0;
        int ceiling=maxs.size()-1;

        while (floor<=ceiling){
            int mid=(floor+ceiling)/2;
            int midValue=maxs.get(mid);

            if(midValue==target)return;

            if(target>midValue){
                floor=mid+1;
            }
            else {
                if(mid==0){
                    maxs.set(0,target);
                    return;
                }

                int prevValue=maxs.get(mid-1);
                if(prevValue==target)return;
                if(prevValue<target){
                    maxs.set(mid,target);
                    return;
                }
                else {
                    ceiling=mid-1;

                }
            }
        }
        maxs.add(target);
    }
}
