class Solution {
    public int earliestAcq(int[][] logs, int n) {
        // If length < -1, it means all nodes are not connected.
        if(logs.length < n-1)
            return -1;
        
        Arrays.sort(logs, (log1, log2) -> log1[0] - log2[0]);
        
        DisjointSet ds = new DisjointSet(n);
        for(int[] log : logs) {
            ds.union(log[1], log[2]);
            
            if(ds.components == 1)
                return log[0];
        }
        return -1;
    }
    
    class DisjointSet {
        int[] root;
        int[] rank;
        int components;
        
        DisjointSet(int n) {
            root = new int[n];
            rank = new int[n];
            components = n;
            
            for(int i=0 ; i<n ; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if(root[x] == x)
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
                
                components--;
            }
        }
    }
}