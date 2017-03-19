public class GreaterTree {
    int val=0;
    
    public TreeNode convertBST(TreeNode root){
        inorder(root);
        return root;
    }
    public void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.right);
        root.val+=val;
        val=root.val;
        inorder(root.left);
    }
    
    
}