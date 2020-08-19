package Teambition;

import java.util.ArrayList;
import java.util.List;

public class WidthOfBinaryTree1 {
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

        List<Integer> spaces=new ArrayList<>();
        DFS(root,spaces,0,0,true);

        List<Integer> rightSpaces=new ArrayList<>();
        DFS(root,rightSpaces,0,0,false);

        int maxWidth=0;
        int fullWidth=1;
        for(int i=0;i<spaces.size();i++){
            int width=fullWidth-spaces.get(i)-rightSpaces.get(i);
            maxWidth=Math.max(maxWidth, width);
            fullWidth*=2;
        }
        return maxWidth;
    }

    void DFS(TreeNode node,List<Integer> spaces,int level,int space,boolean isLeft){
        if(node==null)return;
        if(level>=spaces.size())spaces.add(space);

        if(isLeft){
            DFS(node.left,spaces,level+1,space*2,isLeft);
            DFS(node.right,spaces,level+1,space*2+1,isLeft);
        }
        else{
            DFS(node.right,spaces,level+1,space*2,isLeft);
            DFS(node.left,spaces,level+1,space*2+1,isLeft);
        }
    }
}