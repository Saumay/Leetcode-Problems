class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        for(int i=1 ; i<n ; i++) {
            dp[i] = dp[i-1];
            
            if(i-2 >= 0)
                dp[i] = Math.max(dp[i], dp[i-2] + nums[i]);
            else
                dp[i] = Math.max(dp[i], nums[i]);
        }
        return dp[n-1];
    }
}