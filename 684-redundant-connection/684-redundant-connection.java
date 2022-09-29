class Solution {
        
    // 1) Approach 1: DFS
//     public int[] findRedundantConnection(int[][] edges) {
//         List<Integer>[] adjList = new ArrayList[edges.length+1];
        
//         for(int[] edge : edges) {
//             int src = edge[0];
//             int dest = edge[1];
            
//             Set<Integer> seen = new HashSet<>();
//             seen.add(src);
//             if(pathExists(adjList, src, dest, seen))
//                 return edge;
            
//             if(adjList[src]==null)
//                 adjList[src] = new ArrayList<>();
//             if(adjList[dest]==null)
//                 adjList[dest] = new ArrayList<>();
            
//             adjList[src].add(dest);
//             adjList[dest].add(src);
//         }
//         return new int[]{};
//     }
    
//     private boolean pathExists(List<Integer>[] adjList, int src, int dest, Set<Integer> seen) {
//         if(src==dest)
//             return true;
        
//         List<Integer> nbrs = adjList[src];
//         if(nbrs != null) {
//             for(Integer nbr : nbrs) {
//                 if(!seen.contains(nbr)) {
//                     seen.add(nbr);
//                     if(pathExists(adjList, nbr, dest, seen))
//                         return true;
//                 }
//             }
//         }
//         return false;
//     }
    
    
    // 2) Approach 2: Union Find
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length+1);
        
        for(int[] edge : edges) {
            if(ds.areConnected(edge[0], edge[1]))
                return edge;
            ds.union(edge[0], edge[1]);
        }
        return new int[]{};
    }
    
    class DisjointSet {
        int[] root;
        int[] rank;
        
        public DisjointSet(int n) {
            root = new int[n];
            rank = new int[n];
            
            for(int i=0 ; i<n ; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if(root[x]==x)
                return root[x];
            
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
        
        public boolean areConnected(int x, int y) {
            return find(x)==find(y);
        }
    }
}