package contest.week203;

public class StoneGameV {
    int[] stoneValue;
    int[][] buf;

    public int stoneGameV(int[] stoneValue) {
        this.stoneValue=stoneValue;
        int len=stoneValue.length;
        buf=new int[len][len];
        for (int[] i : buf) {
            for(int j=0;j<i.length;j++){
                i[j]=-1;
            }
        }
        int wholeSum=sum(0,len-1);
        return dfs(0,stoneValue.length-1,wholeSum);
    }

    int dfs(int left, int right,int sum){
        if(left==right)return 0;

        if(buf[left][right]>-1)return buf[left][right];
        
        int localMax=-1;
        int leftSum=0;
        int rightSum=sum;
        for(int i=1;i<=right-left;i++){
            int tmpResult=0;
            leftSum+=stoneValue[left+i-1];
            rightSum-=stoneValue[left+i-1];
            if(leftSum>rightSum){
                tmpResult=rightSum+dfs(left+i,right,rightSum);
            }
            else if(leftSum<rightSum){
                tmpResult=leftSum+dfs(left,left+i-1,leftSum);
            }
            else{
                int tmpLeft=dfs(left,left+i-1,leftSum);
                int tmpRight=dfs(left+i,right,rightSum);
                tmpResult=leftSum+Math.max(tmpLeft, tmpRight);
            }
            localMax=Math.max(localMax, tmpResult);
        }
        //System.out.println(""+left+","+right+":"+localMax);
        buf[left][right]=localMax;

        return localMax;
    }

    int sum(int left,int right){
        int sum=0;
        for(int i=left;i<=right;i++)sum+=stoneValue[i];
        return sum;
    }

    public static void main(String[] args) {
        StoneGameV solution=new StoneGameV();
         int[] stoneValue={6,2,3,4,5,5};
         System.out.println(solution.stoneGameV(stoneValue));
        stoneValue=new int[]{7,7,7,7,7,7,7};
        System.out.println(solution.stoneGameV(stoneValue));
        stoneValue=new int[]{4};
        System.out.println(solution.stoneGameV(stoneValue));
        stoneValue=new int[]{5,5};
        System.out.println(solution.stoneGameV(stoneValue));
        
    }
}