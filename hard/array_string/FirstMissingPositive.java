package hard.array_string;

public class FirstMissingPositive {
    int[] nums;
    public int firstMissingPositive(int[] nums) {
        this.nums=nums;

        return 0;
    }

    int[] quickSelect(){
        int curPos=0;
        int targetPos=nums.length-1;
        int nagetiveCount=0;
        int target=-1;

        while(curPos<targetPos){
            int curNumber=nums[curPos];
            if(curNumber<=0){
                curPos++;
                nagetiveCount++;
            }
            else if(target<0){
                target=curNumber;
                swap(curPos,targetPos);
                targetPos--;
            }
            else if(curNumber>=target){
                swap(curPos,targetPos);
                targetPos--;
            }
            else{
                curPos++;
            }
        }
        return new int[]{targetPos,nagetiveCount};
    }

    void swap(int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}