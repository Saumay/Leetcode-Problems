class Solution {
    
    // 1) Using DFS (Cycle Detection in Directed Graph)
    public String alienOrder(String[] words) {
        // Create adjacency Map
        Map<Character, List<Character>> adjMap = new HashMap<>();
        Map<Character, Integer> indegreeMap = new HashMap<>();
        Map<Character, Integer> seen = new HashMap<>();
        StringBuilder sorted = new StringBuilder();
        
        for(String word : words) {
            for(int i=0 ; i<word.length() ; i++) {
                char ch = word.charAt(i);
                adjMap.put(ch, new LinkedList<>());
                indegreeMap.put(ch, 0);
                seen.put(ch, 0);
            }
        }
        
        for(int i=0 ; i<words.length-1 ; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            
            if(word1.length()>word2.length() && word1.startsWith(word2))
                return "";
            
            for(int j=0 ; j<Math.min(word1.length(), word2.length()) ; j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                
                if(ch1 != ch2) {
                    adjMap.get(ch1).add(ch2);
                    indegreeMap.put(ch2, indegreeMap.get(ch2)+1);
                    break;
                }
            }
        }
        
        // Detect cycle in graph and try creating order
        for(char key : adjMap.keySet()) {
            if(seen.get(key)==0) {
                if(containsCycle(adjMap, key, seen, sorted))
                    return "";
            }
        }
        return sorted.toString();
    }
    
    private boolean containsCycle(Map<Character, List<Character>> adjMap, char src, Map<Character, Integer> seen, StringBuilder sorted) {
        seen.put(src, 1);
        
        List<Character> nbrs = adjMap.get(src);
        for(char nbr : nbrs) {
            if(seen.get(nbr)==0) {
                if(containsCycle(adjMap, nbr, seen, sorted))
                    return true;
            } else if(seen.get(nbr)==1) {
                return true;
            }
        }
        
        sorted.insert(0, src);
        seen.put(src, 2);
        return false;
    }
    
    // 2) Using Kahn's algorithm: Topological Sort
//     public String alienOrder(String[] words) {
//         Map<Character, List<Character>> adjMap = new HashMap<>();
//         Map<Character, Integer> indegreeMap = new HashMap<>();
//         StringBuilder sorted = new StringBuilder();
        
//         // Create Adjacency Map
//         for(String word: words) {
//             for(int i=0 ; i<word.length() ; i++) {
//                 adjMap.put(word.charAt(i), new LinkedList<>());
//                 indegreeMap.put(word.charAt(i), 0);
//             }
//         }
        
//         for(int i=0 ; i<words.length-1 ; i++) {
//             String word1 = words[i];
//             String word2 = words[i+1];
            
//             if(word1.length() > word2.length() && word1.startsWith(word2))
//                 return "";
            
//             for(int j=0 ; j<Math.min(word1.length(), word2.length()) ; j++) {
//                 char ch1 = word1.charAt(j);
//                 char ch2 = word2.charAt(j);
                
//                 if(ch1 != ch2) {
//                     adjMap.get(ch1).add(ch2);
//                     indegreeMap.put(ch2, indegreeMap.getOrDefault(ch2, 0)+1);
//                     break;
//                 }
//             }
//         }
        
//         // Perform topological sort
//         Queue<Character> q = new ArrayDeque<>();
//         for(char ch : indegreeMap.keySet()) {
//             if(indegreeMap.get(ch)==0)
//                 q.add(ch);
//         }
        
//         while(!q.isEmpty()) {
//             char cur = q.remove();
//             sorted.append(cur);
            
//             for(char nbr : adjMap.get(cur)) {
//                 indegreeMap.put(nbr, indegreeMap.get(nbr)-1);
//                 if(indegreeMap.get(nbr)==0)
//                     q.add(nbr);
//             }
//         }
//         if(sorted.length() < adjMap.size())
//             return "";
        
//         return sorted.toString();
//     }
}