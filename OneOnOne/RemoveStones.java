package OneOnOne;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

///
///947. 移除最多的同行或同列石头
///
public class RemoveStones {
    int[][] stones;
    public int removeStones(int[][] stones) {
        this.stones=stones;
        
        set=new HashSet<>();

        for(int i=0;i<stones.length;i++){
            set.add(i);
        }
        return DFS();
    }


    HashSet<Integer> set;

    int DFS(){
        int max=0;
        Integer[] ints=new Integer[set.size()];
        set.toArray(ints);
        for (int i : ints) {

            if(canRemove(i)){
                //System.out.println(i);
                set.remove(i);
                int left=DFS();
                
                set.add(i);

                //System.out.println(""+i+ " left:"+left);
                if(left==set.size()-1){
                    return left+1;
                }
                max=Math.max(max, left+1);

            }
        }
        return max;
    }

    boolean canRemove(int index){
        for (int i : set) {
            if(i==index)continue;
            if(stones[i][0]==stones[index][0]
            ||stones[i][1]==stones[index][1]){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {

        int[][] stones1={{0,0}};
        int[][] stones2={{0,0},{0,2},{1,1},{2,0},{2,2}};
        int[][] stones3={{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        int[][] stones4={{0,0},{0,1},{1,0},{1,1},{2,1},{2,2},{3,2},{3,3},{3,4},{4,3},{4,4}};
        int[][] stones5={{0,0},{0,1},{1,0},{1,1}};
        int[][] stones6={{5,9},{9,0},{0,0},{7,0},{4,3},{8,5},{5,8},{1,1},{0,6},{7,5},{1,6},{1,9},{9,4},{2,8},{1,3},{4,2},{2,5},{4,1},{0,2},{6,5}};

        LinkedList<int[][]> tests=new LinkedList<>();
        //tests.add(stones1);
        //tests.add(stones2);
        //tests.add(stones3);
        //tests.add(stones4);
        tests.add(stones5);
        tests.add(stones6);

        for(int[][] test : tests){
            RemoveStones solution=new RemoveStones();
            System.out.println(solution.removeStones(test));
        }
        
    }
}
