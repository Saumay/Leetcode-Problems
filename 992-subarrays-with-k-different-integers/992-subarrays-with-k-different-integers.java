class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getCountWithAtMostK(nums, k) - getCountWithAtMostK(nums, k-1);
    }
    
    private int getCountWithAtMostK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        int count = 0, left = 0;
        for(int right=0 ; right<n ; right++) {
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            
            while(map.size() > k) {
                map.put(nums[left], map.get(nums[left])-1);
                
                if(map.get(nums[left])==0)
                    map.remove(nums[left]);
                
                left++;
            }
            count += right-left+1;
        }
        return count;
    }
}