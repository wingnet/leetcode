package TopInterviewQuestions.linked_list;

import java.util.HashMap;

public class CopyRandomList {
    static class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {

        Node source=head;
        Node dummyHead=new Node(-1);
        Node current=dummyHead;

        HashMap<Node,Integer> node2index=new HashMap<>();
        HashMap<Integer,Node> index2node=new HashMap<>();

        int count=0;
        while(source!=null){
            node2index.put(source,count);
            
            current.next=new Node(source.val);
            index2node.put(count, current.next);

            count++;

            current=current.next;
            source=source.next;
        }

        source=head;
        current=dummyHead.next;
        while(source!=null){
            if(source.random!=null){
                int index=node2index.get(source.random);
                current.random=index2node.get(index);
            }
            source=source.next;
            current=current.next;
        }

        return dummyHead.next;
    }
}