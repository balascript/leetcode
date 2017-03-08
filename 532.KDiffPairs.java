public class KDiffPairs {
    private Set<Integer> set= new HashSet();
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        if(k==0){
            Arrays.sort(nums);
            for(int i=1;i<nums.length;i++){
                if(nums[i]==nums[i-1])
                    set.add(nums[i]);
            }
            return set.size();
        }
        for(int c:nums)
            set.add(c);
        int count=0;
        for(Integer d:set.toArray(new Integer[set.size()])){
            if(set.contains(d-k))
                count++;
        }
        return count;
    }
}