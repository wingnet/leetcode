package TopInterviewQuestions.tree;

public class KthSmallest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int count=0;
    int k;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        DFS(root);
        return result;
    }

    void DFS(TreeNode root){
        if(root==null)return;
        DFS(root.left);
        count++;
        if(count==k){
            result=root.val;
            return;
        }
        else if(count>k){
            return;
        }
        else{
            DFS(root.right);
        }
    }
}