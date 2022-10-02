class Solution {
    
    // 1) Check all paths from a node and check if there is a cycle. Nodes which do not have a cycle are the safe nodes.
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int n = graph.length;
//         List<Integer> safeNodes = new LinkedList<>();
//         boolean[] vis = new boolean[n];
        
//         for(int i=0 ; i<n ; i++) {
//             if(!vis[i]) {
//                 vis[i] = true;
//                 boolean res = hasCycleDfs(graph, i, vis);                
//                 vis[i] = false;
                
//                 if(!res)
//                     safeNodes.add(i);
//             }
//         }
//         return safeNodes;
//     }
    
//     private boolean hasCycleDfs(int[][] graph, int src, boolean[] vis) {
//         int[] nbrs = graph[src];
        
//         for(int nbr : nbrs) {
//             if(!vis[nbr]) {
//                 vis[nbr] = true;
//                 boolean res = hasCycleDfs(graph, nbr, vis);                
//                 vis[nbr] = false;
                
//                 if(res)
//                     return true;
                
//             } else
//                 return true;
//         }
//         return false;
//     }
    
    
    // 2) Add all nodes involved in a cycle in a set
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int n = graph.length;
//         List<Integer> safeNodes = new LinkedList<>();
//         Set<Integer> cycleNodes = new HashSet<>();
//         boolean[] vis = new boolean[n];
//         boolean[] pathVis = new boolean[n];
        
//         for(int i=0 ; i<n ; i++) {
//             if(vis[i]) {
//                 if(!cycleNodes.contains(i))
//                     safeNodes.add(i);
//             }
//             else {
//                 vis[i] = true;
//                 cycleNodes.add(i);
//                 pathVis[i] = true;
                
//                 boolean res = hasCycleDfs(graph, i, vis, pathVis, cycleNodes);
                
//                 pathVis[i] = false;
//                 if(!res) {
//                     cycleNodes.remove(i);
//                     safeNodes.add(i);
//                 }
//             }
//         }
//         return safeNodes;
//     }
    
//     private boolean hasCycleDfs(int[][] graph, int src, boolean[] vis, boolean[] pathVis, Set<Integer> cycleNodes) {
//         int[] nbrs = graph[src];
        
//         for(int nbr : nbrs) {
//             if(!vis[nbr]) {
//                 vis[nbr] = true;
//                 cycleNodes.add(nbr);
//                 pathVis[nbr] = true;
//                 boolean res = hasCycleDfs(graph, nbr, vis, pathVis, cycleNodes);
//                 pathVis[nbr] = false;
                
//                 if(res) {
//                     return true;
//                 } else {
//                     cycleNodes.remove(nbr);
//                 }
                
//             } else if(pathVis[nbr] || cycleNodes.contains(nbr))
//                 return true;
//         }
//         return false;
//     }
    
    
    // 3.1) Use color array to mark visited and visiting nodes (Mark color first and then call dfs)
    // 0(white) -> node is not visited
    // 1(grey) -> node is part of a cycle
    // 2(black) -> node is safe
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int n = graph.length;
//         int[] color = new int[n];
//         List<Integer> safeNodes = new LinkedList<>();
        
//         for(int i=0 ; i<n ; i++) {
//             if(color[i]==0) {
//                 color[i] = 1;
//                 if(!hasCycleDfs(graph, i, color))
//                     color[i] = 2;
//             }
            
//             if(color[i]==2) {
//                 safeNodes.add(i);
//             }
//         }
//         return safeNodes;
//     }
    
//     private boolean hasCycleDfs(int[][] graph, int src, int[] color) {
//         int[] nbrs = graph[src];
        
//         for(int nbr : nbrs) {
//             if(color[nbr]==0) {
//                 color[nbr] = 1;
//                 if(hasCycleDfs(graph, nbr, color))
//                     return true;
//                 color[nbr] = 2;
//             } else if(color[nbr]==1)
//                 return true;
//         }
//         return false;
//     }
    
    
    // 3.2) Use color array to mark visited and visiting nodes (Call dfs first and then mark node)
    // 0(white) -> node is not visited
    // 1(grey) -> node is part of a cycle
    // 2(black) -> node is safe
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int n = graph.length;
//         List<Integer> safeNodes = new LinkedList<>();
        
//         int[] color = new int[n];
        
//         for(int i=0 ; i<n ; i++) {
//             if(color[i]==0) {
//                 hasCycleDfs(graph, i, color);
//             }
            
//             if(color[i]==2) {
//                 safeNodes.add(i);
//             }
//         }
//         return safeNodes;
//     }
    
//     private boolean hasCycleDfs(int[][] graph, int src, int[] color) {
//         color[src] = 1;
        
//         int[] nbrs = graph[src];
//         for(int nbr : nbrs) {
//             if(color[nbr] == 0) {
//                 if(hasCycleDfs(graph, nbr, color)) 
//                     return true;
//             } else if(color[nbr]==1)
//                 return true;
//         }
//         color[src] = 2;
        
//         return false;
//     }
    
    
    // 4) Reverse edges
    public List<Integer> eventualSafeNodes(int[][] G) {
        int n = G.length;
        
        List<Integer> safeNodes = new LinkedList<>();
        Set<Integer>[] graph = new HashSet[n];
        Set<Integer>[] rGraph = new HashSet[n];
        boolean[] safe = new boolean[n];
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0 ; i<n ; i++) {
            graph[i] = new HashSet<>();
            rGraph[i] = new HashSet<>();
        }
        
        for(int src=0 ; src<n ; src++) {
            if(G[src].length==0)
                q.add(src);
            
            for(int nbr : G[src]) {
                graph[src].add(nbr);
                rGraph[nbr].add(src);
            }
        }
        
        while(!q.isEmpty()) {
            int safeNode = q.remove();
            safe[safeNode] = true;
            
            for(int rNbr : rGraph[safeNode]) {
                graph[rNbr].remove(safeNode);
                
                if(graph[rNbr].isEmpty())
                    q.add(rNbr);
            }
        }
        
        for(int i=0 ; i<safe.length ; i++) {
            if(safe[i])
                safeNodes.add(i);
        }
        
        return safeNodes;
    }
}