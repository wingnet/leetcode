package Teambition.Algor;

import java.util.HashMap;
import java.util.LinkedList;

public class RemoveBoxes {
    static class ColorCount{
        int color;
        int count;
        ColorCount(int c,int cnt){
            color=c;
            count=cnt;
        }
    }
    
    public int removeBoxes(int[] boxes) {
        LinkedList<ColorCount> colorCounts;
        HashMap<Integer,Integer> groupCounts;
        colorCounts=new LinkedList<>();
        groupCounts=new HashMap<>();
        for(int i:boxes){
            if(colorCounts.isEmpty()||colorCounts.getLast().color!=i){
                colorCounts.add(new ColorCount(i, 1));
                groupCounts.put(i, groupCounts.getOrDefault(i, 0)+1);
            }
            else{
                colorCounts.getLast().count+=1;
            }

        }

        return dfs(colorCounts,groupCounts);
    }

    int dfs(LinkedList<ColorCount> colorCounts,HashMap<Integer,Integer> groupCounts){
        if(colorCounts.isEmpty())return 0;

        //colorCounts.forEach(value -> System.out.print(""+value.color+":"+value.count+","));
        //System.out.println("");

        int tmpCount=0;
        LinkedList<ColorCount> tmp=new LinkedList<>();
        while(colorCounts.isEmpty()==false){
            ColorCount cc=colorCounts.pollFirst();
            if(groupCounts.get(cc.color)==1){
                tmpCount+=cc.count*cc.count;
                groupCounts.remove(cc.color);
            }
            else{
                if(tmp.isEmpty()==false&&tmp.getLast().color==cc.color){
                    
                    if(groupCounts.get(cc.color)==2){
                        int total=tmp.getLast().count+cc.count;
                        tmpCount+=total*total;
                        tmp.removeLast();
                        groupCounts.remove(cc.color);
                    }
                    else{
                        ColorCount last= tmp.pollLast();
                        ColorCount tmpCC=new ColorCount(last.color, last.count+cc.count);
                        //tmp.getLast().count+=cc.count;
                        tmp.addLast(tmpCC);
                        groupCounts.put(cc.color, groupCounts.get(cc.color)-1);
                    }
                    
                }
                else{
                    tmp.addLast(cc);
                }
                
            }
        }
        //System.out.println("tmpCount:"+tmpCount);
        colorCounts=tmp;

        int localMax=0;
        LinkedList<ColorCount> head=new LinkedList<>();
        while(colorCounts.isEmpty()==false){
        
            ColorCount cc=colorCounts.pollFirst();

            LinkedList<ColorCount> tmpCCs=new LinkedList<>();
            tmpCCs.addAll((LinkedList<ColorCount>)(head.clone()));
            tmpCCs.addAll((LinkedList<ColorCount>)(colorCounts.clone()));

            head.add(cc);

            HashMap<Integer,Integer> tmpGC=
                (HashMap<Integer,Integer>)(groupCounts.clone());
            tmpGC.put(cc.color, tmpGC.get(cc.color)-1);

            
            int result=cc.count*cc.count+dfs(tmpCCs,tmpGC);
            
            //System.out.println("color : "+cc.color+" count:"+cc.count+" result:"+result);
            localMax=Math.max(localMax, result);
        }

        return tmpCount+localMax;
    }

    public static void main(String[] args) {
        RemoveBoxes solution=new RemoveBoxes();
        //int[] boxes={1,3,2,2,2,3,4,3,1};
        //int[] boxes={1,2,1,2,1};
        int[] boxes={3,8,8,5,5,3,9,2,4,4,6,5,8,4,8,6,9,6,2,8};
        System.out.println(solution.removeBoxes(boxes));
    }
}