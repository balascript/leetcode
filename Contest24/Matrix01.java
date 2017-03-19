public class Matrix01 {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int n=matrix.size();
        int m=matrix.get(0).size();
        int[][] mat= new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=matrix.get(i).get(j);
                if(mat[i][j]!=0)
                    mat[i][j]=Integer.MAX_VALUE;
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==Integer.MAX_VALUE) continue;
                int val= mat[i][j];
                 if(i<n-1){
                     if(mat[i+1][j]!=0)
                        mat[i+1][j]=Math.min(val+1, mat[i+1][j]);
                 }
                 if(j<m-1 && mat[i][j+1]!=0){
                     mat[i][j+1]=Math.min(val+1, mat[i][j+1]);
                 }
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int val= mat[i][j];
                 if(i>0){
                     if(mat[i-1][j]!=0)
                        mat[i-1][j]=Math.min(val+1, mat[i-1][j]);
                 }
                 if(j>0 && mat[i][j-1]!=0){
                     mat[i][j-1]=Math.min(val+1, mat[i][j-1]);
                 }
            }
        }
        
        matrix.clear();
        
        for(int i=0;i<n;i++){
            List<Integer> list= new ArrayList(m);
            for(int j=0;j<m;j++){
                list.add(mat[i][j]);
            }
            matrix.add(list);
        }
        return matrix;
    }
    
}