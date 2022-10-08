class Solution {
    
    // 1) BFS upto k stops
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adjList = getAdjList(n, flights);
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {src, 0});
        
        int stops = 0;
        while(!q.isEmpty() && stops<=k) {
            int size = q.size();
            
            for(int i=0 ; i<size ; i++) {
                int[] cur = q.remove();
                int curId = cur[0];
                int curWt = cur[1];
                
                List<int[]> nbrs = adjList[curId];
                for(int[] nbr : nbrs) {
                    int nbrId = nbr[0];
                    int nbrWt = nbr[1];
                    int totalCost = curWt + nbrWt;
                    
                    if(totalCost < dist[nbrId]) {
                        dist[nbrId] = totalCost;
                        q.add(new int[] {nbrId, dist[nbrId]});
                    }
                }
            }
            stops++;
        }
        return dist[dst]==Integer.MAX_VALUE ? -1 : dist[dst];
    }
    
    
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         List<int[]>[] adjList = getAdjList(n, flights);
        
//         int[] dist = new int[n];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[src] = 0;
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2) -> i1[1]-i2[1]);
//         pq.add(new int[] {src, 0});
        
//         int stops = 0;
//         while(!pq.isEmpty() && stops<=k+1) {
//             int size = pq.size();
            
//             for(int i=0 ; i<size ; i++) {
//                 int[] cur = pq.poll();
//                 int curId = cur[0];
//                 int curWt = cur[1];
                
//                 if(curId==dst)
//                     return curWt;
                
//                 List<int[]> nbrs = adjList[curId];
//                 for(int[] nbr : nbrs) {
//                     int nbrId = nbr[0];
//                     int nbrWt = nbr[1];
//                     int totalCost = curWt + nbrWt;
                    
//                     if(totalCost < dist[nbrId]) {
//                         dist[nbrId] = totalCost;
//                         pq.offer(new int[] {nbrId, dist[nbrId]});
//                     }
//                 }
//             }
//             stops++;
//         }
//         return -1;
//     }
    
    private List<int[]>[] getAdjList(int n, int[][] flights) {
        List<int[]>[] adjList = new ArrayList[n];
        
        for(int i=0 ; i<n ; i++) 
            adjList[i] = new ArrayList<>();
        
        for(int[] flight : flights)
            adjList[flight[0]].add(new int[] {flight[1], flight[2]});
        
        return adjList;
    }
}