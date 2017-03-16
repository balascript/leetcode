public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
     public int helper(int i, HashMap<String ,Integer> map, int[] M, int j){
        if(i<0) return 0;
        if(i==0) return 1;
        if(j== M.length) return 0;

        if(!map.containsKey(i+"-"+j))
        {
            int val= map.getOrDefault((i-M[j])+"-"+j , 0)+map.getOrDefault(i+"-"+(j+1),0);//helper(i-M[j],map,M,j) + helper(i,map,M,j+1);
            map.put(i+"-"+j,val);
        }

        return map.get(i+"-"+j);
    }
}