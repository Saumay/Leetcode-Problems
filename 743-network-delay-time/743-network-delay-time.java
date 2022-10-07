class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];        
        List<int[]>[] adjList = getAdjList(times, n, dist);
        
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
            System.out.print(dist[i] + ", ");
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