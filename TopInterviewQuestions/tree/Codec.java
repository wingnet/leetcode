package TopInterviewQuestions.tree;

public class Codec {
    public class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        se(root,sb);
        return sb.toString();
    }

    void se(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("{}");
            return;
        }
        sb.append('{');
        sb.append(root.val);
        se(root.left,sb);
        se(root.right,sb);
        sb.append('}');
    }

    static class Node_Pos{
        TreeNode node;
        int pos;
    }

    Node_Pos de(String data,int start){
        Node_Pos np=new Node_Pos();
        if(data.charAt(start+1)=='}'){
            
            np.node=null;
            np.pos=start+2;
            return np;
        }

        int valEnd=data.indexOf('{',start+1);
        int val=Integer.parseInt(data.substring(start+1, valEnd));
        TreeNode node=new TreeNode(val);
        Node_Pos left=de(data,valEnd);
        Node_Pos right=de(data,left.pos);
        node.left=left.node;
        node.right=right.node;
        np.node=node;
        np.pos=right.pos+1;
        return np;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Node_Pos np= de(data,0);
        return np.node;
    }
}