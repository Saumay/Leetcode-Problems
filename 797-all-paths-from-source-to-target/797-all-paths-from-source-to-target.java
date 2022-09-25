class Solution {
    
    // 1) DFS: Recursive
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> paths = new ArrayList<>();
        
        int src = 0;
        int dest = n-1;
        
        // boolean[] seen = new boolean[n];     // Not required, since it's a DAG
        List<Integer> path = new LinkedList<>();
        path.add(src);
        dfs(graph, src, dest, path, paths);
        return paths;
    }
    
    private void dfs(int[][] graph, int src, int dest, List<Integer> path, List<List<Integer>> paths) {
        if(src==dest) {
            paths.add(new LinkedList<>(path));
            return;
        }
        
        int[] nbrs = graph[src];
        for(int nbr : nbrs) {
            path.add(nbr);
            dfs(graph, nbr, dest, path, paths);
            path.remove(path.size()-1);
        }
    }
}