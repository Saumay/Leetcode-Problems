class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getCountWithAtMostK(nums, k) - getCountWithAtMostK(nums, k-1);
    }
    
    private int getCountWithAtMostK(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int right=0 ; right<n ; right++) {
            int rightVal = nums[right];
            map.put(rightVal, map.getOrDefault(rightVal, 0)+1);
            
            while(map.size() > k) {
                int leftVal = nums[left];
                
                map.put(leftVal, map.get(leftVal)-1);
                if(map.get(leftVal) == 0)
                    map.remove(leftVal);
                
                left++;
            }
            count += right-left+1;
        }
        return count;
    }
}