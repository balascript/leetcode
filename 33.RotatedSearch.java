/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

*/
public class RotatedSearch {
    public int search(int[] nums, int t) {
        if(nums.length==0) return -1;
        
        int lo=0;
        int hi=nums.length-1;
        
        if(lo==hi) return (nums[lo]==t)?lo:-1;
        int start=0;
        if(nums[lo]<nums[hi]){
            int ind =Arrays.binarySearch(nums,t);
            if(ind<0) return -1;
            
            return ind;
        } 
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]>nums[hi]) lo=mid+1;
            else hi=mid;
        }
        start=lo;
        //System.out.println(start);
        lo=0;
        hi=nums.length-1;
        while(lo<=hi){
            int mid= (lo+hi)/2;
            int rmid= (mid+start)%nums.length;
            if(nums[rmid]==t) return rmid;
            
            if (nums[rmid]<t) lo=mid+1;
            
            else hi=mid-1;
        }
        
        return -1;
        
    }
}