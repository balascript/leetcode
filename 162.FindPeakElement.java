public class Solution {
    public int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        
        if(start==end)
            return start;
        
        
        while(start<end){
            if(start+1==end)
             return nums[start]>nums[end]? start:end;
            int mid= start+(end-start)/2;
            
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                return mid;
            else if(nums[mid-1]<nums[mid] && nums[mid]<nums[mid+1])
                start=mid+1;
            else
                end = mid-1;
        }
        
        return start;
    }
}