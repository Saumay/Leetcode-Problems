class Solution {
    
    // 1) Cycle Detection in DG using DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = getAdjList(numCourses, prerequisites);
        
        int[] color = new int[numCourses];
        for(int i=0 ; i<numCourses ; i++) {
            if(color[i]==0 && cycleExistsDfs(adjList, i, color))
                return false;
        }
        return true;
    }
    
    private boolean cycleExistsDfs(List<Integer>[] adjList, int src, int[] color) {
        color[src] = 1;
        
        List<Integer> nbrs = adjList[src];
        for(int nbr : nbrs) {
            if(color[nbr]==0) {
                if(cycleExistsDfs(adjList, nbr, color))
                    return true;
            } else if(color[nbr]==1)
                return true;
        }
        
        color[src] = 2;
        return false;
    }
    
    private List<Integer>[] getAdjList(int n, int[][] courses) {
        List<Integer>[] adjList = new ArrayList[n];
        
        for(int i=0 ; i<n ; i++)
            adjList[i] = new ArrayList<>();
        
        for(int[] course : courses) {
            adjList[course[0]].add(course[1]);
        }
        return adjList;
    }
}