class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        int left=0;
        int maxLen=0;
        for(int right=0 ; right<s.length() ; right++) {
            char rightCh = s.charAt(right);
            
            if(map.containsKey(rightCh)) {
                left = Math.max(map.get(rightCh)+1, left);
            }
            map.put(rightCh, right);
            
            maxLen = Math.max(maxLen, right-left+1);
            
            // System.out.println(map);
            // System.out.println(left + " " + right);
        }
        return maxLen;
    }
}