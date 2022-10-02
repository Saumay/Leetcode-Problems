class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjList = getAdjList(n, edges);
        
        int[] color = new int[n];
        return leadsToDestinationDfs(adjList, source, destination, color);
    }
    
    private boolean leadsToDestinationDfs(List<Integer>[] adjList, int src, int dest, int[] color) {
        List<Integer> nbrs = adjList[src];
        if(nbrs.isEmpty())
            return src==dest;
        
        color[src] = 1;
        for(int nbr : nbrs) {
            if(color[nbr]==0) {
                if(!leadsToDestinationDfs(adjList, nbr, dest, color))
                    return false;
            } else if(color[nbr]==1) 
                return false;
        }
        
        color[src] = 2;
        return true;
    }
    
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