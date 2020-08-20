package Teambition.DataStruct;

import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> buf=new LinkedList<>();
        LinkedList<Integer> output=new LinkedList<>();

        if(root==null)return output;

        buf.addLast(root);
        while(buf.isEmpty()==false){
            TreeNode node=buf.pollLast();
            output.addFirst(node.val);
            
            
            if(node.left!=null)buf.addLast(node.left);
            if(node.right!=null)buf.addLast(node.right);
        }

        return output;
    }
}