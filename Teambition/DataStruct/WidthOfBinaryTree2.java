package Teambition.DataStruct;

import java.util.ArrayList;
import java.util.List;

public class WidthOfBinaryTree2 {
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
    List<Integer> poses=new ArrayList<>();
    List<Integer> widths=new ArrayList<>();
    public int widthOfBinaryTree(TreeNode root) {

        DFS(root,0,0);

        int maxWidth=0;

        for(int width:widths){

            maxWidth=Math.max(maxWidth, width);

        }
        return maxWidth;
    }

    void DFS(TreeNode node,int level,int pos){
        if(node==null)return;
        
        if(level>=poses.size())poses.add(pos);
        int width=pos-poses.get(level)+1;
        if(level>=widths.size())widths.add(width);
        if(width>widths.get(level))widths.set(level, width);

        DFS(node.left,level+1,pos*2);
        DFS(node.right,level+1,pos*2+1);
    }
}