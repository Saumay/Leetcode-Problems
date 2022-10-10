class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        
        int prev = lower-1;
        for(int i=0 ; i<nums.length ; i++) {
            int cur = nums[i];
            
            if(prev+1 <= cur-1)
                res.add(getRange(prev+1, cur-1));
            
            prev = cur;
        }
        if(prev+1 <= upper)
            res.add(getRange(prev+1, upper));
        
        return res;
    }
    
    private String getRange(int lower, int upper) {
        if(lower==upper)
            return String.valueOf(lower);
        
        return lower + "->" + upper;
    }
}