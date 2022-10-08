class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // Build edges list
        List<int[]> edges = getEdges(wells, pipes);
        
        // Kruskal's Algorithm
        Collections.sort(edges, (e1,e2) -> e1[2]-e2[2]);
        
        DisjointSet ds = new DisjointSet(n+1);
        
        int totalCost = 0;
        int mstEdges = 0;
        for(int i=0 ; i<edges.size() && mstEdges<n ; i++) {
            int[] edge = edges.get(i);
            int src = edge[0];
            int nbr = edge[1];
            int cost = edge[2];
            
            if(!ds.connected(src, nbr)) {
                ds.union(src, nbr);
                totalCost += cost;
                mstEdges++;
            }
        }
        return totalCost;
    }
    
    private List<int[]> getEdges(int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();
        int sentinelNode = 0;
        
        for(int[] pipe : pipes)
            edges.add(pipe);
        for(int i=0 ; i<wells.length ; i++)
            edges.add(new int[] {sentinelNode, i+1, wells[i]});
        
        return edges;
    }
    
    class DisjointSet {
        int[] rank;
        int[] root;
        
        public DisjointSet(int n) {
            this.root = new int[n];
            this.rank = new int[n];
            
            for(int i=0 ; i<n ; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        private int find(int x) {
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
        
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}