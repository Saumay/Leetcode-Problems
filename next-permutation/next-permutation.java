class Solution {
    
    // Article -> https://leetcode.com/problems/next-permutation/discuss/2323893/Using-Binary-Search-in-Java-(clean-and-readable)
    public void nextPermutation(int[] nums) {
        
        // Step 1: Iterate from the end of the array
        for(int i=nums.length-1 ; i>0 ; i--) {
            
            // Step 2: Find the point where nums[i-1] < nums[i] 
            if(nums[i-1]<nums[i]) {
                
                // Step 3: Find index of the just greater element in the array[i, n) using binary search(since array[i,n) is sorted in descending order)
                int nextGreaterIdx = findGreaterBinarySearch(nums, i, nums.length-1, nums[i-1]);
                
                // Step 4: Swap (i-1)th element and just greater element
                swap(nums, i-1, nextGreaterIdx);
                
                // Step 4: Reverse the array[i, n)
                reverse(nums, i, nums.length-1);
                return;
            }
        }
        
        // Just reverse the array if the array is sorted in descending order.
        reverse(nums, 0, nums.length-1);
    }
    
    private int findGreaterBinarySearch(int[] nums, int lo, int hi, int target) {
        int ceil = 0;
        
        while(lo<=hi) {
            int mid = lo + (hi-lo)/2;
            
            if(nums[mid] > target) {
                ceil = mid;
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return ceil;
    }
    
    private void reverse(int[] nums, int start, int end) {
        for(int i=start,j=end ; i<j ; i++,j--)
            swap(nums, i, j);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }
}