package Medium.Tree_Map;

public class Connect {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        DFS(root,null,0);
        return root;
    }

    void DFS(Node node,Node parentLeft,int level){
        if(node==null)return;

        if(parentLeft==null){
            node.next=null;
        }
        else{
            Node tmp=parentLeft.right;
            for(int i=0;i<level;i++){
                tmp=tmp.left;
            }
            node.next=tmp;
        }

        DFS(node.left,node,0);
        DFS(node.right,parentLeft,level+1);
    }
}