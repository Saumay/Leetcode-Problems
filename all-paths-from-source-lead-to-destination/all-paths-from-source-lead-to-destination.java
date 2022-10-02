class Solution {
    
    // 1) DFS 1: Mark color first and then call dfs
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjList = getAdjList(n, edges);
        
        int[] color = new int[n];
        color[source] = 1;
        return leadsToDestinationDfs(adjList, source, destination, color);
    }
    
    private boolean leadsToDestinationDfs(List<Integer>[] adjList, int src, int dest, int[] color) {
        List<Integer> nbrs = adjList[src];
        if(nbrs.isEmpty())
            return src==dest;
        
        for(int nbr : nbrs) {
            if(color[nbr]==0) {
                color[nbr] = 1;
                
                if(!leadsToDestinationDfs(adjList, nbr, dest, color))
                    return false;
                
                color[nbr] = 2;
            } else if(color[nbr]==1)
                return false;
        }
        return true;
    }
    
    
    // 2) DFS 2: Call dfs first and then mark node
//     public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
//         List<Integer>[] adjList = getAdjList(n, edges);
        
//         int[] color = new int[n];
//         return leadsToDestinationDfs(adjList, source, destination, color);
//     }
    
//     private boolean leadsToDestinationDfs(List<Integer>[] adjList, int src, int dest, int[] color) {
//         List<Integer> nbrs = adjList[src];
//         if(nbrs.isEmpty())
//             return src==dest;
        
//         color[src] = 1;
//         for(int nbr : nbrs) {
//             if(color[nbr]==0) {
//                 if(!leadsToDestinationDfs(adjList, nbr, dest, color))
//                     return false;
//             } else if(color[nbr]==1) 
//                 return false;
//         }
        
//         color[src] = 2;
//         return true;
//     }
    
    private List<Integer>[] getAdjList(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];
        
        for(int i=0 ; i<n ; i++)
            adjList[i] = new ArrayList<>();
        
        for(int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            
            adjList[src].add(dest);
        }
        return adjList;
    }
}