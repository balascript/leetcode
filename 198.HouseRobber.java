public class Solution {
    public int rob(int[] nums) {
       int ifRobbedPrevious = 0; 	// max monney can get if rob current house
	    int ifDidntRobPrevious = 0; // max money can get if not rob current house
	    
	   
	    for(int i=0; i < nums.length; i++) 
	    {
	    	
	        int currRobbed = ifDidntRobPrevious + nums[i];
	        
	       
	        int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious); 
	        
	        
	        ifDidntRobPrevious  = currNotRobbed;
	        ifRobbedPrevious = currRobbed;
	    }
	    
	    return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
        
    }
}