package TopInterviewQuestions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class GetSkyline1 {
    static class Item{
        int x;
        boolean isLeft;
        int height;
        int index;
        Item(int _x,boolean _isLeft,int height,int index){
            x=_x;
            isLeft=_isLeft;
            this.height=height;
            this.index =index;
        }
    }
    PriorityQueue<Item> priorityQueue=new PriorityQueue<>((item0,item1)->item0.x-item1.x);

    int[][] buildings;
    List<List<Integer>> skyline;
    PriorityQueue<Item> currentBuildings=new PriorityQueue<>((item0,item1)->item1.height-item0.height);

    public List<List<Integer>> getSkyline(int[][] buildings) {
        this.buildings=buildings;
        for(int i=0;i<buildings.length;i++){
            int[] block=buildings[i];
            int blockLeft=block[0];
            int blockRight=block[1];
            int blockHeight=block[2];
            priorityQueue.add(new Item(blockLeft,true,blockHeight,i));
            priorityQueue.add(new Item(blockRight,false,blockHeight,i));
        }


        skyline=new ArrayList<>();

        while (priorityQueue.isEmpty()==false){

            int x=priorityQueue.peek().x;

            while (priorityQueue.isEmpty()==false&& priorityQueue.peek().x==x){
                Item item=priorityQueue.poll();
                if(item.isLeft){
                    currentBuildings.add(item);
                }
                else {
                    currentBuildings.removeIf(item0->item0.index ==item.index);
                }
            }

            addCord(x,getCurrentHeight());
        }

        return skyline;
    }

    private int getCurrentHeight(){
        if(currentBuildings.isEmpty())return 0;
        return currentBuildings.peek().height;
    }

    private void addCord(int x, int height, List<List<Integer>> tmpList) {
        //System.out.println("x : "+x+" h:"+height+"  size:"+currentBuildings.size());
        if(tmpList.isEmpty()==false){
            List<Integer> last=tmpList.get(tmpList.size()-1);
            if(last.get(1)==height)return;

        }

        LinkedList<Integer> lines = new LinkedList<>();
        lines.addLast(x);
        lines.addLast(height);
        tmpList.add(lines);
    }

    private void addCord(int x, int y) {
        addCord(x, y, skyline);
    }
}
