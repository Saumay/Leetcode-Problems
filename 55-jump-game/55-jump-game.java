class Solution {
//     public boolean canJump(int[] nums) {
//         int n = nums.length;
//         boolean[] dp = new boolean[n];
        
//         dp[n-1] = true;
        
//         for(int i=n-2 ; i>=0 ; i--) {
//             int jump = nums[i];
            
//             for(int j=0 ; j<=jump ; j++) {
//                 if(j+i<n && dp[j+i]) {
//                     dp[i] = true;
//                     break;
//                 }
//             }
//         }
//         return dp[0];
//     }
    
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max = 0;
        for(int i=0; i<=max; i++){
            max = Math.max(max, i+nums[i]);
            if(max >= len-1)  return true;
        }
        return false;
    }
}