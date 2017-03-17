public class Solution {
    public int rob(int[] nums) {
        if (nums.length==1)
            return nums[0];
        return Math.max(robRange(nums,0,nums.length-2),robRange(nums,1,nums.length-1));
    }
    public int robRange(int[] nums,int start, int end) {
       int ifRobbedPrevious = 0; 	
	    int ifDidntRobPrevious = 0; 
	    

	    for(int i=start; i <= end; i++) 
	    {
	    
	        int currRobbed = ifDidntRobPrevious + nums[i];
	        
	       
	        int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious); 
	        
	        
	        ifDidntRobPrevious  = currNotRobbed;
	        ifRobbedPrevious = currRobbed;
	    }
	    
	    return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
        
    }
}