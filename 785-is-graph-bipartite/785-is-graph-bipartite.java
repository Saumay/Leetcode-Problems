class Solution {
    
    // 1) Using DFS
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
//         int[] seen = new int[n];
        
//         for(int i=0 ; i<n ; i++) {
//             if(seen[i] == 0) {
//                 seen[i] = 1;
//                 if(!isBipartiteDfs(graph, i, 1, seen))
//                     return false;
//             }
//         }
//         return true;
//     }
    
//     private boolean isBipartiteDfs(int[][] graph, int cur, int curColor, int[] seen) {
//         int[] nbrs = graph[cur];
//         for(int nbr : nbrs) {
//             // if(nbr != prev) {                // No need to check trivial cycles since for caller node seen[nbr]==curColor will always be false
//                 if(seen[nbr] == 0) {
//                     int nextColor = curColor==1 ? -1 : 1;
//                     seen[nbr] = nextColor;
                    
//                     if(!isBipartiteDfs(graph, nbr, nextColor, seen))
//                         return false;
//                 } else if(seen[nbr] == curColor)
//                     return false;
//             // }
//         }
//         return true;
//     }
    
    
    // 2) Using BFS
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int[] color = new int[n];
        
        for(int i=0 ; i<n ; i++) {
            if(color[i] == 0) {
                if(!isBipartiteBfs(graph, i, color))
                    return false;
            }
        }
        return true;
    }
    
    private boolean isBipartiteBfs(int[][] graph, int i, int[] color) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        color[i] = 1;
        
        while(!q.isEmpty()) {
            int cur = q.remove();
            int curColor = color[cur];
            
            for(int nbr : graph[cur]) {
                if(color[nbr] == 0) {
                    int nextColor = curColor==1 ? -1 : 1;
                    color[nbr] = nextColor;
                    q.add(nbr);
                } else if(color[nbr]==curColor)
                    return false;
            }
        }
        return true;
    }
}