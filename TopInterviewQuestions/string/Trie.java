package TopInterviewQuestions.string;

public class Trie {
    static class Char_Tail{
        Char_Tail[] next;
        boolean isEnd;
    }
    Char_Tail[] root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new Char_Tail[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Char_Tail[] current=root;
        for(int i=0;i<word.length();i++){

            int index=word.charAt(i)-'a';
            if(current[index]==null)current[index]=new Char_Tail();
            Char_Tail curNode=current[index];
            if(i==word.length()-1){
                curNode.isEnd=true;
            }
            else{
                if(curNode.next==null){
                    curNode.next=new Char_Tail[26];
                }
                current=curNode.next;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Char_Tail[] current=root;
        for(int i=0;i<word.length();i++){

            int index=word.charAt(i)-'a';
            if(current==null || current[index]==null){
                return false;
            }
            Char_Tail curNode=current[index];
            if(i==word.length()-1){
                return curNode.isEnd;
            }
            
            current=curNode.next;
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Char_Tail[] current=root;
        for(int i=0;i<prefix.length();i++){

            int index=prefix.charAt(i)-'a';
            if(current==null || current[index]==null){
                return false;
            }
            
            current=current[index].next;
        }
        return true;
    }
}