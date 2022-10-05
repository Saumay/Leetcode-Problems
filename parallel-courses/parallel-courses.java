class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] adjList = new ArrayList[n+1];
        int[] indegree = new int[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        
        // Create adjacency list
        for(int i=1 ; i<=n ; i++)
            adjList[i] = new ArrayList<>();
        
        for(int[] relation : relations) {
            int src = relation[0];
            int dest = relation[1];
            
            adjList[src].add(dest);
            indegree[dest]++;
        }
        
        // Populate Queue
        for(int i=1 ; i<=n ; i++) {
            if(indegree[i]==0)
                q.add(i);
        }
        
        // Perform topological sort using BFS
        int sems = 0;
        int courses = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            sems++;
            for(int i=0 ; i<size ; i++) {
                int course = q.remove();
                courses++;
                
                for(int nbr : adjList[course]) {
                    indegree[nbr]--;
                    if(indegree[nbr]==0)
                        q.add(nbr);
                }
            }
        }
        return courses==n ? sems : -1;
    }
}