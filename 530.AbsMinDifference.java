public class AbsMinDifference {
    int m=Integer.MAX_VALUE;
    TreeNode prev=null;
    public int getMinimumDifference(TreeNode root) {
        if(root==null)
            return m;
        getMinimumDifference(root.left);
        if(prev!=null){
            m=Math.min(m,Math.abs(root.val-prev.val));
        }
        prev=root;
        getMinimumDifference(root.right);
        
        return m;

    }
}