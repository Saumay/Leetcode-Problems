class Solution {
    
    // 1) Brute Force
//     public int trap(int[] height) {
//         int n = height.length;
        
//         int res = 0;
//         for(int i=1 ; i<n-1 ; i++) {
//             int leftMax = 0;
//             int rightMax = 0;
            
//             for(int l=0 ; l<i ; l++)
//                 leftMax = Math.max(leftMax, height[l]);
//             for(int r=i+1 ; r<n ; r++)
//                 rightMax = Math.max(rightMax, height[r]);
            
//             int trapped = Math.min(leftMax, rightMax) - height[i];
//             if(trapped > 0)
//                 res += trapped;
//         }
//         return res;
//     }
    
    
    // 2) Using DP -> Prefix max and Suffix max. O(n) space
//     public int trap(int[] height) {
//         int n = height.length;
        
//         int[] suffixMax = new int[n];
        
//         suffixMax[n-1] = height[n-1];
//         for(int i=n-2 ; i>=0 ; i--)
//             suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        
//         int leftMax = 0;
//         int res = 0;
//         for(int i=0 ; i<n-1 ; i++) {
//             int trap = Math.min(leftMax, suffixMax[i+1]) - height[i];
//             if(trap > 0)
//                 res += trap;
            
//             leftMax = Math.max(leftMax, height[i]);
//         }
//         return res;
//     }
    
    
    // 3) Using 2 pointers. O(1) space
    public int trap(int[] height) {
        int n = height.length;
        
        int left = 0, right = n-1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        
        while(left <= right) {
            if(height[left] <= height[right]) {
                if(leftMax > height[left])
                    res += leftMax - height[left];
                else
                    leftMax = height[left];
                left++;
            } else {
                if(rightMax > height[right])
                    res += rightMax - height[right];
                else
                    rightMax = height[right];
                right--;
            }
        }
        return res;
    }
}