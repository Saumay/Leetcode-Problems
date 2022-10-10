class Solution {
    
    // 1) Backtracking
//     public List<String> generateParenthesis(int n) {
//         List<String> result = new LinkedList<>();
        
//         backtrack(0, n, n, new StringBuilder(), result);
//         return result;
//     }
    
//     private void backtrack(int idx, int open, int close, StringBuilder sb, List<String> result) {
//         if(open==0 && close==0) {
//             result.add(sb.toString());
//             return;
//         }
        
//         if(open>=0) {
//             sb.append('(');
//             backtrack(idx+1, open-1, close, sb, result);
//             sb.deleteCharAt(sb.length()-1);
//         }
//         if(close>open) {
//             sb.append(')');
//             backtrack(idx+1, open, close-1, sb, result);
//             sb.deleteCharAt(sb.length()-1);
//         }
//     }
    
    
    // 2) Recursion
//     public List<String> generateParenthesis(int n) {
//         List<String> cur = new LinkedList<>();
//         if(n==0) {
//             cur.add("");
//             return cur;
//         }
        
//         for(int i=0 ; i<n ; i++) {
//             List<String> leftPart = generateParenthesis(i);
//             List<String> rightPart = generateParenthesis(n-i-1);
            
//             for(String left : leftPart) {
//                 for(String right : rightPart) {
//                     cur.add('(' + left + ')' + right);
//                 }
//             }
//         }
//         return cur;
//     }
    
    
    
    // 3) Recursion + Memoization
    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, new HashMap<>());
    }
    
    public List<String> generateParenthesis(int n, Map<Integer, List<String>> cache) {
        if(cache.containsKey(n)) {
            return cache.get(n);
        }

        List<String> cur = new LinkedList<>();
        if(n==0) {
            cur.add("");
            return cur;
        }
        
        for(int i=0 ; i<n ; i++) {
            List<String> leftPart = generateParenthesis(i, cache);
            List<String> rightPart = generateParenthesis(n-i-1, cache);
            
            for(String left : leftPart) {
                for(String right : rightPart) {
                    cur.add('(' + left + ')' + right);
                }
            }
        }
        cache.put(n, cur);
        return cur;
    }
}