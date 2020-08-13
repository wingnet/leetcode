package TopInterviewQuestions.linked_list;

public class SortList {
    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;

        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        while(fast!=null){
            
            if(fast.next==null)break;
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode _2nd=slow.next;
        slow.next=null;
        head=sortList(head);
        _2nd=sortList(_2nd);
        ListNode tmp=dummy;
        while(head!=null&&_2nd!=null){
            if(head.val<_2nd.val){
                dummy.next=head;
                head=head.next;
                dummy=dummy.next;
            }
            else{
                dummy.next=_2nd;
                _2nd=_2nd.next;
                dummy=dummy.next;
            }
        }
        if(head!=null)dummy.next=head;
        if(_2nd!=null)dummy.next=_2nd;
        return tmp.next;
    }
}