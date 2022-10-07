class Solution {
    
    // 1) Using DFS + distance array
//     public int networkDelayTime(int[][] times, int n, int k) {
//         int[] dist = new int[n+1];
//         List<int[]>[] adjList = getAdjAndDistList(times, n, dist);
        
//         dist[k] = 0;
//         dfs(adjList, k, 0, dist);
        
//         int maxTime = Integer.MIN_VALUE;
//         for(int i=1 ; i<=n ; i++)
//             maxTime = Math.max(maxTime, dist[i]);
        
//         return maxTime==Integer.MAX_VALUE ? -1 : maxTime;
//     }
    
//     private void dfs(List<int[]>[] adjList, int src, int time, int[] dist) {
//         List<int[]> nbrs = adjList[src];
//         for(int[] nbr : nbrs) {
//             int nbrId = nbr[0];
//             int nbrTime = time+nbr[1];
//             if(nbrTime < dist[nbrId]) {
//                 dist[nbrId] = nbrTime;
//                 dfs(adjList, nbrId, nbrTime, dist);
//             }
//         }
//     }
    
    
    // 2) Using DFS + weight sorted edges + distance array
//     public int networkDelayTime(int[][] times, int n, int k) {
//         int[] dist = new int[n+1];
//         List<int[]>[] adjList = getAdjAndDistList(times, n, dist);
        
//         // Sorting edges to enable greedy approach
//         for(int i=1 ; i<=n ; i++) {
//             Collections.sort(adjList[i], (i1,i2) -> i1[1]-i2[1]);
//         }
        
//         dist[k] = 0;
//         dfs(adjList, k, 0, dist);
        
//         int maxTime = Integer.MIN_VALUE;
//         for(int i=1 ; i<=n ; i++)
//             maxTime = Math.max(maxTime, dist[i]);
        
//         return maxTime==Integer.MAX_VALUE ? -1 : maxTime;
//     }
    
//     private void dfs(List<int[]>[] adjList, int src, int time, int[] dist) {
//         List<int[]> nbrs = adjList[src];
//         for(int[] nbr : nbrs) {
//             int nbrId = nbr[0];
//             int nbrTime = time+nbr[1];
//             if(nbrTime < dist[nbrId]) {
//                 dist[nbrId] = nbrTime;
//                 dfs(adjList, nbrId, nbrTime, dist);
//             }
//         }
//     }
    
    
    // 3) Using BFS + Distance Array
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];        
        List<int[]>[] adjList = getAdjAndDistList(times, n, dist);
        
        for(int i=1 ; i<=n ; i++) {
            Collections.sort(adjList[i], (i1,i2) -> i1[1]-i2[1]);
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {k,0});
        dist[k] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.remove();
            
            List<int[]> nbrs = adjList[cur[0]];
            for(int[] nbr : nbrs) {
                if(dist[cur[0]] + nbr[1] < dist[nbr[0]]) {
                    dist[nbr[0]] = dist[cur[0]] + nbr[1];
                    q.add(new int[] {nbr[0], dist[nbr[0]]});
                }
            }
        }
        
        Integer max = Integer.MIN_VALUE;
        for(int i=1 ; i<=n ; i++) {
            max = Math.max(max, dist[i]);
        }
        return max==Integer.MAX_VALUE ? -1 : max;
    }
    
    
    // 2) Djikstra Algorithm: Using Priority Queue
//     public int networkDelayTime(int[][] times, int n, int k) {
//         int[] dist = new int[n+1];
//         List<int[]>[] adjList = getAdjAndDistList(times, n, dist);
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2) -> i1[1]-i2[1]);
//         pq.add(new int[] {k,0});
//         dist[k] = 0;
        
//         while(!pq.isEmpty()) {
//             int[] cur = pq.poll();
            
//             List<int[]> nbrs = adjList[cur[0]];
//             for(int[] nbr : nbrs) {
//                 if(dist[cur[0]] + nbr[1] < dist[nbr[0]]) {
//                     dist[nbr[0]] = dist[cur[0]] + nbr[1];
//                     pq.offer(new int[] {nbr[0], dist[nbr[0]]});
//                 }
//             }
//         }
        
//         int max = Integer.MIN_VALUE;
//         for(int i=1 ; i<=n ; i++) {
//             max = Math.max(max, dist[i]);
//         }
//         return max==Integer.MAX_VALUE ? -1 : max;
//     }
    
    private List<int[]>[] getAdjAndDistList(int[][] times, int n, int[] dist) {
        List<int[]>[] adjList = new ArrayList[n+1];
        
        for(int i=1 ; i<=n ; i++) {
            adjList[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int[] time : times) {
            int src = time[0];
            int dest = time[1];
            int wt = time[2];
            
            adjList[src].add(new int[]{dest, wt});
        }
        return adjList;
    }
}