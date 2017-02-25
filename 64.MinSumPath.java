/***
64 Min Path
https://leetcode.com/problems/minimum-path-sum/

Simple DP solution ( unoptimized)


*/

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        int[][] S= new int[n][m];
        
        S[0][0]=grid[0][0];
        for(int i=1;i<n;i++)
            S[i][0]=S[i-1][0]+grid[i][0];
            
        for(int j=1;j<m;j++)
            S[0][j]=S[0][j-1]+grid[0][j];
            
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                S[i][j]=grid[i][j]+ Math.min(S[i-1][j],S[i][j-1]);
            }
        }
        
        return S[n-1][m-1];
        
    }
}