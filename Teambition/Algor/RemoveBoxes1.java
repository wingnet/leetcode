package Teambition.Algor;

import java.util.HashMap;

public class RemoveBoxes1 {
    int[] boxes;
    int[][][] history;
    //HashMap<String,Integer> buf=new HashMap<>();
    public int removeBoxes(int[] boxes) {
        this.boxes=boxes;

        history=new int[boxes.length][boxes.length][boxes.length];

        return dfs(0,boxes.length-1,0);
    }

    int dfs(int left,int right,int k){
        if(left>right)return k*k;

        int rightValue=boxes[right];
        while(right>left && rightValue==boxes[right-1]){
            right--;
            k++;
        }

        if(history[left][right][k]>0)return history[left][right][k];
        //String key=""+left+","+right+","+k;
        //if(buf.containsKey(key))return buf.get(key);
        
        int localMax=dfs(left,right-1,0)+(k+1)*(k+1);

        for(int i=left;i<right;i++){
            if(boxes[i]==rightValue){
                int tmp=dfs(left,i,k+1)+dfs(i+1,right-1,0);
                localMax=Math.max(localMax, tmp);
            }
        }
        history[left][right][k]=localMax;
        //buf.put(key, localMax);
        return localMax;
    }

    public static void main(String[] args) {
        RemoveBoxes1 solution=new RemoveBoxes1();
        //int[] boxes={1,3,2,2,2,3,4,3,1};
        //int[] boxes={1,2,1,2,1};
        int[] boxes={3,8,8,5,5,3,9,2,4,4,6,5,8,4,8,6,9,6,2,8};
        System.out.println(solution.removeBoxes(boxes));
    }
}