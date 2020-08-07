package TopInterviewQuestions.sortSearch;

public class FindDuplicate {
    int[] nums;
    public int findDuplicate(int[] nums) {
        this.nums=nums;
        int i=0;
        for(;i<nums.length;i++){
            if(i!=nums[i])break;
        }
        int slow=getNext(i);
        int fast=getNext(getNext(i));
        while(slow!=fast){
            slow=getNext(slow);
            fast=getNext(getNext(fast));
        }

        int tmp=i;
        while(slow!=tmp){
            slow=getNext(slow);
            tmp=getNext(tmp);
        }

        return tmp;
    }

    int getNext(int index){
        return nums[index];
    }
}