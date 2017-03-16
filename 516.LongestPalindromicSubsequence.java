public class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] A= s.toCharArray();
        char[] B=(new StringBuilder(s).reverse()).toString().toCharArray();// toString()
        int m=s.length();
        int n=s.length();
        int[][] dp= new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j==0 || i==0){
                    dp[i][j]=0;
                    continue;
                }
                if(A[i-1]==B[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}