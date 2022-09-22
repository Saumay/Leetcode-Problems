class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adjList = getAdjList(n, edges);
        boolean[] visited = new boolean[n];
        
        int components = 0;
        for(int i=0 ; i<n ; i++) {
            if(!visited[i]) {
                components++;
                dfs(i, adjList, visited);
            }
        }
        return components;
    }
    
    private void dfs(int src, List<Integer>[] adjList, boolean[] visited) {
        List<Integer> nbrs = adjList[src];
        
        for(int nbr : nbrs) {
            if(!visited[nbr]) {
                visited[nbr] = true;
                dfs(nbr, adjList, visited);
            }
        }
    }
    
    private List<Integer>[] getAdjList(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];
        
        for(int i=0 ; i<n ; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            
            adjList[src].add(dest);
            adjList[dest].add(src);
        }
        return adjList;
    }
}