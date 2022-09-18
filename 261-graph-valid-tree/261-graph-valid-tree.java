class Solution {
    
    // 1) Recursive DFS
    /*
        Conditions:
            - graph should be fully connected. A single component.
            - graph should not contain any cycle
    */
    public boolean validTree(int n, int[][] edges) {
        if(n<2)
            return true;
        if(edges==null || edges.length==0)
            return false;
        
        List<Integer>[] adjList = getAdjList(n, edges);
        Set<Integer> visited = new HashSet<>();
        
        int src = edges[0][0];
        visited.add(src);
        return !containsCycleDfs(src, -1, adjList, visited) && visited.size()==n;
    }
    
    private boolean containsCycleDfs(Integer src, Integer prev, List<Integer>[] adjList, Set<Integer> visited) {
        List<Integer> nbrs = adjList[src];
        for(int nbr : nbrs) {
            if(nbr==prev)
                continue;
            
            if(visited.contains(nbr))
                return true;
            
            visited.add(nbr);
            if(containsCycleDfs(nbr, src, adjList, visited))
                return true;
        }
        return false;
    }
    
    private List<Integer>[] getAdjList(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];
        for(int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            
            if(adjList[i] == null)
                adjList[i] = new ArrayList<>();
            if(adjList[j] == null)
                adjList[j] = new ArrayList<>();
            
            adjList[i].add(j);
            adjList[j].add(i);
        }
        
        return adjList;
    }
    
    
    
    // 2) BFS
    /*
        Conditions:
            - graph should be fully connected. A single component.
            - graph should not contain any cycle
    */
//     public boolean validTree(int n, int[][] edges) {
        
//     }
    
    
    
    // 3) Advanced Graph Theory + Recursive DFS
    /*
        Conditions:
            - graph should be fully connected. A single component.
            - graph should have exactly n-1 edges
    */
//     public boolean validTree(int n, int[][] edges) {
        
//     }
    
    
    
    // 4) Advanced Graph Theory + BFS
    /*
        Conditions:
            - graph should be fully connected. A single component.
            - graph should have exactly n-1 edges
    */
//     public boolean validTree(int n, int[][] edges) {
        
//     }
    
    
    
    // 5) Advanced Graph Theory + Union Find
    /*
        Conditions:
            - graph should be fully connected. A single component.
            - graph should have exactly n-1 edges
    */
//     public boolean validTree(int n, int[][] edges) {
        
//     }
}