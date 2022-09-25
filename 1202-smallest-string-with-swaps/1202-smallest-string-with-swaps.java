class Solution {
    
    // 1) Union Find
//     public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
//         DisjointSet ds = new DisjointSet(s.length());
        
//         for(List<Integer> pair : pairs) {
//             ds.union(pair.get(0), pair.get(1));
//         }
        
//         Map<Integer, List<Integer>> idxMap = new HashMap<>();
//         Map<Integer, List<Character>> charMap = new HashMap<>();
        
//         for(int i=0 ; i<s.length() ; i++) {
//             int root = ds.find(i);
            
//             idxMap.putIfAbsent(root, new ArrayList<>());
//             idxMap.get(root).add(i);
            
//             charMap.putIfAbsent(root, new ArrayList<>());
//             charMap.get(root).add(s.charAt(i));
//         }
        
//         char[] result = new char[s.length()];
//         for(int key : idxMap.keySet()) {
//             List<Integer> idxs = idxMap.get(key);
//             List<Character> chars = charMap.get(key);
            
//             Collections.sort(chars);
//             for(int i=0 ; i<idxs.size() ; i++) {
//                 result[idxs.get(i)] = chars.get(i);
//             }
//         }
//         return new String(result);
//     }
    
//     private List<String> printVal(Set<int[]> set) {
//         return set.stream()
//             .map(i1 -> i1[0] + " " + i1[1])
//             .collect(Collectors.toList());
//     }
    
//     class DisjointSet {
//         int[] root;
//         int[] rank;
        
//         DisjointSet(int n) {
//             this.root = new int[n];
//             this.rank = new int[n];
            
//             for(int i=0 ; i<n ; i++) {
//                 root[i] = i;
//                 rank[i] = 1;
//             }
//         }
        
//         public int find(int x) {
//             if(x==root[x])
//                 return x;
            
//             root[x] = find(root[x]);
//             return root[x];
//         }
        
//         public void union(int x, int y) {
//             int rootX = find(x);
//             int rootY = find(y);
            
//             if(rootX != rootY) {
//                 if(rank[rootX] < rank[rootY])
//                     root[rootX] = rootY;
//                 else if(rank[rootX] > rank[rootY])
//                     root[rootY] = rootX;
//                 else {
//                     root[rootY] = rootX;
//                     rank[rootX]++;
//                 }
//             }
//         }
//     }
    
    
    // 2) DFS
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        List<Integer>[] adjList = getAdjList(s.length(), pairs);
        Set<Integer> seen = new HashSet<>();
        
        char[] result = new char[s.length()];
        for(int i=0 ; i<s.length() ; i++) {
            if(!seen.contains(i)) {
                List<Integer> idxList = new ArrayList<>();
                List<Character> charList = new ArrayList<>();
                
                seen.add(i);
                idxList.add(i);
                charList.add(s.charAt(i));
                dfs(s, i, adjList, seen, idxList, charList);
                
                Collections.sort(idxList);
                Collections.sort(charList);
                for(int idx=0 ; idx<idxList.size() ; idx++) {
                    result[idxList.get(idx)] = charList.get(idx);
                }
            }
        }
        return new String(result);
    }
    
    private void dfs(String s, int src, List<Integer>[] adjList, Set<Integer> seen, List<Integer> idxList, List<Character> charList) {
        List<Integer> nbrs = adjList[src];
        
        for(int nbr : nbrs) {
            if(!seen.contains(nbr)) {
                seen.add(nbr);
                idxList.add(nbr);
                charList.add(s.charAt(nbr));
                
                dfs(s, nbr, adjList, seen, idxList, charList);
            }
        }
    }
    
    private List<Integer>[] getAdjList(int n, List<List<Integer>> pairs) {
        List<Integer>[] adjList = new List[n];
        
        for(int i=0 ; i<n ; i++)
            adjList[i] = new ArrayList<>();
        
        for(List<Integer> pair : pairs) {
            int src = pair.get(0);
            int dest = pair.get(1);
            
            adjList[src].add(dest);
            adjList[dest].add(src);
        }
        return adjList;
    }
}