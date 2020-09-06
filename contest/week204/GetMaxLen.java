package contest.week204;

public class GetMaxLen {
    public int getMaxLen(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int negCount=0;
        int firstNeg=-1;
        int start=0;
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            int cur=nums[i];
            int tmp=0;
            if(cur==0){
                start=i+1;
                negCount=0;
            }
            else if(cur>0){
                if(negCount%2==0){
                    tmp=i-start+1;
                    
                }
                else{
                    tmp=i-firstNeg;
                    
                }
            }
            else{
                negCount++;
                if(negCount==1)firstNeg=i;

                if(negCount%2==0){
                    tmp=i-start+1;
                    
                }
                else{
                    tmp=i-firstNeg;
                    
                }
            }
            maxLen=Math.max(maxLen, tmp);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        GetMaxLen solution=new GetMaxLen();
        //int[] nums={1,-2,-3,4};
        // int[] nums={0,1,-2,-3,-4};
        // int[] nums={-1,-2,-3,0,1};
        // int[] nums={-1,2};
         int[] nums={1,2,3,5,-6,4,0,10};
        System.out.println(solution.getMaxLen(nums));
    }
}