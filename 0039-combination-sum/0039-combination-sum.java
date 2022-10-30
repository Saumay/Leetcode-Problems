class Solution {
    
    // 1) Recursive 1: Pick or not pick current element. Two method calls inside backtracking method
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> result = new LinkedList<>();
        
//         backtrack(candidates, target, 0, new LinkedList<>(), result);
//         return result;
//     }
    
//     /*
//     candidates = [2,3,6,7], target = 7
    
//     Tree
    
//                                               []
//                                 /                           \
//                             [2]                               []
//                       /                 \                  /        \
//                   [2,2]                  [2]              [3]        []
//               /         \               /     \          /    \      /  \
//         [2,2,2]         [2,2]       [2,3]       [2]    [3,3]  [3]  [6]   []
//        /      \         /   \      /    \       /   \
// [2,2,2,2] [2,2,2] [2,2,3] [2,2] [2,3,3] [2,3]  [2,4] [2] 
  
//     */
//     private void backtrack(int[] candidates, int target, int idx, List<Integer> tempList, List<List<Integer>> result) {
//         if(target == 0) {
//             result.add(new ArrayList<>(tempList));
//             return;
//         }
//         if(idx>=candidates.length || target<0)
//             return;

//         // Case 1: When we pick the current element, and keep idx the same
//         tempList.add(candidates[idx]);
//         backtrack(candidates, target-candidates[idx], idx, tempList, result);
//         tempList.remove(tempList.size()-1);

//         // Case 2: When we don't pick the current element and move ahead
//         backtrack(candidates, target, idx+1, tempList, result);
//     }
    
    
    // 2) Recursive 2: Pick each element from [idx,n) subarray, and recurse on it.
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> results = new ArrayList<List<Integer>>();
        
//         backtrack(candidates, target, 0, new LinkedList<Integer>(), results);
//         return results;
//     }
    
//     private void backtrack(int[] candidates, int remaining, int idx, List<Integer> tempList, List<List<Integer>> result) {
//         if(remaining == 0) {
//             result.add(new LinkedList<>(tempList));
//             return;
//         }
//         if(remaining < 0)
//             return;
        
//         for(int i=idx ; i<candidates.length ; i++) {
//             tempList.add(candidates[i]);
//             backtrack(candidates, remaining-candidates[i], i, tempList, result);
//             tempList.remove(tempList.size()-1);
//         }
//     }
    

    // 2.2) Recursive 2.2: Pick each element from [idx,n) subarray, and recurse on it.
    // Optimization: Sort the array. If sorted, we can break the loop sooner as soon as our element becomes larger than remaining sum.
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        
        backtrack(candidates, target, 0, new LinkedList<Integer>(), results);
        return results;
    }
    
    private void backtrack(int[] candidates, int remaining, int idx, List<Integer> tempList, List<List<Integer>> result) {
        if(remaining == 0) {
            result.add(new LinkedList<>(tempList));
            return;
        }
        
        for(int i=idx ; i<candidates.length && candidates[i]<=remaining ; i++) {
            tempList.add(candidates[i]);
            
            // sending idx as i since we can pick same element again
            backtrack(candidates, remaining-candidates[i], i, tempList, result);    
            
            tempList.remove(tempList.size()-1);
        }
    }
}