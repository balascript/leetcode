public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix.length;
        if(n==0) return false;
        
        int m=matrix[0].length;
        if(m==0) return false;
        int total= m*n;
        int start=0;
        int end=m*n -1;
        
        while(start<end){
            int mid= start+ (end-start)/2;
            int i=mid/m;
            int j=mid%m;
            
            if(target==matrix[i][j])
                return true;
            else if(target>matrix[i][j])
                start=mid+1;
            else
                end=mid-1;
        }
        
        return (matrix[start/m][start%m] == target);
    }
}