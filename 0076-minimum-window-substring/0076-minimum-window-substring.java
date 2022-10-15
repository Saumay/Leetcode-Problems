class Solution {
    
    // 1) Determing whether to expand or contract window in O(s+t) time complexity
//     public String minWindow(String s, String t) {
        
//         int left=0;
//         int right=0;
//         int[] idx = new int[] {0,0};
//         int minLen = s.length() + 1;
        
//         while(left<=right && right<s.length()) {
//             if(!hasChars(s.substring(left, right+1), t)) {
//                 right++;
//             } else {
//                 while(hasChars(s.substring(left, right+1), t)) {
//                     if(right-left+1 < minLen) {
//                         idx[0] = left;
//                         idx[1] = right;
//                         minLen = right-left+1;
//                     }
//                     left++;
//                 }
//             }
//         }
//         return minLen>s.length() ? "" : s.substring(idx[0], idx[1]+1);
//     }
    
//     private boolean hasChars(String s, String t) {
//         Map<Character, Integer> map = new HashMap<>();
        
//         for(int i=0 ; i<s.length() ; i++) {
//             char ch = s.charAt(i);
//             map.put(ch, map.getOrDefault(ch, 0)+1);
//         }
        
//         for(int i=0 ; i<t.length() ; i++) {
//             char ch = t.charAt(i);
//             if(!map.containsKey(ch))
//                 return false;
            
//             map.put(ch, map.get(ch)-1);
//             if(map.get(ch)<=0)
//                 map.remove(ch);
//         }
//         return true;
//     }
    
    
    // 2) Determing whether to expand or contract window in O(1) time complexity
    public String minWindow(String s, String t) {
        if(t.length() > s.length())
            return "";
        
        Map<Character, Integer> tMap = new HashMap<>();
        int tCount = 0;
        for(int i=0 ; i<t.length() ; i++) {
            tCount++;
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        
        int left = 0;
        int right = 0;
        int[] min = new int[] {Integer.MAX_VALUE, left, right};
        int matchCount = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        
        while(left<=right && right<s.length()) {
            
            // Expand window
            char rightCh = s.charAt(right);

            sMap.put(rightCh, sMap.getOrDefault(rightCh, 0)+1);
            if(tMap.containsKey(rightCh) && sMap.get(rightCh)<=tMap.get(rightCh))
                matchCount++;

            right++;
                            
            while(matchCount == tCount) {
                int length = right-left+1;
                if(length < min[0])
                    min = new int[] {length, left, right};
                char leftCh = s.charAt(left);

                sMap.put(leftCh, sMap.get(leftCh)-1);
                if(tMap.containsKey(leftCh) && sMap.get(leftCh)<tMap.get(leftCh))
                    matchCount--;
                // if(sMap.get(ch) <= 0)
                //     sMap.put(ch, 0);

                left++;
            }
        }
        return min[0]==Integer.MAX_VALUE ? "" : s.substring(min[1], min[2]);
    }
    
    
    // 3) Using filteredS by keeping only chars that are present in T
//     public String minWindow(String s, String t) {
//         if(t.length() > s.length())
//             return "";
        
//         int tCount = 0;
//         Map<Character, Integer> tMap = new HashMap<>();
//         for(int i=0 ; i<t.length() ; i++) {
//             tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
//             tCount++;
//         }
        
//         List<Pair<Integer, Character>> filteredS = new LinkedList<>();
//         for(int i=0 ; i<s.length() ; i++) {
//             char ch = s.charAt(i);
//             if(tMap.containsKey(ch))
//                 filteredS.add(new Pair<>(i, ch));
//         }
//         if(filteredS.isEmpty())
//             return "";
        
//         int left = 0;
//         int right = 0;
//         int[] min = new int[] {Integer.MAX_VALUE, left, right};
//         int matchCount = 0;
//         Map<Character, Integer> sMap = new HashMap<>();
        
//         System.out.println(filteredS);

//         while(left<=right && right<filteredS.size()) {
//             if(matchCount < tCount) {
//                 char ch = filteredS.get(right).getValue();
                
//                 sMap.put(ch, sMap.getOrDefault(ch, 0)+1);
//                 if(sMap.get(ch) <= tMap.get(ch))
//                     matchCount++;
                
//                 right++;
//             }
            
//             System.out.println(left + " " + right + " " + matchCount);
            
//             while(matchCount == tCount) {
//                 int leftIdx = filteredS.get(left).getKey();
//                 int rightIdx = right==filteredS.size() 
//                     ? filteredS.get(filteredS.size()-1).getKey()
//                     : filteredS.get(right).getKey();
//                 int length = rightIdx - leftIdx + 1;
//                 if(length < min[0])
//                     min = new int[] {length, leftIdx, rightIdx};
                
//                 char ch = filteredS.get(left).getValue();
//                 sMap.put(ch, sMap.get(ch)-1);
//                 if(sMap.get(ch) < tMap.get(ch))
//                     matchCount--;
                
//                 left++;
//             }
//         }
//         return min[0]==Integer.MAX_VALUE ? "" : s.substring(min[1], min[2]+1);
//     }
}