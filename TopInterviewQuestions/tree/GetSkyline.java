package TopInterviewQuestions.tree;


import java.util.LinkedList;
import java.util.List;

public class GetSkyline {
    LinkedList<List<Integer>> skylines=new LinkedList<>();
    public List<List<Integer>> getSkyline(int[][] buildings) {


        for(int[] block:buildings){
            int blockLeft=block[0];
            int blockRight=block[1];
            int blockHeight=block[2];

            if(skylines.size()==0){
                addCord(blockLeft, blockHeight);
                addCord(blockRight,0);
            }
            else {
                int rightMostX=skylines.getLast().get(0);
                if(rightMostX<blockLeft){
                    addCord(blockLeft, blockHeight);
                    addCord(blockRight,0);
                }
                else if(rightMostX==blockLeft){
                    skylines.removeLast();
                    addCord(blockLeft, blockHeight);
                    addCord(blockRight,0);
                }
                else {
                    LinkedList<List<Integer>> tmpList=new LinkedList<>();

                    for(int i=0;i<skylines.size()-1;i++){
                        int lineX=skylines.get(i).get(0);
                        int nextX=skylines.get(i+1).get(0);
                        int lineHeight=skylines.get(i).get(1);

                        if(lineX<=blockLeft&&blockLeft<nextX){
                            if(lineX==blockLeft){
                                if(lineHeight<blockHeight){
                                    addCord(blockLeft, blockHeight, tmpList);
                                }
                                else {
                                    tmpList.addLast(skylines.get(i));
                                }
                            }
                            else {
                                tmpList.addLast(skylines.get(i));
                                if(lineHeight<blockHeight){
                                    addCord(blockLeft, blockHeight, tmpList);
                                }
                            }

                        }
                        else if(blockLeft<lineX&&lineX<blockRight){
                            if(lineHeight>blockHeight){
                                tmpList.addLast(skylines.get(i));
                            }
                        }
                        else if(lineX<=blockRight&&blockRight<nextX){
                            int preLineHeight=findHeight(i-1);
                            if(lineX==blockRight){
                                if((preLineHeight<lineHeight && blockHeight==lineHeight )==false){
                                    tmpList.addLast(skylines.get(i));
                                }
                            }
                            else {
                                if(blockHeight>lineHeight){
                                    addCord(blockRight,lineHeight,tmpList);
                                }

                            }
                        }
                        else {
                            tmpList.addLast(skylines.get(i));
                        }

                    }

                    skylines=tmpList;
                }
            }
        }

        return skylines;
    }

    private void addCord(int x, int height, LinkedList<List<Integer>> tmpList) {
        LinkedList<Integer> lines = new LinkedList<>();
        lines.addLast(x);
        lines.addLast(height);
        tmpList.addLast(lines);
    }

    private void addCord(int x, int y) {
        addCord(x, y, skylines);
    }

    private int findLine(int x){
        for(int i=0;i<skylines.size();i++){
            int lineX=skylines.get(i).get(0);
            if(lineX<x){
                return i-1;
            }
            else if(lineX==x){
                return i;
            }
        }
        return -1;
    }

    private int findHeight(int lineIndex){
        if(lineIndex<0||lineIndex>=skylines.size())return 0;
        return skylines.get(lineIndex).get(1);
    }
}
