class Solution {
    
    // 1) Backtracking
//     private int minEffort = Integer.MAX_VALUE;
    
//     private final int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
//     public int minimumEffortPath(int[][] heights) {
//         int m = heights.length;
//         int n = heights[0].length;
        
//         boolean[][] visited = new boolean[m][n];
//         visited[0][0] = true;
//         backtrack(heights, 0, 0, 0, visited);
        
//         return minEffort;
//     }
    
//     private void backtrack(int[][] heights, int i, int j, int effort, boolean[][] visited) {
//         int m = heights.length;
//         int n = heights[0].length;
        
//         if(i==m-1 && j==n-1) {
//             minEffort = Math.min(minEffort, effort);
//             return;
//         }
        
//         for(int[] dir : dirs) {
//             int nbrI = i+dir[0];
//             int nbrJ = j+dir[1];
            
//             if(nbrI>=0 && nbrJ>=0 && nbrI<m && nbrJ<n && !visited[nbrI][nbrJ]) {
//                 visited[nbrI][nbrJ] = true;
                
//                 int nbrEffort = Math.max(effort, Math.abs(heights[i][j] - heights[nbrI][nbrJ]));
//                 backtrack(heights, nbrI, nbrJ, nbrEffort, visited);
                
//                 visited[nbrI][nbrJ] = false;
//             }
//         }
//     }
    
    
    // 2.1) Djikstra's Algorithm without early exit
    private final int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2) -> i1[2]-i2[2]);
        pq.add(new int[] {0,0,0});
        
        Integer[][] dist = new Integer[m][n];
        dist[0][0] = 0;
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curI = cur[0];
            int curJ = cur[1];
            
            for(int[] dir : dirs) {
                int nbrI = cur[0] + dir[0];
                int nbrJ = cur[1] + dir[1];
                
                if(nbrI>=0 && nbrJ>=0 && nbrI<m && nbrJ<n) {
                    int nbrDist = Math.max(cur[2], Math.abs(heights[curI][curJ] - heights[nbrI][nbrJ]));
                    if(dist[nbrI][nbrJ]==null || (nbrDist<dist[nbrI][nbrJ])) {
                        dist[nbrI][nbrJ] = nbrDist;
                        pq.add(new int[] {nbrI, nbrJ, nbrDist});
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
    
    
    // 2) Djikstra's Algorithm
//     private final int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    
//     public int minimumEffortPath(int[][] heights) {
//         int m = heights.length;
//         int n = heights[0].length;
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2) -> i1[2]-i2[2]);
//         pq.add(new int[] {0,0,0});
        
//         Integer[][] dist = new Integer[m][n];
//         dist[0][0] = 0;
        
//         while(!pq.isEmpty()) {
//             int[] cur = pq.poll();
//             int curI = cur[0];
//             int curJ = cur[1];
            
//             // Cirtical: If destination is polled from the queue, we know that there can't be any better path to reach than what we currently have
//             if(curI==m-1 && curJ==n-1)
//                 return cur[2];
            
//             for(int[] dir : dirs) {
//                 int nbrI = cur[0] + dir[0];
//                 int nbrJ = cur[1] + dir[1];
                
//                 if(nbrI>=0 && nbrJ>=0 && nbrI<m && nbrJ<n) {
//                     int nbrDist = Math.max(cur[2], Math.abs(heights[curI][curJ] - heights[nbrI][nbrJ]));
//                     if(dist[nbrI][nbrJ]==null || (nbrDist<dist[nbrI][nbrJ])) {
//                         dist[nbrI][nbrJ] = nbrDist;
//                         pq.add(new int[] {nbrI, nbrJ, nbrDist});
//                     }
//                 }
//             }
//         }
//         return 0;
//     }
}