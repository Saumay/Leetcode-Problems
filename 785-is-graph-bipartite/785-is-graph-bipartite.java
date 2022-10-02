class Solution {
    
    // 1) Using DFS
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        
        for(int i=0 ; i<n ; i++) {
            if(color[i]==0) {
                color[i] = 1;
                if(!isBipartiteDfs(graph, i, color))
                    return false;
            }
        }
        return true;
    }
    
    private boolean isBipartiteDfs(int[][] graph, int src, int[] color) {
        int[] nbrs = graph[src];
        int curColor = color[src];
        
        for(int nbr : nbrs) {
            
            // No need to check trivial cycles since for caller node color[nbr]==curColor will always be false
            if(color[nbr]==0) {
                int nextColor = curColor==1 ? -1 : 1;
                color[nbr] = nextColor;
                if(!isBipartiteDfs(graph, nbr, color))
                    return false;
            } else {
                if(curColor == color[nbr])
                    return false;
            }
        }
        return true;
    }
    
    
    // 2) Using BFS
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
        
//         int[] color = new int[n];
        
//         for(int i=0 ; i<n ; i++) {
//             if(color[i] == 0) {
//                 if(!isBipartiteBfs(graph, i, color))
//                     return false;
//             }
//         }
//         return true;
//     }
    
//     private boolean isBipartiteBfs(int[][] graph, int i, int[] color) {
//         Queue<Integer> q = new ArrayDeque<>();
//         q.add(i);
//         color[i] = 1;
        
//         while(!q.isEmpty()) {
//             int cur = q.remove();
//             int curColor = color[cur];
            
//             for(int nbr : graph[cur]) {
//                 if(color[nbr] == 0) {
//                     int nextColor = curColor==1 ? -1 : 1;
//                     color[nbr] = nextColor;
//                     q.add(nbr);
//                 } else if(color[nbr]==curColor)
//                     return false;
//             }
//         }
//         return true;
//     }
}