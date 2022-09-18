class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;
        
        DisjointSet ds = new DisjointSet(m);
        
        for(int city=0 ; city<m ; city++) {
            for(int nbr=0 ; nbr<n ; nbr++) {
                if(isConnected[city][nbr] == 1)
                    ds.union(city, nbr);
            }
        }
        return ds.groups;
    }
}

class DisjointSet {
    int[] root;
    int[] rank;
    int groups;
    
    DisjointSet(int n) {
        root = new int[n];
        rank = new int[n];
        groups = n;
        
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
            if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
            groups--;
        }
    }
}