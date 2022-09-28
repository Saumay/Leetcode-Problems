class Solution {
    
    // 1) BFS
//     private int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
//     public int orangesRotting(int[][] grid) {
//         if(grid==null || grid.length==0)
//             return -1;
        
//         int m = grid.length;
//         int n = grid[0].length;
        
//         int fresh = 0;
//         Queue<int[]> q = new ArrayDeque<>();
//         for(int i=0 ; i<m ; i++) {
//             for(int j=0 ; j<n ; j++) {
//                 if(grid[i][j] == 2)
//                     q.add(new int[] {i,j});
//                 else if(grid[i][j] == 1)
//                     fresh++;
//             }
//         }
        
//         if(fresh==0)
//             return 0;
        
//         int time=-1;
//         while(!q.isEmpty()) {
//             int size = q.size();
                       
//             for(int i=0 ; i<size ; i++) {
//                 int[] cell = q.remove();
                
//                 for(int[] dir : dirs) {
//                     int nbrI = cell[0] + dir[0];
//                     int nbrJ = cell[1] + dir[1];
                    
//                     if(nbrI>=0 && nbrJ>=0 && nbrI<m && nbrJ<n && grid[nbrI][nbrJ]==1) {
//                         fresh--;
//                         grid[nbrI][nbrJ] = 2;
//                         q.add(new int[] {nbrI, nbrJ});
//                     }
//                 }
//             }
//             time++;
//         }
//         return fresh>0 ? -1 : time;
//     }
    
    
    // 2) In place BFS: Without queue
    private int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0)
            return -1;
        
        int timestamp = 0;
        while(hasMoreOrangesToRot(grid, timestamp+2))
            timestamp++;
        
        for(int i=0 ; i<grid.length ; i++) {
            for(int j=0 ; j<grid[0].length ; j++) {
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        
        return timestamp;
    }
    
    private boolean hasMoreOrangesToRot(int[][] grid, int timestamp) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean shouldContinue = false;
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(grid[i][j] == timestamp) {
                    
                    for(int[] dir : dirs) {
                        int nbrI = i + dir[0];
                        int nbrJ = j + dir[1];
                        
                        if(nbrI>=0 && nbrJ>=0 && nbrI<m && nbrJ<n && grid[nbrI][nbrJ]==1) {
                            grid[nbrI][nbrJ] = timestamp+1;
                            shouldContinue = true;
                        }
                    }
                    
                }
            }
        }
        return shouldContinue;
    }
}