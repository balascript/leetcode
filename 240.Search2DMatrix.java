public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        if(n==0) return false;
        int m= matrix[0].length;
        if(m==0) return false;
        int i=0;
        
        while(i<n){
            if(matrix[i][0]>target) return false;
            if(Arrays.binarySearch(matrix[i++],target)>=0)
                return true;
        }
        return false;
    }
}