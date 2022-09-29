class Solution {
        
    public int[] findRedundantConnection(int[][] edges) {
        List<Integer>[] adjList = new ArrayList[edges.length+1];
        
        for(int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            
            Set<Integer> seen = new HashSet<>();
            seen.add(src);
            if(pathExists(adjList, src, dest, seen))
                return edge;
            
            if(adjList[src]==null)
                adjList[src] = new ArrayList<>();
            if(adjList[dest]==null)
                adjList[dest] = new ArrayList<>();
            
            adjList[src].add(dest);
            adjList[dest].add(src);
        }
        return new int[]{};
    }
    
    private boolean pathExists(List<Integer>[] adjList, int src, int dest, Set<Integer> seen) {
        if(src==dest)
            return true;
        
        List<Integer> nbrs = adjList[src];
        if(nbrs != null) {
            for(Integer nbr : nbrs) {
                if(!seen.contains(nbr)) {
                    seen.add(nbr);
                    if(pathExists(adjList, nbr, dest, seen))
                        return true;
                }
            }
        }
        return false;
    }
}