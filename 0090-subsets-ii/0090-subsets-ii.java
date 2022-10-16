class Solution {
    
    // 1) Recursive 1: Sorting + HashSet + By pick or not pick methodology
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         Set<List<Integer>> resultSet = new HashSet<>();
//         Arrays.sort(nums);
        
//         backtrack(nums, 0, new LinkedList<>(), resultSet);
//         return new LinkedList<>(resultSet);
//     }
    
//     private void backtrack(int[] nums, int idx, List<Integer> tempList, Set<List<Integer>> resultSet) {
//         if(idx >= nums.length) {
//             resultSet.add(new LinkedList<>(tempList));
//             return;
//         }
        
//         tempList.add(nums[idx]);
//         backtrack(nums, idx+1, tempList, resultSet);
//         tempList.remove(tempList.size()-1);
        
//         backtrack(nums, idx+1, tempList, resultSet);
        
//     }
    
    
    // 2) Recursive 2: Sorting + HashSet + By iterating over all the elements starting from idx till end in the method.
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        Arrays.sort(nums);
        
        backtrack(nums, 0, new LinkedList<>(), resultSet);
        return new LinkedList<>(resultSet);
    }
    
    private void backtrack(int[] nums, int idx, List<Integer> tempList, Set<List<Integer>> resultSet) {
        resultSet.add(new LinkedList<>(tempList));
        
        for(int i=idx ; i<nums.length ; i++) {
            tempList.add(nums[i]);
            backtrack(nums, i+1, tempList, resultSet);
            tempList.remove(tempList.size()-1);
        }
    }
    
    
    // 3) Recursive 3: Sorting + By iterating over all the elements starting from idx till end in the method.
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<List<Integer>> result = new LinkedList<>();
//         Arrays.sort(nums);
        
//         backtrack(nums, 0, new LinkedList<>(), result);
//         return result;
//     }
    
//     private void backtrack(int[] nums, int idx, List<Integer> tempList, List<List<Integer>> result) {
//         result.add(new LinkedList<>(tempList));
        
//         for(int i=idx ; i<nums.length ; i++) {
//             if(i==idx || nums[i]!=nums[i-1]) {
//                 tempList.add(nums[i]);
//                 backtrack(nums, i+1, tempList, result);
//                 tempList.remove(tempList.size()-1);
//             }
//         }
//     }
}