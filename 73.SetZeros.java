public class SetZeros {
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)
            return;
            
        int[] rows=new int[matrix.length];
        int[] cols=new int[matrix[0].length];
        
        for(int i=0;i<rows.length;i++){
            for(int j=0;j<cols.length;j++){
                if(matrix[i][j]==0){
                    rows[i]=1;
                    cols[j]=1;
                }
            }
        }
        for(int i=0;i<rows.length;i++)
            for(int j=0;j<cols.length;j++)
                if(rows[i]==1 || cols[j]==1)
                    matrix[i][j]=0;
        
        
    }
}