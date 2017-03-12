/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class StringToTree {
    Stack<TreeNode> stk;
    public TreeNode str2tree(String s) {
        if(s.equals("")) return null;
        stk= new Stack();
        char[] arr= s.toCharArray();
        TreeNode root=null;
        TreeNode temp=null;
        int i=0,j=0;
       try{
        while(j<arr.length){
            
            if(arr[j]==')'){
                temp= stk.pop();
                j++;
                i=j;
                continue;
            }
            if(arr[j]=='('){
                stk.push(temp);
                j++;
                i=j;
                continue;
            }
            
            while(j<arr.length && (Character.isDigit(arr[j]) || arr[j]=='-'))
                j++;
            int num= Integer.parseInt(s.substring(i,j));
           // System.out.println(num);
            if(temp==null){
                root= new TreeNode(num);
                temp=root;
                i=j;
                stk.push(temp);
            }
            else if (temp.left==null){
                temp.left= new TreeNode(num);
                temp= temp.left;
                
                i=j;
            }
            else{
                temp.right= new TreeNode(num);
                temp= temp.right;
                
                i=j;
            }
            
            i=j;
        }
       }catch(Exception e){
            return null;
        }
        return root;
        
    }
}