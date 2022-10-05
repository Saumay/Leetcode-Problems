class Solution {
    
    // 1) BFS
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         if(beginWord.equals(endWord))
//             return 0;
        
//         Set<String> words = new HashSet<>(wordList);
//         if(!words.contains(endWord))
//             return 0;
        
//         Queue<String> q = new ArrayDeque<>();
//         q.add(beginWord);
        
//         int seq = 1;
//         while(!q.isEmpty()) {
//             int size = q.size();
            
//             seq++;
//             for(int i=0 ; i<size ; i++) {
//                 char[] word = q.remove().toCharArray();
                
//                 for(int j=0 ; j<word.length ; j++) {
//                     for(char k='a' ; k<='z' ; k++) {
//                         char actual = word[j];
//                         word[j] = k;
                        
//                         String newWord = new String(word);
//                         if(newWord.equals(endWord))
//                             return seq;
//                         if(words.contains(newWord)) {
//                             q.add(newWord);
//                             words.remove(newWord);
//                         }
                        
//                         word[j] = actual;
//                     }
//                 }
//             }
//         }
//         return 0;
//     }
    
    
    // 2) Bidirectional BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))
            return 0;
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord))
            return 0;
        
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        
        int seq = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            seq++;
            if(beginSet.size() > endSet.size()) {
                swap(beginSet, endSet);
            }
            
            Set<String> newSet = new HashSet<>();
            for(String word : beginSet) {
                char[] wordArr = word.toCharArray();
                
                for(int i=0 ; i<wordArr.length ; i++) {
                    char orig = wordArr[i];
                    for(char j='a' ; j<='z' ; j++) {
                        wordArr[i] = j;
                        
                        String newWord = new String(wordArr);
                        if(endSet.contains(newWord))
                            return seq;
                        if(words.contains(newWord)) {
                            newSet.add(newWord);
                            words.remove(newWord);
                        }
                        
                        wordArr[i] = orig;
                    }
                }
            }
            beginSet = newSet;
        }
        return 0;
    }
    
    private void swap(Set<String> begin, Set<String> end) {
        Set<String> temp = begin;
        begin = end;
        end = temp;
    }
}