class Solution {
    
    // 1) DFS
//     public int countComponents(int n, int[][] edges) {
//         List<Integer>[] adjList = getAdjList(n, edges);
//         boolean[] visited = new boolean[n];
        
//         int components = 0;
//         for(int i=0 ; i<n ; i++) {
//             if(!visited[i]) {
//                 components++;
//                 dfs(i, adjList, visited);
//             }
//         }
//         return components;
//     }
    
//     private void dfs(int src, List<Integer>[] adjList, boolean[] visited) {
//         List<Integer> nbrs = adjList[src];
        
//         for(int nbr : nbrs) {
//             if(!visited[nbr]) {
//                 visited[nbr] = true;
//                 dfs(nbr, adjList, visited);
//             }
//         }
//     }
    
//     private List<Integer>[] getAdjList(int n, int[][] edges) {
//         List<Integer>[] adjList = new ArrayList[n];
        
//         for(int i=0 ; i<n ; i++) {
//             adjList[i] = new ArrayList<>();
//         }
        
//         for(int[] edge : edges) {
//             int src = edge[0];
//             int dest = edge[1];
            
//             adjList[src].add(dest);
//             adjList[dest].add(src);
//         }
//         return adjList;
//     }
    
    
    // 2) Union Find
    public int countComponents(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        int components = n;
        
        for(int[] edge : edges) {
            if(ds.union(edge[0], edge[1]))
                components--;
        }
        return components;
    }
    
    class DisjointSet {
        private int[] root;
        private int[] rank;
        
        DisjointSet(int n) {  
            root = new int[n];
            rank = new int[n];
            
            for(int i=0 ; i<n ; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        private int find(int x) {
            if(root[x] == x)
                return x;
            
            root[x] = find(root[x]);
            return root[x];
        }
        
        public boolean union(int x, int y) {
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
                return true;
            }
            return false;
        }
    }
}