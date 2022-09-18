class Solution {
    
    // 1) Using Union Find/Disjoint Set
//     class DisjointSet {
//         private int[] root;
//         private int[] rank;
//         public int components;

//         DisjointSet(int n) {
//             root = new int[n];
//             rank = new int[n];
//             components = n;

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

//         public void union(int n1, int n2) {
//             int root1 = find(n1);
//             int root2 = find(n2);

//             if(root1 != root2) {
//                 if(rank[root1] < rank[root2]) {
//                     root[root1] = root2;
//                 } else if(rank[root1] > rank[root2]) {
//                     root[root2] = root1;
//                 } else {
//                     root[root2] = root1;
//                     rank[root1]++;
//                 }
//                 components--;
//             }
//         }
//     }
    
//     public int findCircleNum(int[][] isConnected) {
//         int n = isConnected.length;
//         DisjointSet ds = new DisjointSet(n);
        
//         for(int i=0 ; i<n ; i++) {
//             for(int j=0 ; j<i ; j++) {
//                 if(isConnected[i][j]==1)
//                     ds.union(i, j);
//             }
//         }
//         return ds.components;
//     }
    
    
    // 2) Using DFS
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<Integer>[] adjList = getAdjacencyList(isConnected);
        
        int provinces = 0;
        boolean[] visited = new boolean[n];
        for(int i=0 ; i<n ; i++) {
            if(!visited[i]) {
                provinces++;
                visited[i] = true;
                dfs(i, adjList, visited);
            }
        }
        return provinces;
    }
    
    public void dfs(int src, List<Integer>[] adjList, boolean[] visited) {
        List<Integer> nbrs = adjList[src];
        
        for(int nbr : nbrs) {
            if(!visited[nbr]) {
                visited[nbr] = true;
                dfs(nbr, adjList, visited);
            }
        }
    } 
    
    private List<Integer>[] getAdjacencyList(int[][] isConnected) {
        int n = isConnected.length;
        List<Integer>[] adjacencyList = new ArrayList[n];
        
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(isConnected[i][j] == 1) {
                    if(adjacencyList[i] == null)
                        adjacencyList[i] = new ArrayList<>();

                    adjacencyList[i].add(j);
                }
            }
        }
        return adjacencyList;
    }
}