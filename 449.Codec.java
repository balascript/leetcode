/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb= new StringBuilder();
        if(root!=null)
            preorder(sb,root);
        
       // System.out.println(sb.toString());
        
        return sb.toString();
    }
    
    public void preorder(StringBuilder sb, TreeNode node){
        sb.append(node.val);
        if(node.left!=null){
            sb.append(',');
            preorder(sb,node.left);
        }
        if(node.right!=null){
            sb.append(',');
            preorder(sb,node.right);
        }
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()<1)
            return null;
            
        String[] pre= data.split(",");
        int[] p= new int[pre.length];
        for(int j=0;j<p.length;j++)
            p[j]=Integer.parseInt(pre[j]);
        int[] i= new int[p.length];
        
        System.arraycopy(p,0,i,0,p.length);
        Arrays.sort(i);
        
        // here we have both pre order and inorder traversal of our tree
        
       // System.out.println(Arrays.toString(p));
       // System.out.println(Arrays.toString(i));
        return buildTree(i,0,i.length-1,p,0,p.length-1);
        
    }
    
    public TreeNode buildTree(int[] in,int is, int ie, int[] pre, int ps, int pe){
        if(ie<is) return null;
        if(is==ie)
            return new TreeNode(in[is]);
        int index= Arrays.binarySearch(in,pre[ps]);
        int length= index-is;
        TreeNode root= new TreeNode(pre[ps]);
        
        root.left=buildTree(in,is,index-1,pre,ps+1,ps+length);
        
        root.right=buildTree(in,index+1,ie,pre,ps+length+1,pe);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));