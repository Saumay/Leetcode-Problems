class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjList = getAdjList(n, edges);
        int[] color = new int[n];
        
        return leadsToDestination(adjList, source, destination, color);
    }
    
    private boolean leadsToDestination(List<Integer>[] adjList, int src, int dest, int[] color) {
        
        List<Integer> nbrs = adjList[src];
        if(nbrs.isEmpty()) {
            // color[src] = 2;
            return src==dest;
        }
        
        color[src] = 1;
        for(int nbr : nbrs) {
            if(color[nbr]==0) {
                if(!leadsToDestination(adjList, nbr, dest, color))
                    return false;
            } else if(color[nbr]==1)
                return false;           // cycle exists
        }
        
        color[src] = 2;
        return true;
    }
    
    private List<Integer>[] getAdjList(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];
        
        for(int i=0 ; i<n ; i++)
            adjList[i] = new ArrayList<>();
        
        for(int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
        }
        return adjList;
    }
}