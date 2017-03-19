public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        if(nums.length<=1) return 0;
        int n=nums.length;

        Map<Integer,Integer> map= new HashMap();
        map.put(0,-1);
        int sum = 0, max = 0;
        
        for (int i = 0; i <n; i++) {
            if(nums[i]==1) sum++;
            else sum--;
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }
        
        return max;
       
    }
    
}