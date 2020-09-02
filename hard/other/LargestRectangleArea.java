package hard.other;

public class LargestRectangleArea {
    int[] heights;
    int max=-1;
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0)return 0;

        this.heights=heights;
        split(0, heights.length-1);
        return max;
    }

    void split(int left,int right){
        if(left<0||left>=heights.length||right<0||right>=heights.length)return;
        if(left>right)return;

        int lowIdx=0;
        long low=Long.MAX_VALUE;
        for(int i=left;i<=right;i++){
            if(heights[i]<low){
                lowIdx=i;
                low=heights[i];
            }
        }

        long area=((long)low)*(right-left+1);

        max=Math.max(max,(int)area);
        split(left, lowIdx-1);
        split(lowIdx+1,right);
    }

    public static void main(String[] args) {
        LargestRectangleArea solution=new LargestRectangleArea();
        int[] heights={0,2147483647};
        System.out.println(solution.largestRectangleArea(heights));
    }
}