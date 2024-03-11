class Solution {
    public boolean check(int[] nums) {
        int first = nums[0];
        int dipCount = 0;
        for(int i=1 ; i<nums.length ; i++) {
            if(nums[i-1] > nums[i])
                dipCount++;
            if(dipCount>1)
                return false;
            if(dipCount==1 && nums[i]>first)
                return false;
        }
        return true;
    }
}