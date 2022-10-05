class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord) || beginWord.length()!=endWord.length())
            return 0;
        
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord))
            return 0;
        
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            
            level++;
            for(int ct=0 ; ct<size ; ct++) {
                char[] curWord = q.remove().toCharArray();
                
                for(int i=0 ; i<curWord.length ; i++) {
                    for(int c=0 ; c<26 ; c++) {
                        char actual = curWord[i];
                        
                        if('a'+c != actual) {
                            curWord[i] = (char)('a'+c);
                            
                            String newWord = new String(curWord);
                            if(newWord.equals(endWord)) {
                                System.out.println(newWord);
                                return level;
                            }
                            if(words.contains(newWord)) {
                                q.add(newWord);
                                words.remove(newWord);
                            }

                            curWord[i] = actual;
                        }
                    }
                }
            }
        }
        return 0;
    }
}