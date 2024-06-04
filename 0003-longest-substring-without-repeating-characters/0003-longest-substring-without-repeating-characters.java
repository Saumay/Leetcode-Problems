class Solution {
    
    // Solution 1: Sliding window
//     public int lengthOfLongestSubstring(String s) {
//         Set<Character> seen = new HashSet<>();
//         int left = 0;
//         int ans = 0;
        
//         for(int right=0 ; right<s.length() ; right++) {
//             while(seen.contains(s.charAt(right))) {
//                 seen.remove(s.charAt(left));
//                 left++;
//             }
//             seen.add(s.charAt(right));
//             ans = Math.max(ans, right-left+1);
//         }
//         return ans;
//     }
    
    // Solution 2: Using map to store last occurence of a character
        public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int left = 0;
        int ans = 0;
        
        for(int right=0 ; right<s.length() ; right++) {
            char rightCh = s.charAt(right);
            if(seen.containsKey(rightCh) && left<=seen.get(rightCh))
                left = seen.get(rightCh)+1;
            
            seen.put(rightCh, right);
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}