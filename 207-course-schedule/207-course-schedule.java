class Solution {
    
    // 1) DFS 1: Cycle Detection in DG (Call dfs first and then mark node)
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         List<Integer>[] adjList = getAdjList(numCourses, prerequisites);
        
//         int[] color = new int[numCourses];
//         for(int i=0 ; i<numCourses ; i++) {
//             if(color[i]==0 && cycleExistsDfs1(adjList, i, color))
//                 return false;
//         }
//         return true;
//     }
    
//     private boolean cycleExistsDfs1(List<Integer>[] adjList, int src, int[] color) {
//         color[src] = 1;
        
//         List<Integer> nbrs = adjList[src];
//         for(int nbr : nbrs) {
//             if(color[nbr]==0) {
//                 if(cycleExistsDfs1(adjList, nbr, color))
//                     return true;
//             } else if(color[nbr]==1)
//                 return true;
//         }
        
//         color[src] = 2;
//         return false;
//     }
    
    
    // 2) DFS 2: Cycle Detection in DG (Mark node and then call dfs)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = getAdjList(numCourses, prerequisites);
        int[] color = new int[numCourses];
        
        for(int i=0 ; i<numCourses ; i++) {
            if(color[i]==0) {
                color[i] = 1;
                if(cycleExistsDfs2(adjList, i, color))
                    return false;
                color[i] = 2;
            }
        }
        return true;
    }
    
    private boolean cycleExistsDfs2(List<Integer>[] adjList, int src, int[] color) {
        List<Integer> nbrs = adjList[src];
        
        for(int nbr : nbrs) {
            if(color[nbr]==0) {
                color[nbr] = 1;
                if(cycleExistsDfs2(adjList, nbr, color))
                    return true;
                color[nbr] = 2;
            } else if(color[nbr] == 1)
                return true;
        }
        return false;
    }
    
    private List<Integer>[] getAdjList(int n, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[n];
        
        for(int i=0 ; i<n ; i++)
            adjList[i] = new ArrayList<>();
        
        for(int[] course : prerequisites) {
            adjList[course[0]].add(course[1]);
        }
        return adjList;
    }
}