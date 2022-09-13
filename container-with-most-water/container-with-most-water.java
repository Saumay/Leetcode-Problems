class Solution {
    public int maxArea(int[] height) {
        
        if(height==null || height.length==0)
            return 0;
        
        int n = height.length;
        int left = 0;
        int right = n-1;
        
        int maxArea = 0;
        while(left < right) {
            int area = (right-left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}