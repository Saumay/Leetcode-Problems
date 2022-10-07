class Solution {
    
    /*
    Solution 1:
        - Sorting
        - Two pointers
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0 ; i<nums.length && nums[i]<=0 ; i++) {
            if(i==0 || nums[i]!=nums[i-1])
                twoSum(nums, i, res);
        }
        return res;
    }
    
    private void twoSum(int[] nums, int pivot, List<List<Integer>> res) {
        int left = pivot+1;
        int right = nums.length-1;
        
        while(left < right) {
            long sum = nums[pivot] + nums[left] + nums[right];
            
            if(sum < 0)
                left++;
            else if(sum > 0)
                right--;
            else {
                res.add(List.of(nums[pivot], nums[left], nums[right]));
                left++;
                while(left<right && nums[left]==nums[left-1])
                    left++;
            }
        }
    }
    
    
    /*
    Solution 2:
        - Sorting
        - Hashset(additional memory)
    */
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
//         List<List<Integer>> res = new ArrayList<>();
    
//         for(int i=0 ; i<nums.length && nums[i]<=0 ; i++) {
//             if(i==0 || nums[i]!=nums[i-1])
//                 twoSum(nums, i, res);
//         }
//         return res;
//     }
    
//     private void twoSum(int[] nums, int pivot, List<List<Integer>> res) {
        
//         Set<Integer> set = new HashSet<>();
        
//         for(int j=pivot+1 ; j<nums.length ; j++) {
//             int complement = -nums[pivot]-nums[j];
//             if(set.contains(complement)) {
//                 res.add(List.of(nums[pivot], nums[j], complement));

//                 while(j+1<nums.length && nums[j]==nums[j+1])
//                     j++;
//             }
            
//             set.add(nums[j]);
//         }
//     }
    
    
    /*
    Solution 3:
        - No Sorting required
        - Hashsets(additional memory)
    */
//     public List<List<Integer>> threeSum(int[] nums) {
        
//         // For not processing dups in outer loop
//         Set<Integer> dups = new HashSet<>();
//         Set<List<Integer>> res = new HashSet<>();
        
//         for(int i=0 ; i<nums.length ; i++) {
//             if(dups.add(nums[i])) {
                
//                 Set<Integer> seen = new HashSet<>();
//                 for(int j=i+1 ; j<nums.length ; j++) {
//                     int complement = -nums[i]-nums[j];
                    
//                     if(seen.contains(complement)) {
//                         List<Integer> triplets = Arrays.asList(nums[i], nums[j], complement);
//                         Collections.sort(triplets);
//                         res.add(triplets);
//                     }
//                     seen.add(nums[j]);
//                 }
//             }
//         }
//         return new ArrayList<>(res);
//      }
}