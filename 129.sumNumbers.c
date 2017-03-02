void helper(struct TreeNode* node,  int *sum, int cur){
        if(node == NULL) return;
        int t=cur*10 + node->val;
        
        if(node->left==NULL && node->right==NULL){
            *sum= *sum+t;
            return;
           
        }
        else {
            helper(node->left,sum,t);
            helper(node->right,sum,t);
        }

        return;
}
int sumNumbers(struct TreeNode* root) {
    int sum=0;
    helper(root,&sum,0);
    return sum;
}