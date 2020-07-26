package TopInterviewQuestions.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FindWords {
    static class Cord{
        int row;
        int col;

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Cord){
                Cord cord=(Cord)obj;
                return this.row==cord.row && this.col==cord.col;
            }
            return false;
        }
        public Cord(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    char[][] board;
    int rowNum;
    int colNum;
    HashMap<Character,HashSet<Cord>> char2Cord=new HashMap<>();
    public List<String> findWords(char[][] board, String[] words) {
        this.board=board;
        rowNum=board.length;
        colNum=board[0].length;

        for(int row=0;row<rowNum;row++){
            for(int col=0;col<colNum;col++){
                char ch=board[row][col];
                if(char2Cord.containsKey(ch)){
                    char2Cord.get(ch).add(new Cord(row,col));
                }
                else{
                    HashSet<Cord> set=new HashSet<>();
                    set.add(new Cord(row,col));
                    char2Cord.put(ch, set);
                }
            }
        }
        List<String> result=new ArrayList<>();
        for(String word:words){
            if(char2Cord.containsKey(word.charAt(0))){
                HashSet<Cord> set=char2Cord.get(word.charAt(0));
                for(Cord cord:set){
                    LinkedList<Cord> inStack=new LinkedList<>();
                    if(DFS(word,cord,0,inStack)){
                        result.add(word);
                        break;
                    }
                }
            }
        }

        return result;
    }

    boolean DFS(String word, Cord cord, int index, LinkedList<Cord> inStack){
        if(index==word.length())return true;
        if(cord.row<0||cord.row>=rowNum)return false;
        if(cord.col<0||cord.col>=colNum)return false;
        if(inStack.contains(cord))return false;
        char ch=board[cord.row][cord.col];
        if(ch!=word.charAt(index))return false;

        inStack.addLast(cord);

        Cord[] neighbors=new Cord[4];
        neighbors[0]=new Cord(cord.row-1,cord.col);
        neighbors[1]=new Cord(cord.row+1,cord.col);
        neighbors[2]=new Cord(cord.row,cord.col-1);
        neighbors[3]=new Cord(cord.row,cord.col+1);
        for(Cord cord0:neighbors){
            if(DFS(word,cord0,index+1,inStack))return true;
        }

        inStack.removeLast();
        return false;
    }
}