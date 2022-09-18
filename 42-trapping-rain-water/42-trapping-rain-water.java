class Solution {

    public int trap(int[] height) {
        int n = height.length;
        
        int[] suffix = new int[n];
        suffix[n-1] = height[n-1];
        for(int i=n-2 ; i>=0 ; i--) {
            suffix[i] = Math.max(height[i], suffix[i+1]);
        }
        
        int prefixMax = height[0];
        int trapped = 0;
        for(int i=1 ; i<height.length-1 ; i++) {
            int diff = Math.min(prefixMax, suffix[i+1]) - height[i];
            if(diff > 0)
                trapped += diff;
            
            prefixMax = Math.max(prefixMax, height[i]);
        }
        return trapped;
    }
}