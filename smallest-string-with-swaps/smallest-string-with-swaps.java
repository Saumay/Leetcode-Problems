class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DisjointSet ds = new DisjointSet(s.length());
        
        for(List<Integer> pair : pairs) {
            ds.union(pair.get(0), pair.get(1));
        }
        
        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        Map<Integer, List<Integer>> charMap = new HashMap<>();
        
        for(int i=0 ; i<s.length() ; i++) {
            int root = ds.find(i);
            
            idxMap.putIfAbsent(root, new ArrayList<>());
            idxMap.get(root).add(i);
            
            charMap.putIfAbsent(root, new ArrayList<>());
            charMap.get(root).add(s.charAt(i)-'a');
        }
        
        char[] result = new char[s.length()];
        for(int key : idxMap.keySet()) {
            List<Integer> idxs = idxMap.get(key);
            List<Integer> chars = charMap.get(key);
            
            Collections.sort(chars);
            for(int i=0 ; i<idxs.size() ; i++) {
                result[idxs.get(i)] = (char)('a'+chars.get(i));
            }
        }
        return new String(result);
    }
    
    private List<String> printVal(Set<int[]> set) {
        return set.stream()
            .map(i1 -> i1[0] + " " + i1[1])
            .collect(Collectors.toList());
    }
    
    class DisjointSet {
        int[] root;
        int[] rank;
        
        DisjointSet(int n) {
            this.root = new int[n];
            this.rank = new int[n];
            
            for(int i=0 ; i<n ; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if(x==root[x])
                return x;
            
            root[x] = find(root[x]);
            return root[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if(rootX != rootY) {
                if(rank[rootX] < rank[rootY])
                    root[rootX] = rootY;
                else if(rank[rootX] > rank[rootY])
                    root[rootY] = rootX;
                else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}