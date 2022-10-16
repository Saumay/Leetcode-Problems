class Solution {
    // 1) Tabulation
    public int rob(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        
        for(int i=0 ; i<n ; i++) {
            dp[i] = Math.max(getDefaultVal(dp, i-1), getDefaultVal(dp, i-2) + nums[i]);
        }
        return dp[n-1];
    }
    
    private int getDefaultVal(int[] dp, int idx) {
        return idx<0 ? 0 : dp[idx];
    }
    
    
    // 2) Tabulation with space optimization
//     public int rob(int[] nums) {
//         int prevSum = 0;
//         int curSum = 0;
        
//         for(int num : nums) {
//             int temp = curSum;
            
//             curSum = Math.max(curSum, prevSum + num);
//             prevSum = temp;
//         }
//         return curSum;
//     }
}