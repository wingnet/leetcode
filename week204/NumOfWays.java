package week204;

public class NumOfWays {
    int[] nums;
    int len;
    public int numOfWays(int[] nums) {
        this.nums=nums;
        len=nums.length;

        return countTree(0, len-1)-1;
    }

    int countTree(int startIdx,int endIdx){

        int i=startIdx+1;
        for(;i<=endIdx;i++){
            if(nums[i]>nums[startIdx])break;
        }
        int leftLen=i-startIdx-1;
        int rightLen=endIdx-i+1;
        

        if(leftLen==0&&rightLen==0)return 1;
        if(leftLen==0)return countTree(i, endIdx);
        if(rightLen==0)return countTree(startIdx+1, i-1);

        int shuffleCount=shuffle2List(leftLen, rightLen);
        int leftCount=countTree(startIdx+1, i-1);
        int rightCount=countTree(i, endIdx);
        return leftCount*rightCount*shuffleCount;
    }

    int shuffle2List(int len0,int len1){
        if(len0==0&&len1==0)return 0;
        if(len0==0||len1==0)return 1;
        return shuffle2List(len0-1, len1)+shuffle2List(len0, len1-1);
    }

    public static void main(String[] args) {
        NumOfWays solution=new NumOfWays();
        // System.out.println(solution.shuffle2List(1, 1));
        // System.out.println(solution.shuffle2List(1, 2));
        // System.out.println(solution.shuffle2List(2, 2));
        // int[] nums={2,1,3};
        int[] nums={3,4,5,1,2};
        System.out.println(solution.numOfWays(nums));
    }
}