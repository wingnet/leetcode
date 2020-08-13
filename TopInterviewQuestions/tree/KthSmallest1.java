package TopInterviewQuestions.tree;

import java.util.LinkedList;

public class KthSmallest1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        int count=0;
        LinkedList<TreeNode> list=new LinkedList<>();
        TreeNode node=root;
        while(true){
            while(node!=null){
                list.addLast(node);
                node=node.left;
            }

            node=list.pollLast();
            count++;
            if(count==k)return node.val;
            else{
                node=node.right;
            }
        }
    }
}