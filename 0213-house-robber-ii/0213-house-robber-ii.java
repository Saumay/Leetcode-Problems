class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        
        return Math.max(getSum(nums, 0, n-2), getSum(nums, 1, n-1));
    }
    
    private int getSum(int[] nums, int start, int end) {
        int prevSum = 0;
        int curSum = 0;
        
        for(int i=start ; i<=end ; i++) {
            int temp = curSum;
            
            curSum = Math.max(curSum, prevSum + nums[i]);
            prevSum = temp;
        }
        return curSum;
    }
}