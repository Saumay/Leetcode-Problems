class Solution {
    
    // 1) Djikstra (TLE exceeded)
//     public int countPaths(int n, int[][] roads) {
//         int mod = (int)(Math.pow(10,9) + 7);
//         List<int[]>[] adjList = getAdjList(n, roads);
        
//         int[] dist = new int[n];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[0] = 0;
        
//         int[] ways = new int[n];
//         ways[0] = 1;
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2) -> i1[1]-i2[1]);
//         pq.add(new int[] {0,0});
        
//         while(!pq.isEmpty()) {
//             int[] cur = pq.poll();
//             int curId = cur[0];
//             int curWt = cur[1];
            
//             List<int[]> nbrs = adjList[curId];
//             for(int[] nbr : nbrs) {
//                 int nbrId = nbr[0];
//                 int nbrWt = nbr[1];
                
//                 int totalCost = curWt + nbrWt;
//                 if(totalCost < dist[nbrId]) {
//                     dist[nbrId] = totalCost;
//                     ways[nbrId] = 1;
//                     pq.add(new int[] {nbrId, totalCost});
//                 }
//                 else if(totalCost == dist[nbrId]) {
//                     ways[nbrId] = (ways[nbrId]+1)%mod;
//                     pq.add(new int[] {nbrId, totalCost});
//                 }
//             }
//         }
//         return ways[n-1]%mod;
//     }
    
    
    // 2) Djikstra + DP
    public int countPaths(int n, int[][] roads) {
        int mod = (int)(Math.pow(10,9) + 7);
        List<int[]>[] adjList = getAdjList(n, roads);
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        int[] ways = new int[n];
        ways[0] = 1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2) -> i1[1]-i2[1]);
        pq.add(new int[] {0,0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curId = cur[0];
            int curWt = cur[1];
            
            if(curId == n-1)
                return ways[n-1]%mod;
            
            List<int[]> nbrs = adjList[curId];
            for(int[] nbr : nbrs) {
                int nbrId = nbr[0];
                int nbrWt = nbr[1];
                
                int totalCost = curWt + nbrWt;
                if(totalCost < dist[nbrId]) {
                    dist[nbrId] = totalCost;
                    pq.add(new int[] {nbrId, dist[nbrId]});
                    ways[nbrId] = ways[curId];
                } else if(totalCost == dist[nbrId]) {
                    ways[nbrId] = (ways[nbrId] + ways[curId])%mod;
                }
            }
        }  
        return -1;
    }
    
    private List<int[]>[] getAdjList(int n, int[][] roads) {
        List<int[]>[] adjList = new ArrayList[n];
        
        for(int i=0 ; i<n ; i++)
            adjList[i] = new ArrayList<>();
        
        for(int[] road: roads) {
            int src = road[0];
            int dest = road[1];
            int wt = road[2];
            
            adjList[src].add(new int[] {dest, wt});
            adjList[dest].add(new int[] {src, wt});
        }
        return adjList;
    }
}