package TopInterviewQuestions.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FindWords1 {
    Trie trie=new Trie();
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
    int maxLen;
    HashSet<String> result;
    
    public List<String> findWords(char[][] board, String[] words) {
        this.board=board;
        rowNum=board.length;
        colNum=board[0].length;

        maxLen=0;
        for(String word:words){
            trie.insert(word);
            maxLen=Math.max(maxLen,word.length());
        }

        result=new HashSet<>();
        StringBuilder path=new StringBuilder();
        LinkedList<Cord> inStack=new LinkedList<>();
        
        for(int row=0;row<rowNum;row++){
            for(int col=0;col<colNum;col++){
                DFS(new Cord(row,col),0,path,inStack);
            }
        }

        List<String> res=new ArrayList<>();
        result.forEach(item -> res.add(item));
        return res;
    }

    void DFS(Cord cord, int index, StringBuilder path, LinkedList<Cord> inStack){
        if(index==maxLen)return;
        if(cord.row<0||cord.row>=rowNum)return;
        if(cord.col<0||cord.col>=colNum)return;
        if(inStack.contains(cord))return;

        char ch=board[cord.row][cord.col];
        path.append(ch);
        String strPath=path.toString();
        if(trie.startsWith(strPath)){
            if(trie.search(strPath)){
                result.add(strPath);
            }
            inStack.addLast(cord);

            Cord[] neighbors=new Cord[4];
            neighbors[0]=new Cord(cord.row-1,cord.col);
            neighbors[1]=new Cord(cord.row+1,cord.col);
            neighbors[2]=new Cord(cord.row,cord.col-1);
            neighbors[3]=new Cord(cord.row,cord.col+1);
            for(Cord cord0:neighbors){
                DFS(cord0,index+1,path,inStack);
            }

            inStack.removeLast();
        }
        path.deleteCharAt(path.length()-1);
    }
}