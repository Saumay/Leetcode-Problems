class Solution {
    
    // 1) DFS: Recursive
//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         int n = graph.length;
//         List<List<Integer>> paths = new ArrayList<>();
        
//         int src = 0;
//         int dest = n-1;
        
//         // boolean[] seen = new boolean[n];     // Not required, since it's a DAG
//         List<Integer> path = new LinkedList<>();
//         path.add(src);
//         dfs(graph, src, dest, path, paths);
//         return paths;
//     }
    
//     private void dfs(int[][] graph, int src, int dest, List<Integer> path, List<List<Integer>> paths) {
//         if(src==dest) {
//             paths.add(new LinkedList<>(path));
//             return;
//         }
        
//         int[] nbrs = graph[src];
//         for(int nbr : nbrs) {
//             path.add(nbr);
//             dfs(graph, nbr, dest, path, paths);
//             path.remove(path.size()-1);
//         }
//     }
    
    
    // 2) Recursion (Method returning paths)    
//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         int src = 0;
//         int dest = graph.length-1;
        
//         return getAllPaths(graph, src, dest);
//     }
    
//     private List<List<Integer>> getAllPaths(int[][] graph, int src, int dest) {
//         List<List<Integer>> paths = new ArrayList<>();
//         if(src==dest) {
//             paths.add(new LinkedList<>());
//             paths.get(0).add(src);
//             return paths;
//         }
        
//         int[] nbrs = graph[src];
//         for(int nbr : nbrs) {
//             paths.addAll(getAllPaths(graph, nbr, dest));
//         }
//         for(List<Integer> path : paths) {
//             path.add(0, src);
//         }
//         return paths;
//     }
    
    
    // 3) DP: Recursion + Memoization
//     private Map<Integer, List<List<Integer>>> cache = new HashMap<>();
    
//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         int src = 0;
//         int dest = graph.length-1;
        
//         return getAllPaths(graph, src, dest);
//     }
    
//     private List<List<Integer>> getAllPaths(int[][] graph, int src, int dest) {
//         List<List<Integer>> paths = new ArrayList<>();
//         if(src==dest) {
//             paths.add(new LinkedList<>());
//             paths.get(0).add(src);
//             return paths;
//         }
//         if(cache.containsKey(src)) {
//             return cache.get(src);
//         }
        
//         int[] nbrs = graph[src];
//         for(int nbr : nbrs) {
//             List<List<Integer>> nbrPaths = getAllPaths(graph, nbr, dest);
//             for(List<Integer> nbrPath : nbrPaths) {
//                 List<Integer> newPath = new LinkedList<>(nbrPath);
//                 newPath.add(0, src);
//                 paths.add(newPath);
//             }
//         }
        
//         cache.put(src, paths);
//         return paths;
//     }
    
    
    // 3) BFS
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int src = 0;
        int dest = graph.length-1;
        
        // Set<Integer> seen = new HashSet<>();        // Not required, since it's a DAG
        List<List<Integer>> paths = new LinkedList<>();
        Queue<List<Integer>> q = new ArrayDeque<>();
        List<Integer> path = new LinkedList<>();
        path.add(src);
        q.add(path);
        
        while(!q.isEmpty()) {
            List<Integer> srcPath = q.remove();
            
            int cur = srcPath.get(srcPath.size()-1);
            if(cur == dest) {
                paths.add(srcPath);
                continue;
            }
            
            for(int nbr : graph[cur]) {      
                List<Integer> nbrPath = new LinkedList<>(srcPath);
                nbrPath.add(nbr);
                q.add(nbrPath);
            }
        }
        return paths;
    }
}