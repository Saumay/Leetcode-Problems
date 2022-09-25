class Solution {
    
    // 1) DFS - Recursive
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         List<Integer>[] adjList = getAdjList(n, edges);
//         boolean[] seen = new boolean[n];
        
//         seen[source] = true;
//         return dfs(adjList, source, destination, seen);
//     }
    
//     private boolean dfs(List<Integer>[] adjList, int src, int dest, boolean[] seen) {
//         if(src==dest)
//             return true;
        
//         List<Integer> nbrs = adjList[src];
        
//         for(int nbr : nbrs) {
//             if(!seen[nbr]) {
//                 seen[nbr] = true;
//                 if(dfs(adjList, nbr, dest, seen))
//                     return true;
//             }
//         }
//         return false;
//     }
    
    
    // 2) DFS - Iterative
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjList = getAdjList(n, edges);
        boolean[] seen = new boolean[n];
        
        seen[source] = true;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(source);
        
        while(!st.isEmpty()) {
            // Remove
            int top = st.pop();
            
            if(top==destination)
                return true;
            
            // Add
            for(int nbr : adjList[top]) {
                if(!seen[nbr]) {
                    seen[nbr] = true;
                    st.push(nbr);
                }
            }
        }
        return false;
    }
    
    private List<Integer>[] getAdjList(int n, int[][] edges) {
        List<Integer>[] adjList = new List[n];
        
        for(int i=0 ; i<n ; i++)
            adjList[i] = new ArrayList<>();
        
        for(int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            
            adjList[src].add(dest);
            adjList[dest].add(src);
        }
        return adjList;
    }
}