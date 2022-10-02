class Solution {
    
    // 1) Using stack with DFS for finding cycle in Directed Graph
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<Integer>[] adjList = getAdjList(n, prerequisites);
        int[] color = new int[n];
        List<Integer> orderList = new LinkedList<>();
        int[] order = new int[n];
        
        for(int i=0 ; i<n ; i++) {
            if(color[i]==0) {
                if(hasCycle(adjList, i, color, orderList))
                    return new int[]{};
            }
        }
        
        for(int i=0 ; i<n ; i++)
            order[i] = orderList.get(i);
        
        return order;
    }
    
    private boolean hasCycle(List<Integer>[] adjList, int src, int[] color, List<Integer> orderList) {
        color[src] = 1;
        
        List<Integer> nbrs = adjList[src];
        for(int nbr : nbrs) {
            if(color[nbr]==0) {
                if(hasCycle(adjList, nbr, color, orderList))
                    return true;
            } else if(color[nbr]==1)
                return true;
        }
        color[src] = 2;
        orderList.add(0, src);
        
        return false;
    }
    
    private List<Integer>[] getAdjList(int n, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[n];
        
        for(int i=0 ; i<n ; i++)
            adjList[i] = new ArrayList<>();
        
        for(int[] prerequisite : prerequisites) {
            int src = prerequisite[1];
            int dest = prerequisite[0];
            
            adjList[src].add(dest);
        }
        return adjList;
    }
    
    
    // 2) Topological Sort
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         int n = numCourses;
//         List<Integer>[] adjList = new ArrayList[n];
//         int[] indegree = new int[n];
//         Queue<Integer> q = new ArrayDeque<>();
//         int[] order = new int[n];
//         int count = 0;
        
//         // Create adjacency list
//         for(int i=0 ; i<n ; i++)
//             adjList[i] = new ArrayList<>();
        
//         // Populate adjacency List and indegrees array
//         for(int[] prerequisite : prerequisites) {
//             int src = prerequisite[1];
//             int dest = prerequisite[0];
            
//             adjList[src].add(dest);
//             indegree[dest]++;
//         }
        
//         // Populate Queue with nodes having indegree 0
//         for(int i=0 ; i<n ; i++) {
//             if(indegree[i]==0)
//                 q.add(i);
//         }
        
//         // Start removing from queue, and reducing indegree
//         while(!q.isEmpty()) {
//             int cur = q.remove();
//             order[count++] = cur;
            
//             for(int nbr : adjList[cur]) {
//                 indegree[nbr]--;
//                 if(indegree[nbr]==0)
//                     q.add(nbr);
//             }
//         }
//         return count==n ? order : new int[]{};
//     }
}