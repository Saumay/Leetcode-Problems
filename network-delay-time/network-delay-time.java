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
//     public int networkDelayTime(int[][] times, int n, int k) {
//         int[] dist = new int[n+1];        
//         List<int[]>[] adjList = getAdjAndDistList(times, n, dist);
        
//         Queue<Integer> q = new ArrayDeque<>();
//         q.add(k);
//         dist[k] = 0;
//         while(!q.isEmpty()) {
//             int cur = q.remove();
            
//             List<int[]> nbrs = adjList[cur];
//             for(int[] nbr : nbrs) {
//                 int nbrId = nbr[0];
//                 int nbrTime = dist[cur] + nbr[1];
//                 if(nbrTime < dist[nbrId]) {
//                     dist[nbrId] = nbrTime;
//                     q.add(nbrId);
//                 }
//             }
//         }
        
//         Integer max = Integer.MIN_VALUE;
//         for(int i=1 ; i<=n ; i++) {
//             max = Math.max(max, dist[i]);
//         }
//         return max==Integer.MAX_VALUE ? -1 : max;
//     }
    
    
    // 4) Djikstra Algorithm: Using Priority Queue
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
//                 int nbrTime = cur[1] + nbr[1];
//                 int nbrId = nbr[0];
//                 if(nbrTime < dist[nbrId]) {
//                     dist[nbrId] = nbrTime;
//                     pq.offer(new int[] {nbrId, dist[nbrId]});
//                 }
//             }
//         }
        
//         int max = Integer.MIN_VALUE;
//         for(int i=1 ; i<=n ; i++) {
//             max = Math.max(max, dist[i]);
//         }
//         return max==Integer.MAX_VALUE ? -1 : max;
//     }
    
//     private List<int[]>[] getAdjAndDistList(int[][] times, int n, int[] dist) {
//         List<int[]>[] adjList = new ArrayList[n+1];
        
//         for(int i=1 ; i<=n ; i++) {
//             adjList[i] = new ArrayList<>();
//             dist[i] = Integer.MAX_VALUE;
//         }
        
//         for(int[] time : times) {
//             int src = time[0];
//             int dest = time[1];
//             int wt = time[2];
            
//             adjList[src].add(new int[]{dest, wt});
//         }
//         return adjList;
//     }
    
    
    // 5) Bellman Ford's Algorithm
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        int edges = 0;
        while(edges < n-1) {
            
            for(int[] time : times) {
                int src = time[0];
                int nbr = time[1];
                int cost = time[2];
                
                if(dist[src] != Integer.MAX_VALUE)
                    dist[nbr] = Math.min(dist[nbr], dist[src] + cost);
            }
            edges++;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=1 ; i<=n ; i++)
            max = Math.max(max, dist[i]);
        
        return max==Integer.MAX_VALUE ? -1 : max;
    }
}