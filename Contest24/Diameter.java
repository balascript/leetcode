public class Diameter {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        int ldia=diameterOfBinaryTree(root.left);
        int rdia=diameterOfBinaryTree(root.right);
        return Math.max(lh+rh,Math.max(ldia,rdia));
    }
    
    public int height(TreeNode node)
    {
        if (node == null)
            return 0;
        return (1 + Math.max(height(node.left), height(node.right)));
    }
}