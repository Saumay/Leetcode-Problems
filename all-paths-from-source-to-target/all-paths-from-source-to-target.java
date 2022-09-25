class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> paths = new ArrayList<>();
        
        int src = 0;
        int dest = n-1;
        boolean[] seen = new boolean[n];
        List<Integer> path = new LinkedList<>();
        
        path.add(src);
        seen[src] = true;
        dfs(graph, src, dest, seen, path, paths);
        return paths;
    }
    
    private void dfs(int[][] graph, int src, int dest, boolean[] seen, List<Integer> path, List<List<Integer>> paths) {
        if(src==dest) {
            paths.add(new LinkedList<>(path));
            return;
        }
        
        int[] nbrs = graph[src];
        for(int nbr : nbrs) {
            if(!seen[nbr]) {
                seen[nbr] = true;
                path.add(nbr);
                
                dfs(graph, nbr, dest, seen, path, paths);
                
                seen[nbr] = false;
                path.remove(path.size()-1);
            }
        }
    }
}