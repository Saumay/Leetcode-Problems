class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        Map<Character, Integer> freqMap = new HashMap<>();
        
        int left=0;
        int maxLen = 0;
        for(int right=0 ; right<n ; right++) {
            char rightCh = s.charAt(right);
            freqMap.put(rightCh, freqMap.getOrDefault(rightCh, 0)+1);
            
            while(freqMap.size()>2) {                
                char leftCh = s.charAt(left);
                freqMap.put(leftCh, freqMap.get(leftCh)-1);
                if(freqMap.get(leftCh)==0)
                    freqMap.remove(leftCh);
                
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}