class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] seen = new int[n];
        
        for(int i=0 ; i<n ; i++) {
            if(seen[i] == 0) {
                seen[i] = 1;
                if(!isBipartite(graph, i, -1, 1, seen))
                    return false;
            }
        }
        return true;
    }
    
    private boolean isBipartite(int[][] graph, int cur, int prev, int prevColor, int[] seen) {
        int[] nbrs = graph[cur];
        for(int nbr : nbrs) {
            // if(nbr != prev) {                
                if(seen[nbr] == 0) {
                    int curColor = prevColor==1 ? -1 : 1;
                    seen[nbr] = curColor;
                    
                    if(!isBipartite(graph, nbr, prev, curColor, seen))
                        return false;
                } else if(seen[nbr] == prevColor)
                    return false;
            // }
        }
        return true;
    }
}