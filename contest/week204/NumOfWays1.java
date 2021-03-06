package contest.week204;

public class NumOfWays1 {
    int model=1000000000+7;
    int[] nums;
    int len;
    int[][] shfBuf;
    public int numOfWays(int[] nums) {
        this.nums=nums;
        len=nums.length;
        shfBuf=new int[nums.length][nums.length];

        int[] result=countTree(0, Integer.MIN_VALUE,Integer.MAX_VALUE);
        return result[1]-1;
    }

    int[] countTree(int rootIdx,int left,int right){

        int[] leftResult = findCount(rootIdx, left,nums[rootIdx]);

        int[] rightResult=findCount(rootIdx, nums[rootIdx],right);


        if(leftResult==null && rightResult==null){
            return new int[]{1,1};
        }
        if(leftResult==null){
            rightResult[0]+=1;
            return rightResult;
        }
        if(rightResult==null){
            leftResult[0]+=1;
            return leftResult;
        }

        int nodeCount=leftResult[0]+rightResult[0]+1;
        int shuffleCount=shuffle2List1(leftResult[0], rightResult[0]);
        //int allCount=leftResult[1]*rightResult[1]*shuffleCount;
        int allCount=multi( multi(leftResult[1], rightResult[1]), shuffleCount);
        System.out.println(allCount);
        return new int[]{nodeCount,allCount};
    }

    private int[] findCount(int rootIdx, int left,int right) {
        int[] leftResult=null;
        for(int i=rootIdx+1;i<nums.length;i++){
            if(nums[i]>left && nums[i]<right){
                leftResult=countTree(i, left, right);
                break;
            }
        }
        return leftResult;
    }

    int shuffle2List(int len0,int len1){
        if(len0==0&&len1==0)return 0;
        if(len0==0||len1==0)return 1;
        if(shfBuf[len0][len1]>0)return shfBuf[len0][len1];
        int result=add(shuffle2List(len0-1, len1), shuffle2List(len0, len1-1));
        shfBuf[len0][len1]=result;
        return result;
    }

    int shuffle2List1(int len0,int len1){
        return C(len0+len1,len0);
    }

    int C(int m,int n){
        int small=1;
        int big=1;
        for(int i=1;i<=m;i++){
            if(i<=n)small*=i;
            else if(i>m-n)big*=i;
        }
        return big/small;
    }

    int multi(int a,int b){
        
        long tmp=(long)a*b;
        if(tmp>model)return (int)(tmp%model);
        return (int)tmp;
    }

    int add(int a,int b){

        long tmp=(long)a+b;
        if(tmp>model)return (int)(tmp%model);
        return (int)tmp;
    }

    public static void main(String[] args) {
        NumOfWays1 solution=new NumOfWays1();
        //System.out.println(solution.C(4,2));
        //System.out.println(solution.C(5,2));
        // System.out.println(solution.shuffle2List(1, 1));
        // System.out.println(solution.shuffle2List(1, 2));
        // System.out.println(solution.shuffle2List(2, 2));
        // int[] nums={2,1,3};
        // int[] nums={3,4,5,1,2};
        // int[] nums={3,1,2,5,4,6};
        int[] nums={9,4,2,1,3,6,5,7,8,14,11,10,12,13,16,15,17,18};
        System.out.println(solution.numOfWays(nums));
    }
}