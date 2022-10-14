class Solution {
    
    // 1) Recursion
//     public int climbStairs(int n) {
//         if(n<2)
//             return 1;
        
//         return climbStairs(n-1) + climbStairs(n-2);
//     }
    
    
    // 2) Recursion + Memoization
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
        
//         return climbStairs(n, dp);
//     }
    
//     private int climbStairs(int n, int[] dp) {
//         if(n<2)
//             return 1;
//         if(dp[n] != 0)
//             return dp[n];
        
//         dp[n] = climbStairs(n-1, dp) + climbStairs(n-2, dp);
//         return dp[n];
//     }
    
    
    // 3) Tabulation
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2 ; i<=n ; i++)
            dp[i] = dp[i-1] + dp[i-2];
        
        return dp[n];
    }
}