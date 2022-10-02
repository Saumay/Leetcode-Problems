class Solution {
    
    // 1) Topological Sort
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<Integer>[] adjList = new ArrayList[n];
        int[] indegree = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        int[] order = new int[n];
        int count = 0;
        
        // Create adjacency list
        for(int i=0 ; i<n ; i++)
            adjList[i] = new ArrayList<>();
        
        // Populate adjacency List and indegrees array
        for(int[] prerequisite : prerequisites) {
            int src = prerequisite[1];
            int dest = prerequisite[0];
            
            adjList[src].add(dest);
            indegree[dest]++;
        }
        
        // Populate Queue with nodes having indegree 0
        for(int i=0 ; i<n ; i++) {
            if(indegree[i]==0)
                q.add(i);
        }
        
        // Start removing from queue, and reducing indegree
        while(!q.isEmpty()) {
            int cur = q.remove();
            order[count++] = cur;
            
            for(int nbr : adjList[cur]) {
                indegree[nbr]--;
                if(indegree[nbr]==0)
                    q.add(nbr);
            }
        }
        return count==n ? order : new int[]{};
    }
}