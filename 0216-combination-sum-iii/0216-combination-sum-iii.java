class Solution {
    
    // 1) Recursive 1: Pick or not pick current element. Two method calls inside backtracking method
//     public List<List<Integer>> combinationSum3(int k, int n) {
//         List<List<Integer>> result = new LinkedList<>();
        
//         backtrack(k, 1, n, new LinkedList<>(), result);
//         return result;
//     }
    
//     private void backtrack(int k, int idx, int remaining, List<Integer> tempList, List<List<Integer>> result) {
//         if(k==0) {
//             if(remaining==0)
//                 result.add(new LinkedList<>(tempList));
//             return;
//         }
//         if(idx>9 || remaining<0)
//             return;
        
//         // Case 1: When we pick the current element, and increment idx
//         tempList.add(idx);
//         backtrack(k-1, idx+1, remaining-idx, tempList, result);
//         tempList.remove(tempList.size()-1);
        
//         // Case 2: When we don't pick the current element and move ahead
//         backtrack(k, idx+1, remaining, tempList, result);
//     }
    
    
    // 2) Recursive 1: Pick or not pick current element. Two method calls inside backtracking method
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        
        backtrack(k, 1, n, new LinkedList<>(), result);
        return result;
    }
    
    private void backtrack(int k, int idx, int remaining, List<Integer> tempList, List<List<Integer>> result) {
        if(k==0) {
            if(remaining==0) 
                result.add(new LinkedList<>(tempList));
            return;
        }
        
        for(int i=idx ; i<10 && remaining>=i ; i++) {
            tempList.add(i);
            backtrack(k-1, i+1, remaining-i, tempList, result);
            tempList.remove(tempList.size()-1);
        }
    }
}