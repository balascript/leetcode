public class KLargestSelect {
    public int findKthLargest(int[] nums, int k) {
        return select(nums,0,nums.length-1,nums.length-k+1);
    }
    
    public int select(int[] arr,int start,int end,int k){
        if(start==end) return arr[start];
        
        int pivot_pos=partition(arr,start,end);
        int pivot_rank=pivot_pos-start+1;
        if(pivot_rank==k) return arr[pivot_pos];
        if(pivot_rank>k) return select(arr,start,pivot_pos-1,k);
        else
        return select(arr,pivot_pos+1,end,k-pivot_rank);
    }
    public int partition( int[] arr, int start, int end){
        int i=start;
        for(int j=start;j<end;++j){
            if(arr[j]<arr[end])
                swap(arr,i++,j);
        }
       // System.out.println(end+" "+i);
        swap(arr,end,i);
        return i;
    }
    public final void swap (int[] l, int i, int j) {
        int temp= l[i];
        l[i]=l[j];
        l[j]=temp;
    }
}