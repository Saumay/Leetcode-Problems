class Solution {
    
    // 1) Topological Sorting: Kahn's Algorithm
//     public int minimumSemesters(int n, int[][] relations) {
//         List<Integer>[] adjList = new ArrayList[n+1];
//         int[] indegree = new int[n+1];
//         Queue<Integer> q = new ArrayDeque<>();
        
//         for(int[] relation : relations) {
//             int src = relation[0];
//             int dest = relation[1];
            
//             if(adjList[src]==null)
//                 adjList[src] = new ArrayList<>();
//             if(adjList[dest]==null)
//                 adjList[dest] = new ArrayList<>();
            
//             adjList[src].add(dest);
//             indegree[dest]++;
//         }
        
//         // Populate Queue
//         for(int i=1 ; i<=n ; i++) {
//             if(indegree[i]==0)
//                 q.add(i);
//         }
        
//         // Perform topological sort using BFS
//         int sems = 0;
//         int courses = 0;
//         while(!q.isEmpty()) {
//             int size = q.size();
            
//             sems++;
//             for(int i=0 ; i<size ; i++) {
//                 int course = q.remove();
//                 courses++;
                
//                 if(adjList[course]!=null) {
//                     for(int nbr : adjList[course]) {
//                         indegree[nbr]--;
//                         if(indegree[nbr]==0)
//                             q.add(nbr);
//                     }
//                 }
//             }
//         }
//         return courses==n ? sems : -1;
//     }
    
    
    // 2) 2 DFS traversals: Check if cycle present + Get the longest path present using DP    
//     public int minimumSemesters(int n, int[][] relations) {
//         List<Integer>[] adjList = getAdjList(n, relations);
//         int[] color = new int[n+1];
        
//         for(int i=1 ; i<=n ; i++) {
//             if(color[i]==0) {
//                 if(cycleExistsDfs(adjList, i, color))
//                     return -1;
//             }
//         }
        
//         int longestPath = 0;
//         int[] pathLen = new int[n+1];
//         for(int i=1 ; i<=n ; i++) {
//             if(pathLen[i]==0)
//                 longestPath = Math.max(longestPath, getLongestPath(adjList, i, pathLen));
//         }
//         return longestPath;
//     }
    
//     private boolean cycleExistsDfs(List<Integer>[] adjList, int src, int[] color) {
//         color[src] = 1;
        
//         List<Integer> nbrs = adjList[src];
//         for(int nbr : nbrs) {
//             if(color[nbr]==0) {
//                 if(cycleExistsDfs(adjList, nbr, color))
//                     return true;
//             } else if(color[nbr]==1) {
//                 return true;
//             }
//         }
        
//         color[src] = 2;
//         return false;
//     }
    
//     private int getLongestPath(List<Integer>[] adjList, int src, int[] pathLen) {
//         if(pathLen[src]>1)
//             return pathLen[src];
        
//         List<Integer> nbrs = adjList[src];
        
//         int longestPath = 1;
//         for(int nbr : nbrs) {
//             longestPath = Math.max(longestPath, getLongestPath(adjList, nbr, pathLen)+1);
//         }
//         pathLen[src] = longestPath;
        
//         return longestPath;
//     }
    
    
    // 3.1) Single DFS traversal: Check if cycle present + Get the longest path present using DP
    // Returning value from dp array
//     public int minimumSemesters(int n, int[][] relations) {
//         List<Integer>[] adjList = getAdjList(n, relations);
//         int[] color = new int[n+1];
//         int longestPath = 1;
        
//         for(int i=1 ; i<=n ; i++) {
//             int pathLen = getLongestPathCombinedDfs(adjList, i, color);
//             if(pathLen==-1)
//                 return -1;
//             longestPath = Math.max(pathLen, longestPath);
//         }
//         return longestPath;
//     }
    
//     private int getLongestPathCombinedDfs(List<Integer>[] adjList, int src, int[] color) {
//         if(color[src]!=0)
//             return color[src];
        
//         color[src] = -1;
        
//         int longestPath = 1;
//         List<Integer> nbrs = adjList[src];
//         for(int nbr : nbrs) {
//             int pathLen = getLongestPathCombinedDfs(adjList, nbr, color);
//             if(pathLen==-1)
//                 return -1;
//             longestPath = Math.max(pathLen+1, longestPath);
//         }
        
//         color[src] = longestPath;
//         return longestPath;
//     }
    
    
    // 3.2) Single DFS traversal: Check if cycle present + Get the longest path present using DP
    // Returning value from dp array
    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] adjList = getAdjList(n, relations);
        int[] color = new int[n+1];
        int longestPath = 1;
        
        for(int i=1 ; i<=n ; i++) {
            if(color[i]==-1)
                return -1;
            else if(color[i]==0)
                longestPath = Math.max(longestPath, getLongestPathCombinedDfs(adjList, i, color));
            else
                longestPath = Math.max(longestPath, color[i]);            
        }
        return longestPath;
    }
    
    private int getLongestPathCombinedDfs(List<Integer>[] adjList, int src, int[] color) {
        color[src] = -1;
        
        int longestPath = 1;
        for(int nbr : adjList[src]) {
            if(color[nbr]==-1)
                return -1;
            else if(color[nbr]==0)
                longestPath = Math.max(longestPath, getLongestPathCombinedDfs(adjList, nbr, color)+1);
            else
                longestPath = Math.max(longestPath, color[nbr]+1);
        }
        color[src] = longestPath;
        
        return longestPath;
    }
    
    private List<Integer>[] getAdjList(int n, int[][] relations) {
        List<Integer>[] adjList = new ArrayList[n+1];
        
        for(int i=1 ; i<=n ; i++)
            adjList[i] = new ArrayList<>();
        
        for(int[] relation : relations)
            adjList[relation[0]].add(relation[1]);

        return adjList;
    }
}