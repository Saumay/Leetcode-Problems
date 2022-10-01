class Solution {
    
    // 1) Brute Force
    public boolean equalFrequency(String word) {
        for(int i=0 ; i<word.length() ; i++) {
            if(deleteAndCheck(i, word))
                return true;
        }
        return false;
    }
            
    private boolean deleteAndCheck(int idx, String word) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0 ; i<word.length() ; i++) {
            if(i != idx) {
                char ch = word.charAt(i);
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
        }
        
        Set<Integer> set = new HashSet<>(map.values());
        return set.size()==1;
    }
    
    
//     public boolean equalFrequency(String word) {
//         int[] count = new int[26];
        
//         for(int i=0 ; i<word.length() ; i++) {
//             char ch = word.charAt(i);
//             count[ch-'a']++;
//         }
        
//         Map<Integer, Integer> freqMap = new HashMap<>();
//         for(int i=0 ; i<26 ; i++) {
//             if(count[i] > 0)
//                 freqMap.put(count[i], freqMap.getOrDefault(count[i],0)+1);
//         }
        
//         // System.out.println(freqMap.size());

//         if(freqMap.size()==1) {
//             int first=0;
//             for(int key : freqMap.keySet()) {
//                 first = key;
//             }
//             return first==1 || freqMap.get(first)==1;
//         }
//         else if(freqMap.size()==2) {
//             int i=0;
//             int first = 0;
//             int second = 0;
//             for(int key : freqMap.keySet()) {
//                 if(i==0)
//                     first = key;
//                 else {
//                     if(key >= first)
//                         second = key;
//                     else {
//                         second = first;
//                         first = key;
//                     }
//                 }
//                 i++;
//             }
//             if(second-first==1) {
//                 return freqMap.get(second)==1 || (first==1 && freqMap.get(first)==1);  
//             }
//             return false;
//         }
//         return false;
//     }
}