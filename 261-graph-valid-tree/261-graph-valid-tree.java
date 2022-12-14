class Solution {
    
    // 1) Recursive DFS
    /*
        Conditions:
            - graph should be fully connected. A single component.
            - graph should not contain any cycle
    */
//     public boolean validTree(int n, int[][] edges) {
//         List<Integer>[] adjList = getAdjList(n, edges);
//         Set<Integer> visited = new HashSet<>();
        
//         int src = 0;
//         visited.add(src);
//         return !containsCycleDfs(src, -1, adjList, visited) && visited.size()==n;
//     }
    
//     private boolean containsCycleDfs(Integer src, Integer prev, List<Integer>[] adjList, Set<Integer> visited) {
//         List<Integer> nbrs = adjList[src];
//         for(int nbr : nbrs) {
    
//             // This condition is for avoiding trivial cycles
//             if(nbr!=prev) {
//                 if(visited.contains(nbr))
//                     return true;

//                 visited.add(nbr);
//                 if(containsCycleDfs(nbr, src, adjList, visited))
//                     return true;
//             }
//         }
//         return false;
//     }    
    
    
    
    // 2) BFS
    /*
        Conditions:
            - graph should be fully connected. A single component.
            - graph should not contain any cycle
    */
//     public boolean validTree(int n, int[][] edges) {
//         List<Integer>[] adjList = getAdjList(n, edges);
        
//         Queue<Integer> q = new ArrayDeque<>();
//         Map<Integer, Integer> seen = new HashMap<>();
//         seen.put(0, -1);
//         q.add(0);
        
//         while(!q.isEmpty()) {
//             // R - Remove
//             Integer src = q.remove();
            
//             // Add
//             List<Integer> nbrs = adjList[src];
//             for(int nbr : nbrs) {
                
//                 // This condition is for avoiding trivial cycles
//                 if(nbr != seen.get(src)) {
    
//                     // This condition is for checking if it contains cycle
//                     if(seen.containsKey(nbr))
//                         return false;

//                     seen.put(nbr, src);
//                     q.add(nbr);
//                 }
//             }
//         }
//         return seen.size()==n;
//     }
    
    
    
    // 3) Advanced Graph Theory + Recursive DFS
    /*
        Conditions:
            - graph should be fully connected. A single component.
            - graph should have exactly n-1 edges
    */
//     public boolean validTree(int n, int[][] edges) {
//         if(edges.length != n-1)
//             return false;
        
//         List<Integer>[] adjList = getAdjList(n, edges);
//         Set<Integer> seen = new HashSet<>();
        
//         int src = 0;
//         seen.add(src);
//         dfs(src, adjList, seen);
        
//         return seen.size() == n;
//     }
    
//     private void dfs(int src, List<Integer>[] adjList, Set<Integer> seen) {
//         List<Integer> nbrs = adjList[src];
//         for(int nbr : nbrs) {
//             if(!seen.contains(nbr)) {
//                 seen.add(nbr);
//                 dfs(nbr, adjList, seen);
//             }
//         }
//     }
    
    
    
    // 4) Advanced Graph Theory + BFS
    /*
        Conditions:
            - graph should be fully connected. A single component.
            - graph should have exactly n-1 edges
    */
//     public boolean validTree(int n, int[][] edges) {
//         if(edges.length != n-1)
//             return false;
        
//         List<Integer>[] adjList = getAdjList(n, edges);
        
//         Set<Integer> seen = new HashSet<>();
//         Queue<Integer> q = new ArrayDeque<>();
//         seen.add(0);
//         q.add(0);
        
//         while(!q.isEmpty()) {
//             int src = q.remove();
            
//             for(int nbr : adjList[src]) {
//                 if(!seen.contains(nbr)) {
//                     seen.add(nbr);
//                     q.add(nbr);
//                 }
//             }
//         }
//         return seen.size()==n;
//     }
    
//     private List<Integer>[] getAdjList(int n, int[][] edges) {
//         List<Integer>[] adjList = new ArrayList[n];
//         for(int i=0 ; i<n ; i++)
//             adjList[i] = new ArrayList<>();
        
//         for(int[] edge : edges) {            
//             adjList[edge[0]].add(edge[1]);
//             adjList[edge[1]].add(edge[0]);
//         }
//         return adjList;
//     }
    
    
    // 5) Advanced Graph Theory + Union Find
    /*
        Conditions:
            - graph should be fully connected. A single component.
            - graph should have exactly n-1 edges
    */
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1)
            return false;
        
        DisjointSet ds = new DisjointSet(n);
        for(int[] edge : edges) {
            ds.union(edge[0], edge[1]);
        }
        
        return ds.components==1;
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
                
                components--;
            }
        }
    }
}