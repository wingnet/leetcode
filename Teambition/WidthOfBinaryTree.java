package Teambition;

import java.util.ArrayList;
import java.util.LinkedList;

public class WidthOfBinaryTree {
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
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=root==null?0:1;
        LinkedList<TreeNode> list0=new LinkedList<>();
        list0.add(root);
        while(list0.isEmpty()==false){
            LinkedList<TreeNode> tmpList=new LinkedList<>();
            while(list0.isEmpty()==false){
                TreeNode node=list0.pollFirst();
                if(node!=null){
                    tmpList.add(node.left);
                    tmpList.add(node.right);
                }
                else{
                    tmpList.add(null);
                    tmpList.add(null);
                }
            }
 
            while(tmpList.isEmpty()==false && tmpList.getFirst()==null)tmpList.removeFirst();
            while(tmpList.isEmpty()==false && tmpList.getLast()==null)tmpList.removeLast();
            maxWidth=Math.max(maxWidth,tmpList.size());

            list0=tmpList;
        }
        return maxWidth;
    }
}