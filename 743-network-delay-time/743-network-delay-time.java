class Solution {
    
    // 1) Djikstra Algorithm: Using Queue
//     public int networkDelayTime(int[][] times, int n, int k) {
//         int[] dist = new int[n+1];        
//         List<int[]>[] adjList = getAdjList(times, n, dist);
        
//         Queue<int[]> q = new ArrayDeque<>();
//         q.add(new int[] {k,0});
//         dist[k] = 0;
        
//         while(!q.isEmpty()) {
//             int[] cur = q.remove();
            
//             List<int[]> nbrs = adjList[cur[0]];
//             for(int[] nbr : nbrs) {
//                 if(dist[cur[0]] + nbr[1] < dist[nbr[0]]) {
//                     dist[nbr[0]] = dist[cur[0]] + nbr[1];
//                     q.add(new int[] {nbr[0], dist[nbr[0]]});
//                 }
//             }
//         }
        
//         Integer max = Integer.MIN_VALUE;
//         for(int i=1 ; i<=n ; i++) {
//             max = Math.max(max, dist[i]);
//         }
//         return max==Integer.MAX_VALUE ? -1 : max;
//     }
    
    
    // 2) Djikstra Algorithm: Using Priority Queue
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        List<int[]>[] adjList = getAdjList(times, n, dist);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2) -> i1[1]-i2[1]);
        pq.add(new int[] {k,0});
        dist[k] = 0;
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            List<int[]> nbrs = adjList[cur[0]];
            for(int[] nbr : nbrs) {
                if(dist[cur[0]] + nbr[1] < dist[nbr[0]]) {
                    dist[nbr[0]] = dist[cur[0]] + nbr[1];
                    pq.offer(new int[] {nbr[0], dist[nbr[0]]});
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=1 ; i<=n ; i++) {
            max = Math.max(max, dist[i]);
        }
        return max==Integer.MAX_VALUE ? -1 : max;
    }
    
    private List<int[]>[] getAdjList(int[][] times, int n, int[] dist) {
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