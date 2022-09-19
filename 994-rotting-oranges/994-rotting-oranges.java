class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(grid[i][j] == 2)
                    q.add(new int[] {i, j});
                
                if(grid[i][j] == 1)
                    fresh++;
            }
        }
        
        if(fresh==0)
            return 0;
        if(q.isEmpty())
            return -1;
        
        int[][] dirs = new int[][] {{0,-1}, {-1,0}, {1,0}, {0,1}};        
        int time=-1;
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0 ; i<size ; i++) {
                int[] cur = q.remove();
                
                for(int[] dir : dirs) {
                    int nbrI = cur[0] + dir[0];
                    int nbrJ = cur[1] + dir[1];

                    if(nbrI>=0 && nbrI<m && nbrJ>=0 && nbrJ<n && grid[nbrI][nbrJ]==1) {
                        grid[nbrI][nbrJ] = 2;
                        q.add(new int[] {nbrI, nbrJ});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh>0 ? -1 : time;
    }
}