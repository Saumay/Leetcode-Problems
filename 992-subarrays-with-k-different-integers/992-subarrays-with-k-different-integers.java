class Solution {
    // 1) Finding countWithAtMostK for k.
//          Finding countWithAtMostK for k-1.
//          Subtracting countWithAtMostK for k with countWithAtMostK for k-1
//     public int subarraysWithKDistinct(int[] nums, int k) {
//         return getCountWithAtMostK(nums, k) - getCountWithAtMostK(nums, k-1);
//     }
    
//     private int getCountWithAtMostK(int[] nums, int k) {
//         int n = nums.length;
//         Map<Integer, Integer> map = new HashMap<>();
        
//         int count = 0, left = 0;
//         for(int right=0 ; right<n ; right++) {
//             map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            
//             while(map.size() > k) {
//                 map.put(nums[left], map.get(nums[left])-1);
                
//                 if(map.get(nums[left])==0)
//                     map.remove(nums[left]);
                
//                 left++;
//             }
//             count += right-left+1;
//         }
//         return count;
//     }
    
    
    // 2) Maintaining 2 hashMaps. 1st one storing atMost K unique elements. 2nd one storing atMost k-1 unique elements.
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length, left1=0, left2=0;
        int count = 0;
        
        Window window1 = new Window();
        Window window2 = new Window();
        
        for(int right=0 ; right<n ; right++) {
            int num = nums[right];
            
            window1.add(num);
            window2.add(num);
            
            while(window1.size() >= k) {
                window1.remove(nums[left1++]);
            }
            while(window2.size() > k) {
                window2.remove(nums[left2++]);
            } 
            
            count += left1-left2;
        }
        return count;
    }
    
    class Window {
        private Map<Integer, Integer> freqMap;
        
        public Window() {
            freqMap = new HashMap<>();
        }
        
        public void add(int x) {
            freqMap.put(x, freqMap.getOrDefault(x, 0)+1);
        }
        
        public void remove(int x) {
            freqMap.put(x, freqMap.getOrDefault(x, 0)-1);
            if(freqMap.get(x)==0)
                freqMap.remove(x);
        }
        
        public int size() {
            return freqMap.size();
        }
    }
}