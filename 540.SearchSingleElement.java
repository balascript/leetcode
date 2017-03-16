public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        int a=0;int e=nums.length-1;
        while(a<e){
            int mid= a+ (e-a+1)/2;
            if(nums[mid]==nums[mid+1]){
                if((e-mid+1)%2==0)
                   e=mid-1;
                else 
                    a=mid;
                continue;
            }
            else if(nums[mid]==nums[mid-1]){
                if((mid-a+1)%2==0)
                    a=mid+1;
                else 
                    e=mid;
                continue;
            }
            return nums[mid];
            
        }
        
        return nums[a];
        
        //return search (nums,0, nums.length-1);
    }
    public int search(int[] nums, int a, int e){
        if(a==e) return nums[a];
        int mid= a+ (e-a+1)/2;
        if(nums[mid]==nums[mid+1]){
            if((e-mid+1)%2==0)
                return search(nums,a,mid-1);
            return search(nums,mid,e);
                
        }
        else if(nums[mid]==nums[mid-1]){
            if((mid-a+1)%2==0)
            return search(nums,mid+1,e);
            
            return search(nums,a,mid);
                
        }
        return nums[mid];
    }
}