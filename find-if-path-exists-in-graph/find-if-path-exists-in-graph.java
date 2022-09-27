class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjMap = getAdjMap(n, edges);
        
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> seen = new HashSet<>();
        q.add(source);
        seen.add(source);
        
        while(!q.isEmpty()) {
            Integer src = q.remove();
            
            if(src==destination)
                return true;
            
            List<Integer> nbrs = adjMap[src];
            for(Integer nbr : nbrs) {
                if(seen.contains(nbr))
                    continue;
                
                seen.add(nbr);
                q.add(nbr);
            }
        }
        return false;
    }
    
    private List<Integer>[] getAdjMap(int n, int[][] edges) {
        List<Integer>[] adjMap = new ArrayList[n];
        
        for(int i=0 ; i<n ; i++)
            adjMap[i] = new ArrayList<>();
        
        for(int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            
            adjMap[src].add(dest);
            adjMap[dest].add(src);
        }
        
        return adjMap;
    }
}