class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))
            return 0;
        
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord))
            return 0;
        
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        
        int seq = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            
            seq++;
            for(int i=0 ; i<size ; i++) {
                char[] word = q.remove().toCharArray();
                
                for(int j=0 ; j<word.length ; j++) {
                    for(int k=0 ; k<26 ; k++) {
                        char actual = word[j];
                        word[j] = (char)('a'+k);
                        
                        String newWord = new String(word);
                        if(newWord.equals(endWord))
                            return seq;
                        if(words.contains(newWord)) {
                            q.add(newWord);
                            words.remove(newWord);
                        }
                        
                        word[j] = actual;
                    }
                }
            }
        }
        return 0;
    }
}