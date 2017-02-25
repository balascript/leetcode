//75. simple

public class SortColors {
    public void sortColors(int[] nums) {
        int j = 0, k = nums.length-1;
        int i=0;
        for(;i<=k && nums[i]==0 ;i++);
        for(;k>=i && nums[k]==2;k--);
        for (; i <= k; ++i){
            if (nums[i] == 0 && i != j)
             swap(nums, i--, j++);//(A[i--], A[j++]);
            else if (nums[i] == 2 && i != k)
             swap(nums,i--, k--);
    }
    }
    public void swap(int[] A, int i, int j){
        int temp= A[i];
        A[i]=A[j];
        A[j]= temp;
    }
}