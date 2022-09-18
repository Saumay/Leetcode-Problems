class Solution {

    // 1)
//     public int trap(int[] height) {
//         int n = height.length;
        
//         int[] suffix = new int[n];
//         suffix[n-1] = height[n-1];
//         for(int i=n-2 ; i>=0 ; i--) {
//             suffix[i] = Math.max(height[i], suffix[i+1]);
//         }
        
//         int prefixMax = height[0];
//         int trapped = 0;
//         for(int i=1 ; i<height.length-1 ; i++) {
//             int diff = Math.min(prefixMax, suffix[i+1]) - height[i];
//             if(diff > 0)
//                 trapped += diff;
            
//             prefixMax = Math.max(prefixMax, height[i]);
//         }
//         return trapped;
//     }
    
    // 2)
    public int trap(int[] height) {
        int n = height.length;
        
        int left = 0;
        int right = n-1;
        int leftMax = 0;
        int rightMax = 0;
        
        int trapped = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] > leftMax)
                    leftMax = height[left];
                else
                    trapped += leftMax - height[left];
                left++;
            } else {
                if(height[right] > rightMax)
                    rightMax = height[right];
                else
                    trapped += rightMax - height[right];
                right--;   
            }
        }
        return trapped;
    }
}